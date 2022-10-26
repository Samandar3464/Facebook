package org.example;


import org.example.dto.NotificationDto;
import org.example.dto.UserDto;
import org.example.model.Notification;
import org.example.model.User;
import org.example.service.NotificationService;
import org.example.service.UserService;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scannerStr = new Scanner(System.in);
    static Scanner scannerInt = new Scanner(System.in);
    static UserDto userDto = new UserDto();
    static NotificationDto notificationDto = new NotificationDto();
    static NotificationService notificationService = new NotificationService();
    static User user;
    public static UserService userService = new UserService();

    public static void main(String[] args) throws IOException {
        DataBase.start();
        int mainCase = 10;
        while (mainCase != 0) {
            System.out.println("1.Registration 2.Log In 0.Exit");
            mainCase = scannerInt.nextInt();
            switch (mainCase) {
                case 1 -> {
                    user = userDto.registrationFront();
                    if (userService.registration(user))
                        System.out.println("Successfully");
                    else System.out.println("This phone already have in Facebook");
                }
                case 2 -> {
                    user = userDto.logInFront();
                    if (user == null) {
                        System.out.println("Account not found");
                    } else {
                        account();
                    }
                }
                case 0 -> {
                    DataBase.save();
                    return;
                }
            }
        }
    }


    private  void account() throws IOException {
        int var = 10;
        while (var != 0) {
            System.out.println("1.Account Sittings 2. Add post 3. Notifications 4.Chat 0.Exit account ");
            var = scannerInt.nextInt();
            if (var == 0) {
                DataBase.save();
            }
            switch (var) {
                case 1 -> {
                    System.out.println(userDto.uptoDateAccountFront(user));
                }
                case 2 -> {

                }
                case 3 -> {
                    notificationDto.notification(user);
                    System.out.println("\n" + "Enter requestId for acceptance or delete");
                    int requestId = scannerInt.nextInt();
                    Notification notification=notificationService.getNotificationById(requestId);
                    if (notification.getType().equals("request")) {
                        System.out.println(notification.getNotificationMessage());
                        System.out.println("For acceptance request enter 'y' , for rejection enter 'n' ");
                        String s = scannerStr.nextLine();
                        if (s.equals('y')) {
                            user.getFriendsId().add(notification.getSenderId());
                            userService.getById(notification.getSenderId()).getFriendsId().add(user.getId());
                        } else if (s.equals('n')) {
                            notification.setActive(false);
                        } else {
                            System.out.println("Please enter only (y or n)");
                        }
                    } else if (notification.getType().equals("post")) {
                        System.out.println(notification.getNotificationMessage());
                    }
                }
                case 4 -> {

                }
                case 0 -> {

                }
            }
        }
    }
}