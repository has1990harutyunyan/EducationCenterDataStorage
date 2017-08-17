package educationCenterCollection.model;

import java.util.ArrayList;
import java.util.Date;

public class Student  {
    private String name;
    private String surname;
    private Integer id;
    private String phone;
    private String email;
    private java.util.Date registerDate;
    private ArrayList<Lesson> lesson;


    public Student(String name, String surname, Integer id, String phone, String email, Date registerDate, ArrayList<Lesson> lesson) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.phone = phone;
        this.email = email;
        this.registerDate = registerDate;
        this.lesson = lesson;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public ArrayList<Lesson> getLesson() {
        return lesson;
    }

    public void setLesson(ArrayList<Lesson> lesson) {
        this.lesson = lesson;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", id=" + id +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", registerDate=" + registerDate +
                ", lesson=" + lesson +
                '}';
    }
}


