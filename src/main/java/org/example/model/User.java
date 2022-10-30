package org.example.model;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
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
protected ArrayList<Integer> groupsId = new ArrayList<>();

    public User() {

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
