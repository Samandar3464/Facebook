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

    public Notification createPostNotification( int senderId, int receiverId,String type,int postId,  String notification) {
        Notification notification1 = new Notification(senderId,receiverId,postId,"post",notification);
        return notification1;
    }
}
