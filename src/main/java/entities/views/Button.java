package entities.views;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Button")
public class Button extends View {

    private String text;

    @XmlAttribute(name = "android:text")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
