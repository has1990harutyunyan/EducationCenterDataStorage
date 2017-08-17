package educationCenterCollection.model;

/**
 * Created by Hasmik on 05.04.2017.
 */
public class Lesson {
    private String name;
    private int duration;
    private double price;
    private String lecturerName;


    public Lesson(String name, int duration, double price, String lecturerName) {

        this.name = name;
        this.duration = duration;
        this.price = price;
        this.lecturerName = lecturerName;

    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public double getPrice() {
        return price;
    }

    public String getLecturerName() {
        return lecturerName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setLecturerName(String lecturerName) {
        this.lecturerName = lecturerName;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "name='" + name + '\'' +
                ", duration=" + duration +
                ", price=" + price +
                ", lecturerName='" + lecturerName + '\'' +
                '}';

    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}