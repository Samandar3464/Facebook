package org.example.dto;

import org.example.model.User;
import org.example.service.NotificationService;

import java.io.IOException;
import java.util.Scanner;

public class NotificationDto {
    NotificationService notificationService = new NotificationService();
    Scanner scannerInt = new Scanner(System.in);
    Scanner scannerStr = new Scanner(System.in);
    public void notification(User user) throws IOException {
            System.out.println("1. Your all notifications");
            notificationService.showNotificationDefaultUser(user);
    }
}
