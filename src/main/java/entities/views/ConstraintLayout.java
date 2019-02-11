package entities.views;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "android.support.constraint.ConstraintLayout")
public class ConstraintLayout {

    private String width;
    private String height;
    private List<Button> buttons;
    private List<ImageView> imageViews;
    private List<EditText> editTexts;
    private String app;
    private String android;
    private String tools;

    @XmlAttribute(name = "android:layout_width")
    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    @XmlAttribute(name = "android:layout_height")
    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    @XmlElement(name = "Button")
    public List<Button> getButtons() {
        return buttons;
    }

    public void setButtons(List<Button> buttons) {
        this.buttons = buttons;
    }

    @XmlElement(name = "ImageView")
    public List<ImageView> getImageViews() {
        return imageViews;
    }

    public void setImageViews(List<ImageView> imageViews) {
        this.imageViews = imageViews;
    }

    @XmlElement(name = "EditText")
    public List<EditText> getEditTexts() {
        return editTexts;
    }

    public void setEditTexts(List<EditText> editTexts) {
        this.editTexts = editTexts;
    }

    @XmlAttribute(name = "xmlns:app")
    public String getApp() {
        return "http://schemas.android.com/apk/res-auto";
    }

    public void setApp(String app) {
        this.app = app;
    }

    @XmlAttribute(name = "xmlns:android")
    public String getAndroid() {
        return "http://schemas.android.com/apk/res/android";
    }

    public void setAndroid(String android) {
        this.android = android;
    }

    @XmlAttribute(name = "xmlns:tools")
    public String getTools() {
        return "http://schemas.android.com/tools";
    }

    public void setTools(String tools) {
        this.tools = tools;
    }
}
