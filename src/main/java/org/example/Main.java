package org.example;

import org.example.dto.UserDto;
import org.example.model.User;
import org.example.service.UserService;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static UserService userService=new UserService();
    public static void main(String[] args) throws IOException {
        Scanner scanner=new Scanner(System.in);
        Scanner scannerInt =new Scanner(System.in);
        DataBase.start();
        int var=10;
        while (var!=0){

            System.out.println("1. REGISTRATION  2.LOG IN  0.BACK");
            int choose=scanner.nextInt();
            if(!(choose>=0&&choose<3)){
                System.out.println("Wrong choice! Please try again.");
                continue;
            }
            while (true){
                byte count=0;
                System.out.println("PHONE NUMBER: +998 ");
                String phoneNumber=scanner.nextLine();
                if(phoneNumber.length()==9){
                    for(byte i=0; i<phoneNumber.length();i++){
                        if(Character.isDigit(phoneNumber.charAt(i))){
                            count++;
                        }
                    }
                }else {
                    System.out.println("Phone number have to be 9 digit ! Please try again.");
                    continue;
                }


            }
            //userService.receiveTheCode()
        }
        DataBase.save();



    }
}