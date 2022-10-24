package org.example.dto;

import org.example.model.User;

import java.util.Scanner;

public class UserDto {
    Scanner scanner=new Scanner(System.in);
    Scanner scannerInt=new Scanner(System.in);
    public User registration(){
        System.out.println("FIRST NAME : ");
        String firstName=scanner.nextLine();
        System.out.println("LAST NAME: ");
        String lastName=scanner.nextLine();
        System.out.println("PHONE NUMBER: ");
        String phoneNumber=scanner.nextLine();
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
        return new User(firstName,lastName,phoneNumber,password,gender,birthday);
    }
}

