package org.example.model;
import lombok.Data;
import org.example.Base;
import java.util.ArrayList;
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
protected List<Integer> chatId=new ArrayList<>();
protected  List<Integer > notification=new ArrayList<>();

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
}
