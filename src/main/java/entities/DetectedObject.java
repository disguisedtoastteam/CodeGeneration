package entities;

import com.google.gson.annotations.SerializedName;

public class DetectedObject {

    public static final int FRAME = 2;
    public static final int BUTTON = 3;
    public static final int IMAGE = 4;
    public static final int EditText = 1;

    private Box box;
    @SerializedName(value = "class")
    private double classe;
    private double score;

    public DetectedObject() {
    }

    public DetectedObject(double classe, Box box) {
        this.box = box;
        this.classe = classe;
    }

    public DetectedObject(Box box, double classe, double score) {
        this.box = box;
        this.classe = classe;
        this.score = score;
    }

    public Box getBox() {
        return box;
    }

    public void setBox(Box box) {
        this.box = box;
    }

    public double getClasse() {
        return classe;
    }

    public void setClasse(double classe) {
        this.classe = classe;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
