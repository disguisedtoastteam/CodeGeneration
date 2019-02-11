package entities;

import com.google.gson.annotations.SerializedName;

public class Box {
    @SerializedName(value = "xmin")
    private double xMin;
    @SerializedName(value = "ymin")
    private double yMin;
    @SerializedName(value = "xmax")
    private double xMax;
    @SerializedName(value = "ymax")
    private double yMax;

    public Box() {
    }

    public Box(double xMin, double yMin, double xMax, double yMax) {
        this.xMin = xMin;
        this.yMin = yMin;
        this.xMax = xMax;
        this.yMax = yMax;
    }

    public double getWidth() {
        return xMax - xMin;
    }

    public double getHeight() {
        return yMax - yMin;
    }

    public double getxMin() {
        return xMin;
    }

    public void setxMin(double xMin) {
        this.xMin = xMin;
    }

    public double getyMin() {
        return yMin;
    }

    public void setyMin(double yMin) {
        this.yMin = yMin;
    }

    public double getxMax() {
        return xMax;
    }

    public void setxMax(double xMax) {
        this.xMax = xMax;
    }

    public double getyMax() {
        return yMax;
    }

    public void setyMax(double yMax) {
        this.yMax = yMax;
    }
}
