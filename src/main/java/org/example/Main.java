package org.example;

import org.example.dto.*;
import org.example.model.*;
import org.example.service.*;

import java.io.IOException;
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
                    DataBase.save();
                }
                case 2 -> {
                    post();
                    DataBase.save();
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
                            if (notification != null && notification.isActive() && notification.getType().equals("request")) {
                                String s = "";
                                while (!s.equals("y") && !s.equals("n")) {
                                    System.out.println("For acceptance request enter 'y' , for rejection enter 'n' ");
                                    s = scannerStr.nextLine();
                                    if (s.equals("y")) {
                                        currentUser.getFriendsId().add(notification.getSenderId());
                                        userService.getById(notification.getSenderId()).getFriendsId().add(currentUser.getId());
                                        notification.setActive(false);
                                        System.out.println("you accepted");
                                    } else if (s.equals("y")) {
                                        notification.setActive(false);
                                        System.out.println("you did not accept");
                                    } else {
                                        System.out.println("Please enter only (y or n)");
                                    }
                                }
                            } else if (notification.getType().equals("post")) {
                                System.out.println(notification.getNotificationMessage());
LikeAndCommit(notification);
                            }
                        } else varNotion = 0;
                    }
                }
                case 4 -> {
                    if (currentUser.getChatId().isEmpty()) System.out.println("Chat is empty");
                    else {
                        int varChat = 10;
                        while (varChat != 0) {
                            chatService.showChats(currentUser.getChatId(), currentUser.getId());
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
                                    if (!NotificationService.isExitNotification(currentUser, user)) {
                                        Notification requestNotification = notificationDto.createRequestNotification(currentUser, user);
                                        NotificationService.addNotification(requestNotification);
                                        System.out.println("Request sanded ");
                                    } else System.out.println("Request already sanded");
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
        int varChatView = 10;
        while (varChatView != 0) {
            messageService.showAllMessages(chat.getId());
            System.out.println("1-> Delete massage 2-> Sand massage 0-> back");
            varChatView = scannerInt.nextInt();
            if (varChatView == 1) {
                System.out.println("Enter Id");
                varChatView = scannerInt.nextInt();
                if (messageService.deleteMessage(varChatView, currentUser.getId())) System.out.println("Deleted");
                else System.out.println("was not deleted");
            } else if (varChatView == 2) {
                System.out.println("0-> back");
                Massage massage = messageDto.createMessage(chat.getId(), currentUser.getId(), currentUser.getFirstName());
                while (massage != null) {
                    messageService.addMessage(massage);
                    massage = messageDto.createMessage(chat.getId(), currentUser.getId(), currentUser.getFirstName());
                }
            }
        }

    }

    private static void post() throws IOException {
        int varPost = 10;
        while (varPost != 0) {
            System.out.println("1. Add post 2. Delete post 3.show one post");
            varPost = scannerInt.nextInt();
            switch (varPost) {
                case 1 -> {
                    Post post = postDto.creatPost(user.getId());
                    System.out.println(postService.add(post));
                    for (Integer integer : user.getFriendsId()) {
                        Notification post1 = notificationDto.createPostNotification(user.getId(),integer,"post",post.getId(), String.valueOf(post));
                        notificationService.addPostNotification(post1);
                    }
                }
                case 2 -> {
                    postService.showAllPostsCurrentUser(user.getId());
                    int i = postDto.deletePost();
                    System.out.println(postService.deletePost(i, user.getId()));
                }
                case 3 -> {
                    postService.showAllPostsCurrentUser(user.getId());
                    System.out.println("enter post id for see commits and likes");
                    int postId = scannerInt.nextInt();
                    Post post = postService.showOnePost(postId, user.getId());
                    System.out.println(post);
                    int varCommit = 10;
                    while (varCommit != 0) {
                        System.out.println("1.Likes  2.show commits 0.back");
                        varCommit = scannerInt.nextInt();
                        if (varCommit == 1) {
                            System.out.println("Likes " + post.getLikes());
                        } else if (varCommit==2){
                            commitDto.showCommits(post.getId());
                        }else {
                            DataBase.save();
                            break;
                        }
                    }
                }
                case 0 -> {
                    DataBase.save();
                }
            }
        }
    }

    private static void LikeAndCommit(Notification notification) throws IOException {
        int varCommit=10;
        while (varCommit!=0) {
            System.out.println("1.Click like 2. Add commit 0. back");
            varCommit=scannerInt.nextInt();
            if (varCommit==1){
                commitService.clickLike(postService.forNotification(notification.getPostId()));
            } else if (varCommit==2) {
                Commit commit = commitDto.creatCommit(postService.forNotification(notification.getPostId()), user.getUserName());
                System.out.println(commitService.add(commit));
            }else {
                DataBase.save();
            }
        }
    }
}