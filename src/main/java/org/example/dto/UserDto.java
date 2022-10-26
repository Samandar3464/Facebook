package org.example.dto;

import org.example.model.User;
import org.example.service.ChatService;
import org.example.service.NotificationService;
import org.example.service.UserService;

import java.io.IOException;
import java.util.Scanner;

public class UserDto {
    Scanner scannerStr = new Scanner(System.in);
    Scanner scannerInt = new Scanner(System.in);
    UserService userService = new UserService();
    ChatService chatService =new ChatService();
    NotificationService notificationService = new NotificationService();

    public User registrationFront() {
        User user = new User();
        System.out.println("FIRST NAME : ");
        String firstName = scannerStr.nextLine();
        user.setFirstName(firstName);
        System.out.println("LAST NAME: ");
        String lastName = scannerStr.nextLine();
        user.setLastName(lastName);
        System.out.println("PHONE NUMBER: ");
        String phoneNumber = scannerStr.nextLine();
        user.setPhoneNumber(phoneNumber);
        System.out.println("ENTER PASSWORD: ");
        String password = scannerStr.nextLine();
        user.setPassword(password);
//        System.out.println("CONFIRM: ");
//        String confirm=scannerStr.nextLine();
//        if(!confirm.equals(password)){
//            System.out.println("CHECK YOUR PASSWORD! ");
//        }else System.out.println("SUCCESSFULLY! ");

        System.out.println("ENTER YOUR BIRTHDAY: ");
        String birthday = scannerStr.nextLine();
        user.setBirthDay(birthday);
        System.out.println("GENDER: 1.MALE  2.FEMALE ");
        int choseGender = scannerInt.nextInt();
        String gender = "";
        switch (choseGender) {
            case 1 -> {
                gender = "Male";
            }
            case 2 -> {
                gender = "Female";
            }
        }
        user.setGender(gender);
        if (userService.registration(user))
            return user;
        return null;
    }

    public boolean uptoDateAccountFront(User user) {
        userService.showUserAccount(user);
        System.out.println("What do you want to change ?");
        int a = 10;
        while (a != 0) {
            System.out.println("1.FirstName 2.LastName 3. Password  4.Birthday 5.Gender 0.back");
            a = scannerInt.nextInt();
            switch (a) {
                case 1 -> {
                    System.out.println("enter new FirstName");
                    user.setFirstName(scannerStr.nextLine());
                }
                case 2 -> {
                    System.out.println("enter new LastName");
                    user.setLastName(scannerStr.nextLine());
                }
                case 3 -> {
                    System.out.println("enter new password");
                    user.setFirstName(scannerStr.nextLine());
                }
                case 4 -> {
                    System.out.println("enter new birthday");
                    user.setFirstName(scannerStr.nextLine());
                }
                case 5 -> {
                    System.out.println("GENDER: 1.MALE  2.FEMALE ");
                    int choseGender = scannerInt.nextInt();
                    String gender = "";
                    switch (choseGender) {
                        case 1 -> {
                            gender = "Male";
                        }
                        case 2 -> {
                            gender = "Female";
                        }
                    }
                    user.setGender(gender);

                }
                case 0 -> {
                }
            }
        }
        return true;
    }

    public User logInFront() {
        System.out.println("Enter phoneNumber ");
        String phone = scannerStr.nextLine();
        System.out.println("Enter password ");
        String password = scannerStr.nextLine();
        return userService.logIn(phone, password);
    }

    public void notification(User user) throws IOException {
        int var = 10;
        while (var != 0) {
            System.out.println("1. Your all notifications");
            notificationService.showNotificationDefaultUser(user);
            System.out.println("\n" + "Enter requestId for acceptance or delete");
            int requestId = scannerInt.nextInt();
            System.out.println(notificationService.OneRequest(user, requestId));
            System.out.println("For acceptance request enter 'y' , for rejection enter 'n' ");
            String s = scannerStr.nextLine();
            if (s.equals('y')) {
                user.getFriendsId().add(notificationService.getById(requestId));
                userService.getById(notificationService.getById(requestId)).getFriendsId().add(user.getId());
            } else if (s.equals('n')) {
                System.out.println(notificationService.deleteRequest(user, requestId));
            } else {
                System.out.println("Please enter only (y or n)");
            }
        }
    }

    public  void chatFront(User user){
        int var=10;
        while (var!=0){
            chatService.showChats(user.getChatId(), user.getId());
            System.out.println("\n"+" 1.Add chat 2.Chat with one contact 3. Delete chat");
           var=scannerInt.nextInt();
            switch (var){
            case 1->{
                userService.showFriends(user);

            }
            case 2->{
                System.out.println();
              //  chatService.getChatById(user.getChatId())
            }
            case 3->{}
            case 0->{}
            }
        }
    }
}
