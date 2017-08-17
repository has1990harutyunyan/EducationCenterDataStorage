package educationCenterCollection;

import educationCenterCollection.model.Lesson;
import educationCenterCollection.model.Student;
import educationCenterCollection.model.User;
import educationCenterCollection.model.UserType;

import java.util.*;


public class EducationCenter implements CommandsManager, CommandsUser {
    private static Scanner scanner = new Scanner(System.in);
    private static DataStorage dataStorage = new DataStorage();

    static java.util.Date registerDate = new java.util.Date();


    public static void main(String[] args) {

        login();

    }


    static void login() {

        User user1 = new User(UserType.MANAGER, "Manager1", "Manager1", 15, registerDate, "manager1@gmail.com", "1234");
        User user2 = new User(UserType.MANAGER, "Manager2", "Manager2", 20, registerDate, "MedStudent@mail.ru", "789");
        User user3 = new User(UserType.USER, "User1", "User1", 17, registerDate, "Java@gmail.com", "456hh");
        User user4 = new User(UserType.USER, "User2", "User2", 46, registerDate, "user@mail.ru", "art");
        User user5 = new User(UserType.USER, "User3", "User3", 50, registerDate, "user361@mail.ru", "artandart");


        dataStorage.userMap.put(user1.getUsername(), user1);
        dataStorage.userMap.put(user2.getUsername(), user2);
        dataStorage.userMap.put(user3.getUsername(), user3);
        dataStorage.userMap.put(user4.getUsername(), user4);
        dataStorage.userMap.put(user5.getUsername(), user5);

        // printUsers();// If you want to see all the users, activate this method.

        System.out.println("Input your username and password.");
        String usernameAndPassword = scanner.next();
        String[] entryData = usernameAndPassword.split(",");
        String username = entryData[0];
        String password = entryData[1];
        User user = dataStorage.getUsernameAndPassword(username, password);
        if (user != null) {
            switch (user.getUserType()) {
                case MANAGER:
                    boolean b = true;
                    while (b) {
                        commandsForManager();
                        int number = scanner.nextInt();

                        switch (number) {
                            case CommandsManager.EXIT:
                                b = false;
                                break;

                            case CommandsManager.ADD_STUDENTS:
                                addStudent();
                                break;
                            case CommandsManager.ADD_LESSON:
                                addLesson();
                                break;
                            case CommandsManager.PRINT_STUDENTS:
                                printStudents();
                                break;
                            case CommandsManager.PRINT_LESSONS:
                                printLessons();
                                break;
                            case CommandsManager.CHANGE_STUDENT_LESSON:
                                changeStudentLesson();
                                break;
                            case CommandsManager.PRINT_STUDENTS_BY_LESSON_NAME:
                                printStudentsByLesson();
                                break;
                            default:
                                System.out.println("Invalid input number.");

                        }
                    }

                    break;

                case USER:
                    boolean c = true;
                    while (c) {
                        commandsForUser();
                        int number = scanner.nextInt();

                        switch (number) {
                            case CommandsUser.EXIT:
                                c = false;
                                break;
                            case CommandsUser.PRINT_STUDENTS:
                                printStudents();
                                break;
                            case CommandsUser.PRINT_LESSONS:
                                printLessons();
                                break;
                            case CommandsUser.PRINT_STUDENTS_BY_LESSON_NAME:
                                printStudentsByLesson();
                                break;
                            default:
                                System.out.println("Invalid input number.");
                        }

                        break;
                    }
            }
        } else {
            login();
        }
    }


    static void commandsForManager() {
        System.out.println("Input " + CommandsManager.EXIT + " to EXIT.");
        System.out.println("Input " + CommandsManager.ADD_STUDENTS + " to ADD_STUDENTS.");
        System.out.println("Input " + CommandsManager.ADD_LESSON + " to ADD_LESSON.");
        System.out.println("Input " + CommandsManager.PRINT_STUDENTS + " to PRINT_STUDENTS.");
        System.out.println("Input " + CommandsManager.PRINT_LESSONS + " to PRINT_LESSONS.");
        System.out.println("Input " + CommandsManager.CHANGE_STUDENT_LESSON + " to CHANGE_STUDENT_LESSON.");
        System.out.println("Input " + CommandsManager.PRINT_STUDENTS_BY_LESSON_NAME + " to PRINT_STUDENTS_BY_LESSON_NAME.");
    }

