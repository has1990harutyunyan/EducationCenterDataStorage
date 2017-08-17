package educationCenterCollection;

import educationCenterCollection.model.Lesson;
import educationCenterCollection.model.Student;
import educationCenterCollection.model.User;

import java.util.*;


public class DataStorage {


    public Map<String, User> userMap = new TreeMap<>();
    Set<Map.Entry<String, User>> set = userMap.entrySet();
    public List<Lesson> lessonList = new ArrayList<>();
    public List<Student> studentsList = new ArrayList<>();



    public void printStudent() {
        for (Student student : studentsList) {
            System.out.println(student);
        }
    }


    public void printLesson() {
        for (Lesson lesson : lessonList) {
            System.out.println(lesson);
        }
    }

    public void printUser() {

        for (Map.Entry<String, User> m : set) {
            String s = m.getKey();
            User u = m.getValue();
            System.out.println(s + " " + u);

        }
    }

    public User getUsernameAndPassword(String username, String password) {

        for (Map.Entry<String, User> m : set) {
            if (m.getValue().getUsername().equals(username) && m.getValue().getPassword().equals(password))
                return m.getValue();
        }
        return null;
    }

    public Lesson getLessonByName(String name) {
        for (Lesson lesson : lessonList) {

            if (lesson.getName().equals(name))
                return lesson;
        }


        return null;

    }


    public void printStudentsByLessonName(String name) {

        for (Student st : studentsList) {
            for (Lesson ls : st.getLesson()) {
                if (ls.getName().equals(name)) {
                    System.out.println(st);
                }
            }

        }
    }




    public void printStudentByName(String name) {

        for (Student student : studentsList) {
            if (student.getName().equals(name)) {
                System.out.println(student);
            }
        }
    }


    public Student getStudentByName(String name) {

        for (Student student : studentsList) {
            if (student.getName().equals(name))
                return student;
        }

        return null;
    }


}
