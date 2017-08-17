package educationCenterCollection.model;

import java.util.Date;

/**
 * Created by Hasmik on 25.04.2017.
 */
public class User {
    private UserType userType;
    private String name;
    private String surname;
    private int age;
    private Date registerDate;
    private String username;
    private String password;

    public User(UserType userType, String name, String surname, int age, Date registerDate, String username, String password) {
        this.userType = userType;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.registerDate = registerDate;
        this.username = username;
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    @Override
    public String toString() {
        return "User{" +
                "userType=" + userType +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", registerDate=" + registerDate +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
