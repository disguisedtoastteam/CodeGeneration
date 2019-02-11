package entities.views;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public abstract class View {

    private String id;
    private String width;
    private String height;
    private String margin;
    private String marginTop;
    private String marginBottom;
    private String marginRight;
    private String marginLeft;
    private String topToTop;
    private String topToBottom;
    private String bottomToBottom;
    private String bottomToTop;
    private String rightToRight;
    private String rightToLeft;
    private String leftToLeft;
    private String leftToRight;
    private String widthDefault = "percent";
    private String widthPercent;
    private String horizontalBias;
    private String VerticalBias;

    @XmlAttribute(name = "android:id")
    public String getId() {
        return "@+id/" + id;
    }

    public String getSimpleId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    @XmlAttribute(name = "android:layout_margin")
    public String getMargin() {
        return margin;
    }

    public void setMargin(String margin) {
        this.margin = margin;
    }

    @XmlAttribute(name = "android:layout_marginTop")
    public String getMarginTop() {
        return marginTop;
    }

    public void setMarginTop(String marginTop) {
        this.marginTop = marginTop;
    }

    @XmlAttribute(name = "android:layout_marginBottom")
    public String getMarginBottom() {
        return marginBottom;
    }

    public void setMarginBottom(String marginBottom) {
        this.marginBottom = marginBottom;
    }

    @XmlAttribute(name = "android:layout_marginRight")
    public String getMarginRight() {
        return marginRight;
    }

    public void setMarginRight(String marginRight) {
        this.marginRight = marginRight;
    }

    @XmlAttribute(name = "android:layout_marginLeft")
    public String getMarginLeft() {
        return marginLeft;
    }

    public void setMarginLeft(String marginLeft) {
        this.marginLeft = marginLeft;
    }

    @XmlAttribute(name = "app:layout_constraintTop_toTopOf")
    public String getTopToTop() {
        return topToTop;
    }

    public void setTopToTop(String topToTop) {
        this.topToTop = topToTop;
    }

    @XmlAttribute(name = "app:layout_constraintTop_toBottomOf")
    public String getTopToBottom() {
        return topToBottom;
    }

    public void setTopToBottom(String topToBottom) {
        this.topToBottom = topToBottom;
    }

    @XmlAttribute(name = "app:layout_constraintBottom_toBottomOf")
    public String getBottomToBottom() {
        return bottomToBottom;
    }

    public void setBottomToBottom(String bottomToBottom) {
        this.bottomToBottom = bottomToBottom;
    }

    @XmlAttribute(name = "app:layout_constraintBottom_toTopOf")
    public String getBottomToTop() {
        return bottomToTop;
    }

    public void setBottomToTop(String bottomToTop) {
        this.bottomToTop = bottomToTop;
    }

    @XmlAttribute(name = "app:layout_constraintRight_toRightOf")
    public String getRightToRight() {
        return rightToRight;
    }

    public void setRightToRight(String rightToRight) {
        this.rightToRight = rightToRight;
    }

    @XmlAttribute(name = "app:layout_constraintRight_toLeftOf")
    public String getRightToLeft() {
        return rightToLeft;
    }

    public void setRightToLeft(String rightToLeft) {
        this.rightToLeft = rightToLeft;
    }

    @XmlAttribute(name = "app:layout_constraintLeft_toLeftOf")
    public String getLeftToLeft() {
        return leftToLeft;
    }

    public void setLeftToLeft(String leftToLeft) {
        this.leftToLeft = leftToLeft;
    }

    @XmlAttribute(name = "app:layout_constraintLeft_toRightOf")
    public String getLeftToRight() {
        return leftToRight;
    }

    public void setLeftToRight(String leftToRight) {
        this.leftToRight = leftToRight;
    }

    @XmlAttribute(name = "app:layout_constraintWidth_default")
    public String getWidthDefault() {
        return widthDefault;
    }

    public void setWidthDefault(String widthDefault) {
        this.widthDefault = widthDefault;
    }

    @XmlAttribute(name = "app:layout_constraintWidth_percent")
    public String getWidthPercent() {
        return widthPercent;
    }

    public void setWidthPercent(String widthPercent) {
        this.widthPercent = widthPercent;
    }

    @XmlAttribute(name = "app:layout_constraintHorizontal_bias")
    public String getHorizontalBias() {
        return horizontalBias;
    }

    public void setHorizontalBias(String horizontalBias) {
        this.horizontalBias = horizontalBias;
    }

    @XmlAttribute(name = "app:layout_constraintVertical_bias")
    public String getVerticalBias() {
        return VerticalBias;
    }

    public void setVerticalBias(String verticalBias) {
        VerticalBias = verticalBias;
    }

    @Override
    public String toString() {
        return "View{" +
                "id='" + id + '\'' +
                ", width='" + width + '\'' +
                ", height='" + height + '\'' +
                ", marginTop='" + marginTop + '\'' +
                ", marginLeft='" + marginLeft + '\'' +
                ", topToTop='" + topToTop + '\'' +
                ", topToBottom='" + topToBottom + '\'' +
                ", leftToLeft='" + leftToLeft + '\'' +
                ", leftToRight='" + leftToRight + '\'' +
                ", widthPercent='" + widthPercent + '\'' +
                "}\n";
    }
}