    static void commandsForUser() {
        System.out.println("Input " + CommandsUser.EXIT + " to EXIT.");
        System.out.println("Input " + CommandsUser.PRINT_STUDENTS + " to PRINT_STUDENTS.");
        System.out.println("Input " + CommandsUser.PRINT_LESSONS + " to PRINT_LESSONS.");
        System.out.println("Input " + CommandsUser.PRINT_STUDENTS_BY_LESSON_NAME + " to PRINT_STUDENTS_BY_LESSON_NAME.");
    }


    static void addStudent() {

        Lesson[] lesson = null;

        if (dataStorage.lessonList.size() > 0) {
            System.out.println("Choose from the list.");
            dataStorage.printLesson();
            String lessonName = scanner.next();
            String[] lessonNameArray = lessonName.split(",");


            Lesson[] temp = new Lesson[lessonNameArray.length];
            for (int i = 0; i < temp.length; i++) {
                temp[i] = dataStorage.getLessonByName(lessonNameArray[i]);
            }

            ArrayList<Lesson> tempList = new ArrayList<>(Arrays.asList(temp));
            try {
                System.out.println("Please input student data by name, surname, id,  phone, email.");
                String studentData = scanner.next();
                String[] StudentDataArray = studentData.split(",");
                Student student1 = new Student(StudentDataArray[0], StudentDataArray[1], Integer.parseInt(StudentDataArray[2]), StudentDataArray[3], StudentDataArray[3], registerDate, tempList);
                dataStorage.studentsList.add(student1);
                Collections.sort(dataStorage.studentsList, new idComparator());
                for (Student st : dataStorage.studentsList) {
                    System.out.println(st);
                }

            } catch (NumberFormatException e) {
                System.out.println("Please, input only numbers in the field of id.");
            }
        } else {
            System.out.println("the List is empty.");
        }
    }


    static void addLesson() {

        System.out.println("Please input lesson by splitting: name, duration, price, lecturerName");
        String lessonData = scanner.next();
        String[] lessonDataArray = lessonData.split(",");
        try {
            Lesson lesson1;
            lesson1 = new Lesson(lessonDataArray[0], Integer.parseInt(lessonDataArray[1]), Double.parseDouble(lessonDataArray[2]), lessonDataArray[3]);
            dataStorage.lessonList.add(lesson1);
        } catch (NumberFormatException e) {
            System.out.println("Caught" + e);
        }


    }

    static void printStudents() {
        if (dataStorage.studentsList.isEmpty()) {
            System.out.println("List is empty.No students added yet.");
        } else {
            dataStorage.printStudent();
        }


    }


    static void printLessons() {

        if (dataStorage.lessonList.isEmpty()) {
            System.out.println("List is empty.No lessons added yet.");
        } else {
            System.out.println("All the lessons in the list.");
            dataStorage.printLesson();
        }
    }

    static void printStudentsByLesson() {
        System.out.println("IPrint the lessons..");
        dataStorage.printLesson();
        System.out.println("Input the lesson name.");
        String name = scanner.next();

        dataStorage.printStudentsByLessonName(name);


    }


    static void changeStudentLesson() {
        dataStorage.printStudent();
        System.out.println("Choose the name of the student whose lessons should be changed.");
        String studentName = scanner.next();
        dataStorage.printStudentByName(studentName);
        System.out.println("        ");
        dataStorage.printLesson();
        String lessonName = scanner.next();
        String lessonNameArray[] = lessonName.split(",");


        Lesson[] newArray = new Lesson[lessonNameArray.length];

        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = dataStorage.getLessonByName(lessonNameArray[i]);

            ArrayList<Lesson> changeLesson = new ArrayList<>(Arrays.asList(newArray));


            dataStorage.getStudentByName(studentName).setLesson(changeLesson);

            dataStorage.printStudent();
        }


    }


}
