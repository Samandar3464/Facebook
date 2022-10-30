package org.example.dto;

import org.example.model.Notification;
import org.example.model.User;
import org.example.service.NotificationService;

import java.io.IOException;
import java.util.Scanner;

public class NotificationDto {
    NotificationService notificationService = new NotificationService();
    Scanner scannerInt = new Scanner(System.in);
    Scanner scannerStr = new Scanner(System.in);

    public Notification createRequestNotification(User currentUser, User user) {
        return new Notification("request", currentUser.getId(), user.getId(),
                " you have received a friend request from " + currentUser.getFirstName());
    }

    public void notification(User user) throws IOException {
        System.out.println("1. Your all notifications");
        notificationService.showNotificationDefaultUser(user);
    }

    public Notification createPostNotification( int senderId,String type,int postId,  String notification) {
        Notification notification1 = new Notification(senderId,postId,"post",notification);
        return notification1;
    }

    public Notification createCommitNotification(String type, int senderId, int receiverId,int postId, String message) {
        return new Notification(type,senderId,receiverId,postId,message);
    }
}
