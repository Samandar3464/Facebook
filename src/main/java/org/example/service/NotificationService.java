package org.example.service;

import org.example.DataBase;
import org.example.model.Notification;
import org.example.model.User;

import java.io.IOException;
import java.util.*;

public class NotificationService {
    Stack<Notification> notifications =null;


    public void showNotificationDefaultUser(User user) throws IOException {

        for (Notification notification : notifications) {
            if (notification != null) {
                if (notification.getType().equals("request")) {
                    if (notification.getReceiverId() == user.getId()) {
                        System.out.println(notification);
                    }
                } else {
                    for (Integer contactId : user.getFriendsId()) {
                        if (contactId != null) {
                            if (contactId == notification.getSenderId()) {
                                System.out.println(notification);
                            }
                        }
                    }
                }
            }
        }
    }
    public boolean deleteRequest(User user) {
        for (Notification notification : notifications) {
            if (notification != null) {
                if (notification.getType().equals("request")) {
                    if (notification.getReceiverId() == user.getId()) {
                        return notifications.remove(notification);
                    }
                }
            }
        }
        return false;
    }
}