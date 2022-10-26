package org.example;

import org.example.dto.UserDto;
import org.example.model.User;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Scanner scannerStr = new Scanner(System.in);
   static Scanner scannerInt = new Scanner(System.in);
   static UserDto userDto = new UserDto();
   static User user;
    public static void main(String[] args) throws IOException {
        DataBase.start();
        int mainCase = 10;
        while (mainCase != 0) {
            System.out.println("1.Registration 2.Log In 0.Exit");
            mainCase = scannerInt.nextInt();
            switch (mainCase) {
                case 1 -> {
                    User user = userDto.registrationFront();
                      if (user != null) {
                        System.out.println("Successfully");
                    } else {
                        System.out.println("This phone already have in Facebook");
                    }
                }
                case 2 -> {
                    user = userDto.logInFront();
                    if (user == null) {
                        System.out.println("Account not found");
                    } else {

                    }
                }
                case 0 -> {
                    DataBase.save();
                    return;
                }
            }
        }
    }

    private static void account() {
        int var = 10;
        while (var != 0) {
            System.out.println("1.Account Sittings 2. Add post 3. Notifications 4.Chat 0.Exit account");
            var=scannerInt.nextInt();
        switch (var){
            case 1->{
                System.out.println(userDto.uptoDateAccountFront(user));
            }
            case 2->{

            }
            case 3->{

            }
            case 4->{}
            case 0->{}
        }
        }
    }
}