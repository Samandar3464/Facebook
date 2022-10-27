package org.example.dto;

import org.example.model.User;
import org.example.service.ChatService;
import org.example.service.NotificationService;
import org.example.service.UserService;

import java.io.IOException;
import java.util.Scanner;



public class UserDto {

    static Scanner scannerStr=new Scanner(System.in);
    static Scanner scannerInt=new Scanner(System.in);
    static UserService userService=new UserService();

    static ChatService chatService=new ChatService();

    public User registrationFront() {
        User user = new User();
        System.out.println("FIRST NAME : ");
        String firstName = scannerStr.nextLine();
        user.setFirstName(firstName);
        System.out.println("LAST NAME: ");
        String lastName = scannerStr.nextLine();
        user.setLastName(lastName);
        System.out.println("USER NAME: ");
        String userName = scannerStr.nextLine();
        user.setUserName(userName);
        System.out.println("PHONE NUMBER: ");
        String phoneNumber = scannerStr.nextLine();
        user.setPhoneNumber(phoneNumber);
        System.out.println("ENTER PASSWORD: ");
        String password = scannerStr.nextLine();
        user.setPassword(password);
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
        return user;
    }

    public boolean uptoDateAccountFront(User user) {
        System.out.println(user);
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
    public  boolean add(User user) throws IOException {
       return userService.registration(user);
    }

    public static boolean logIn() throws IOException {
        System.out.println("Enter phoneNumber or your gmail: ");
        String phoneNumber=scannerStr.nextLine();
        System.out.println("Enter PASSWORD: ");
        String password=scannerStr.nextLine();

        User login = userService.logIn(phoneNumber,password);
        if (login!=null){
            return true;
        }
        return false;
    }
}
