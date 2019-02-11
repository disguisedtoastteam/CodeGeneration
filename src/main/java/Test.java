import entities.Box;
import entities.DetectedObject;
import entities.views.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws JAXBException {
        List<DetectedObject> objects = new ArrayList<>();
        objects.add(new DetectedObject(DetectedObject.FRAME, new Box(0, 0, 10, 2)));
        objects.add(new DetectedObject(DetectedObject.IMAGE, new Box(3.5, 2, 6.5, 3)));
        objects.add(new DetectedObject(DetectedObject.EditText, new Box(2.5, 3, 7.5, 4)));
        objects.add(new DetectedObject(DetectedObject.EditText, new Box(2, 6, 4, 8)));
        objects.add(new DetectedObject(DetectedObject.BUTTON, new Box(5, 6.4, 8, 7.4)));
        objects.add(new DetectedObject(DetectedObject.BUTTON, new Box(3, 10, 5, 13)));
        JAXBContext jc = JAXBContext.newInstance(ConstraintLayout.class);
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        ConstraintLayout layout = new ConstraintLayout();
        layout.setWidth("match_parent");
        layout.setHeight("match_parent");
        for (View view : CodeGenerator.parse(objects)) {
            if (view instanceof Button) {
                if (layout.getButtons() == null) {
                    layout.setButtons(new ArrayList<>());
                }
                layout.getButtons().add((Button) view);
            }
            if (view instanceof ImageView) {
                if (layout.getImageViews() == null) {
                    layout.setImageViews(new ArrayList<>());
                }
                layout.getImageViews().add((ImageView) view);
            }
            if (view instanceof EditText) {
                if (layout.getEditTexts() == null) {
                    layout.setEditTexts(new ArrayList<>());
                }
                layout.getEditTexts().add((EditText) view);
            }
        }
        marshaller.marshal(layout, System.out);
    }
}
