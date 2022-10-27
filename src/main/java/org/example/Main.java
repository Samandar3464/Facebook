package org.example;

import org.example.dto.*;
import org.example.model.*;
import org.example.service.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scannerStr = new Scanner(System.in);
    static Scanner scannerInt = new Scanner(System.in);
    static User user;


    //    DTO
    static UserDto userDto = new UserDto();
    static NotificationDto notificationDto = new NotificationDto();
    static MessageDto messageDto = new MessageDto();
    static ChatDto chatDto = new ChatDto();
    static CommitDto commitDto = new CommitDto();
    static PostDto postDto = new PostDto();


    //    SERVICES
    static UserService userService = new UserService();
    static ChatService chatService = new ChatService();
    static MessageService messageService = new MessageService();
    static CommitService commitService = new CommitService();
    static NotificationService notificationService = new NotificationService();
    static PostService postService = new PostService();

    public static void main(String[] args) throws IOException {
        ArrayList arrayList = new ArrayList();
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
                    else System.out.println("This phone already have in Facebook or This user name already have");
                }
                case 2 -> {
                    user = userDto.logInFront();
                    if (user == null) {
                        System.out.println("Account not found");
                    } else {
                        account(user);
                    }
                }
                case 0 -> {
                    DataBase.save();
                    return;
                }
            }
        }
    }


    private static void account(User currentUser) throws IOException {
        int var = 10;
        while (var != 0) {
            System.out.println("1.Account Sittings 2. Add post 3. Notifications 4.Chat 5. Search 0.Exit account ");
            var = scannerInt.nextInt();
            switch (var) {
                case 1 -> {
                    System.out.println(userDto.uptoDateAccountFront(currentUser));
                }
                case 2 -> {

                }
                case 3 -> {
                    int varNotion = 10;
                    while (varNotion != 0) {
                        notificationDto.notification(currentUser);
                        System.out.println("0-> back");
                        int requestId = scannerInt.nextInt();
                        if (requestId == 0) {
                            DataBase.save();
                        }
                        if (requestId != 0) {
                            Notification notification = notificationService.getNotificationById(requestId);
                            if (notification != null && notification.getType().equals("request")) {
                                String s = "";
                                while (!s.equals("y") && !s.equals("n")) {
                                    System.out.println(notification.getNotificationMessage());
                                    System.out.println("For acceptance request enter 'y' , for rejection enter 'n' ");
                                    s = scannerStr.nextLine();
                                    if (s.equals('y')) {
                                        Main.user.getFriendsId().add(notification.getSenderId());
                                        userService.getById(notification.getSenderId()).getFriendsId().add(currentUser.getId());
                                        notification.setActive(false);
                                    } else if (s.equals('n')) {
                                        notification.setActive(false);
                                    } else {
                                        System.out.println("Please enter only (y or n)");
                                    }
                                }
                            } else if (notification.getType().equals("post")) {
                                System.out.println(notification.getNotificationMessage());
                            }
                        } else varNotion = 0;
                    }
                }
                case 4 -> {
                    if (currentUser.getChatId().isEmpty()) System.out.println("Chat is empty");
                    else {
                        chatService.showChats(currentUser.getChatId(), currentUser.getId());
                        int varChat = 10;
                        while (varChat != 0) {
                            System.out.println("enter chatId \n 0-> back");
                            varChat = scannerInt.nextInt();
                            if (varChat == 0) {
                                DataBase.save();
                            }
                            if (varChat != 0) {
                                Chat chat = chatService.getChatById(varChat);
                                if (chat != null) chatView(chat, currentUser);
                            }

                        }
                    }
                }
                case 5 -> {
                    System.out.println("enter userName");
                    String userName = scannerStr.nextLine();
                    User user = userService.getByUserName(userName);
                    if (user != null) {
                        System.out.println(user.getUserName() + " is founded");
                        int varSearch = 10;
                        while (varSearch != 0) {
                            System.out.println("1-> add Friend 2-> send message 0 -black");
                            varSearch = scannerInt.nextInt();
                            if (varSearch == 0) {
                                DataBase.save();
                            }
                            if (varSearch == 1) {
                                if (!currentUser.getFriendsId().contains(user.getId())) {
                                    Notification requestnotification = notificationDto.createRequestNotification(currentUser, user);
                                    NotificationService.addNotification(requestnotification);
                                    System.out.println("Request sanded ");
                                } else System.out.println("You are friends");
                            } else if (varSearch == 2) {
                                Chat exitChat = chatService.isExitChat(currentUser.getId(), user.getId());
                                if (exitChat != null) {
                                    chatView(exitChat, currentUser);
                                } else {
                                    Chat chat = new Chat(currentUser.getId(), currentUser.getFirstName(), user.getId(), user.getFirstName());
                                    chatService.addChat(chat);
                                    currentUser.getChatId().add(chat.getId());
                                    user.getChatId().add(chat.getId());
                                    chatView(chat, currentUser);
                                }
                            }
                        }

                    } else System.out.println("Nothing found");
                }
                case 0 -> {
                    DataBase.save();
                }
            }
        }
    }

    private static void chatView(Chat chat, User currentUser) throws IOException {
        messageService.showAllMessages(chat.getId());
        int varChatView = 10;
        while (varChatView != 0) {
            System.out.println("1-> Delete massage 2-> Sand massage 0-> back");
            varChatView = scannerInt.nextInt();
            if (varChatView == 1) {
                System.out.println("Enter Id");
                varChatView = scannerInt.nextInt();
                if (messageService.deleteMessage(varChatView, currentUser.getId())) System.out.println("Deleted");
                else System.out.println("was not deleted");
            } else if (varChatView == 2) {
                System.out.println("0-> back");
                Massege massege = messageDto.createMessage(chat.getId(), currentUser.getId(), currentUser.getFirstName());
                while (massege != null) {
                    messageService.addMessage(massege);
                    massege = messageDto.createMessage(chat.getId(), currentUser.getId(), currentUser.getFirstName());
                }
            }
        }

    }
}