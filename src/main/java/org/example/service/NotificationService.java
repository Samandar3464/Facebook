package org.example.service;

import org.example.model.Notification;
import org.example.model.User;

import java.util.*;

public class NotificationService {
    Stack<Notification> notifications = new Stack<>();


    public void showNotificationDefaultUser(User user) {
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

    public User requestSandedUser(User user) {
        UserService userService = new UserService();  // object
        for (Notification notification : notifications) {
            if (notification != null) {
                if (notification.getType().equals("request")) {
                    if (notification.getReceiverId() == user.getId()) {
                        return userService.getById(notification.getSenderId());
                    }
                }
            }
        }
        return null;
    }

    public boolean requestConfirmation(User user, User requestSandedUser) {  // request ni tasdiqlash
        user.getFriendsId().add(requestSandedUser.getId());
        requestSandedUser.getFriendsId().add(user.getId());
        return true;
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