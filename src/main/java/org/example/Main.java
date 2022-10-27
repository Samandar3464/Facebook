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
        ArrayList arrayList=new ArrayList();
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
                    else System.out.println("This phone already have in Facebook or This user name already havel");
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
            if (var == 0) {
                DataBase.save();
            }
            switch (var) {
                case 1 -> {
                    System.out.println(userDto.uptoDateAccountFront(currentUser));
                }
                case 2 -> {

                }
                case 3 -> {
                    int varNotion=10;
                    while (varNotion!=0) {
                        notificationDto.notification(currentUser);
                        System.out.println("0-> ortga");
                        int requestId = scannerInt.nextInt();
                        if (requestId!=0) {
                            Notification notification = notificationService.getNotificationById(requestId);
                            if (notification!=null&&notification.getType().equals("request")) {
                                String s="";
                                while (!s.equals("y")&&!s.equals("n")) {
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
                            }
                            else if (notification.getType().equals("post")) {
                                System.out.println(notification.getNotificationMessage());
                            }
                        }else varNotion=0;
                    }
                }
                case 4 -> {
                    if (currentUser.getChatId().isEmpty()) System.out.println("Chat bo'sh");
                    else {
                        chatService.showChats(currentUser.getChatId(), currentUser.getId());
                        int varChat = 10;
                        while (varChat != 0) {
                            System.out.println("ChatId kiriting \n 0-> ortga");
                            varChat=scannerInt.nextInt();
                            if (varChat!=0){
                                Chat chat = chatService.getChatById(varChat);
                                if (chat!=null)chatView(chat,currentUser);
                            }

                        }
                    }
                }
                case 5 ->{
                    System.out.println("userName kiriting");
                    String userName = scannerStr.nextLine();
                    User user = userService.getByUserName(userName);
                    if (user!=null){
                        System.out.println(user.getUserName()+" is founded");
                        int varSearch=10;
                        while (varSearch!=0){
                            System.out.println("1-> add Friend 2-> send message 0 -ortga");
                            varSearch=scannerInt.nextInt();
                            if (varSearch==1) {
                                if (!currentUser.getFriendsId().contains(user.getId())) {
                                    Notification requestnotification = notificationDto.createRequestnotification(currentUser, user);
                                    NotificationService.addNotification(requestnotification);
                                    System.out.println("So'rov yuborildi");
                                }else System.out.println("Sizlar do'stsiz");
                            }
                            else if (varSearch==2) {
                                Chat exitChat = chatService.isExitChat(currentUser.getId(), user.getId());
                                if(exitChat!=null){
                                  chatView(exitChat,currentUser);
                                }else {
                                    Chat chat=new Chat(currentUser.getId(),currentUser.getFirstName(),user.getId(),user.getFirstName());
                                    chatService.addChat(chat);
                                    currentUser.getChatId().add(chat.getId());
                                    user.getChatId().add(chat.getId());
                                    chatView(chat,currentUser);
                                }
                            }
                        }

                    } else System.out.println("Nothing founded");
                }
                case 0 -> {



                }
            }
        }
    }

    private static void chatView(Chat chat, User currentUser) throws IOException {
       messageService.showAllMessages(chat.getId());
        int varChatView=10;
        while (varChatView!=0) {
            System.out.println("1-> xabarni o'chirish 2-> xabar yuborish 0-> ortga");
            varChatView=scannerInt.nextInt();
            if (varChatView==1){
                System.out.println("id ni kiriting");
                varChatView= scannerInt.nextInt();
                if (messageService.deleteMessage(varChatView,currentUser.getId())) System.out.println("o'chirildi");
                else System.out.println("o'chirilmadi");
            } else if (varChatView==2){
                System.out.println("0-> back");
                Massege massege=messageDto.createMessage(chat.getId(),currentUser.getId(),currentUser.getFirstName());
                while (massege!=null) {
                    messageService.addMessage(massege);
                   massege = messageDto.createMessage(chat.getId(), currentUser.getId(), currentUser.getFirstName());
                }
            }
        }

    }
}