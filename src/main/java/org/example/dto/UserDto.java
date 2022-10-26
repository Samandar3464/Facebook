package org.example.dto;

import org.example.model.User;
import org.example.service.UserService;

import java.io.IOException;
import java.util.Scanner;

public class UserDto {
    static Scanner scanner=new Scanner(System.in);
    static Scanner scannerInt=new Scanner(System.in);
    static UserService userService=new UserService();

    public static User registration(){
        System.out.println("FIRST NAME : ");
        String firstName=scanner.nextLine();
        System.out.println("LAST NAME: ");
        String lastName=scanner.nextLine();
        System.out.println("PHONE NUMBER: ");

        System.out.println("ENTER PASSWORD: ");
        String password=scanner.nextLine();
        System.out.println("CONFIRM: ");
        String confirm=scanner.nextLine();
        if(!confirm.equals(password)){
            System.out.println("CHECK YOUR PASSWORD! ");
        }else System.out.println("SUCCESSFULLY! ");

        System.out.println("ENTER YOUR BIRTHDAY: ");
        String birthday=scanner.nextLine();
        System.out.println("GENDER: 1.MALE  2.FEMALE ");
        int choseGender=scannerInt.nextInt();
        String gender="";
        switch (choseGender){
            case 1->{
                gender="Male";
            }
            case 2->{
                gender="Female";
            }
        }

return new User(firstName,lastName,phoneNumber,password,confirm,gender,birthday);

    }
    public  boolean add(User user) throws IOException {
       return userService.registration(registration());
    }

    public static boolean logIn() throws IOException {
        System.out.println("Enter phoneNumber or your gmail: ");
        String phoneNumber=scanner.nextLine();
        System.out.println("Enter PASSWORD: ");
        String password=scanner.nextLine();

        User login = userService.login(phoneNumber, password);
        if (login!=null){
            return true;
        }
        return false;
    }
}