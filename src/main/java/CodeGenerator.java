import entities.DetectedObject;
import entities.views.Button;
import entities.views.EditText;
import entities.views.ImageView;
import entities.views.View;

import java.util.ArrayList;
import java.util.List;

public class CodeGenerator {

    public static List<View> parse(List<DetectedObject> objects) {
        //find frame and remove it from list
        DetectedObject frame = null;
        for (DetectedObject object : objects) {
            if (object.getClasse() == DetectedObject.FRAME) {
                frame = object;
                objects.remove(object);
                break;
            }
        }
        if (frame == null || objects.isEmpty()) {
            return new ArrayList<>();
        }

        //order by y ascending
        objects.sort((a, b) -> {
            if (a.getBox().getyMin() - b.getBox().getyMin() > 0) {
                return 1;
            }
            if (a.getBox().getyMin() - b.getBox().getyMin() < 0) {
                return -1;
            }
            return 0;
        });

        //TODO: what if an object takes many rows in height
        //group horizontally adjacent objects
        List<List<ObjectWrapper>> grid = new ArrayList<>();
        List<ObjectWrapper> neighbors = new ArrayList<>();
        grid.add(neighbors);
        int i = 1;
        for (DetectedObject object : objects) {
            if (neighbors.isEmpty() || areNeighbors(object, neighbors.get(0).detectedObject)) {
                View view = getViewInstance(object);
                if (view == null) continue;
                view.setId(view.getClass().getSimpleName() + i);
                if (view instanceof Button) {
                    ((Button) view).setText(view.getSimpleId());
                }
                neighbors.add(new ObjectWrapper(view, object));
            } else {
                neighbors = new ArrayList<>();
                View view = getViewInstance(object);
                if (view == null) continue;
                view.setId(view.getClass().getSimpleName() + i);
                if (view instanceof Button) {
                    ((Button) view).setText(view.getSimpleId());
                }
                neighbors.add(new ObjectWrapper(view, object));
                grid.add(neighbors);
            }
            i++;
        }

        //sort adjacent objects by x
        for (List<ObjectWrapper> list : grid) {
            list.sort((a, b) -> {
                if (a.detectedObject.getBox().getxMin() - b.detectedObject.getBox().getxMin() > 0) {
                    return 1;
                }
                if (a.detectedObject.getBox().getxMin() - b.detectedObject.getBox().getxMin() < 0) {
                    return -1;
                }
                return 0;
            });
        }

        List<View> views = new ArrayList<>();
        //TODO: consider element being in the center not to the left of parent
        //set size, constraints, and content
        for (i = 0; i < grid.size(); i++) {
            List<ObjectWrapper> list = grid.get(i);
            if (i == 0) { //if this is the top left element in the screen
                list.get(0).view.setTopToTop("parent");
            } else {
                list.get(0).view.setTopToBottom("@id/" + grid.get(i - 1).get(0).view.getSimpleId());
            }
            list.get(0).view.setLeftToLeft("parent");
            list.get(0).view.setMarginTop("8dp");
            list.get(0).view.setWidth("0dp");
            list.get(0).view.setWidthPercent(list.get(0).detectedObject.getBox().getWidth() / frame.getBox().getWidth() + "");
            list.get(0).view.setHeight("wrap_content");

            list.get(0).view.setRightToRight("parent");
            list.get(0).view.setHorizontalBias(
                    Math.max(0, list.get(0).detectedObject.getBox().getxMin() - frame.getBox().getxMin())
                            /
                            Math.max(0, frame.getBox().getWidth() - list.get(0).detectedObject.getBox().getWidth())
                            + ""
            );//if the objected is to the left of frame, count that as 0 margin

            views.add(list.get(0).view);

            for (int j = 1; j < list.size(); j++) {
                list.get(j).view.setTopToTop("@id/" + list.get(0).view.getSimpleId());
                list.get(j).view.setLeftToRight("@id/" + list.get(j - 1).view.getSimpleId());
                list.get(j).view.setWidth("0dp");
                list.get(j).view.setWidthPercent(list.get(j).detectedObject.getBox().getWidth() / frame.getBox().getWidth() + "");
                list.get(j).view.setHeight("wrap_content");

                list.get(j).view.setRightToRight("parent");
                list.get(j).view.setHorizontalBias(
                        (
                                list.get(j).detectedObject.getBox().getxMin()
                                        -
                                        list.get(j - 1).detectedObject.getBox().getxMax()
                        )
                                /
                                (
                                        (frame.getBox().getWidth() - list.get(j - 1).detectedObject.getBox().getxMax())
                                                -
                                                list.get(j).detectedObject.getBox().getWidth()
                                )
                                + ""
                );

                views.add(list.get(j).view);
            }
        }

        return views;
    }

    private static View getViewInstance(DetectedObject object) {
        switch ((int) object.getClasse()) {
            case DetectedObject.BUTTON:
                return new Button();
            case DetectedObject.IMAGE:
                return new ImageView();
            case DetectedObject.EditText:
                return new EditText();
        }
        return null;
    }

    private static boolean areNeighbors(DetectedObject o1, DetectedObject o2) {
        boolean bool = Math.abs(o1.getBox().getyMin() + o1.getBox().getHeight() / 2 - o2.getBox().getyMin() - o2.getBox().getHeight() / 2) <=
                Math.min(o1.getBox().getHeight() / 2, o2.getBox().getHeight() / 2);
        return bool;
    }

    private static class ObjectWrapper {
        View view;
        DetectedObject detectedObject;

        public ObjectWrapper() {

        }

        ObjectWrapper(View view, DetectedObject detectedObject) {
            this.view = view;
            this.detectedObject = detectedObject;
        }

        @Override
        public String toString() {
            return "ObjectWrapper{" +
                    "view=" + view +
                    "}\n";
        }
    }
}
