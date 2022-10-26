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

    public  Notification createRequestnotification(User currentUser, User user) {
        return new Notification("request",currentUser.getId(),user.getId(),currentUser.getFirstName()+" sizga do'stlik so'rovini yubordi");
    }

    public void notification(User user) throws IOException {
            System.out.println("1. Your all notifications");
            notificationService.showNotificationDefaultUser(user);
    }
}
