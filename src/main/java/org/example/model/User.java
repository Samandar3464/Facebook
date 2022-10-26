package org.example.model;
import lombok.Data;
import org.example.Base;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
@Data
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

    public User(String firstName, String lastName, String phoneNumber, String password, String gender, String birthDay) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.gender = gender;
        this.birthDay = birthDay;
    }
}
