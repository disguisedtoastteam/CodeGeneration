package entities.views;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ImageView")
public class ImageView extends View {

    private String src;

    @XmlAttribute(name = "tools:src")
    public String getSrc() {
        return "@tools:sample/avatars";
    }

    public void setSrc(String src) {
        this.src = src;
    }
}
