package org.example.model;
import lombok.Data;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
@Getter
@Setter
public class User extends Base {
private String firstName;
private String lastName;
private String phoneNumber;
private String password;
private String userName;
private  String gender;
private String birthDay;
protected List<Integer> friendsId=new ArrayList<>(); // patpisatsa qilingan kantaktlar
protected ArrayList<Integer> chatId=new ArrayList<>();

    public User() {

    }

    public User(String firstName, String lastName, String phoneNumber, String password, String confirm, String gender, String birthday) {
    }

    public User(String firstName, String lastName, String phoneNumber, String password, String gender, String birthDay) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.gender = gender;
        this.birthDay = birthDay;
    }


    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", gender='" + gender + '\'' +
                ", birthDay='" + birthDay + '\'' +
                '}';

    }
}
