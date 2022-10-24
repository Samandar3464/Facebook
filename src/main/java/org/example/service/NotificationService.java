package org.example.service;

import org.example.model.Notification;
import org.example.model.User;

import java.util.*;

public class NotificationService {
    UserService userService = new UserService();  /// object olingan ochirish kk
    Stack<Notification> notifications = new Stack<>();


    public void showNotificationDefaultUser(User user) {
        for (Notification notification : notifications) {
            if (notification != null) {
                if (notification.getType().equals("request")) {
                    if (notification.getReceiverId() == user.getId()) {
                        System.out.println(notification);
                    }
                } else {
                    for (User contact : userService.contacts) {
                        if (contact != null) {
                            if (contact.getId() == notification.getSenderId()) {
                                System.out.println(notification);
                            }
                        }
                    }
                }
            }
        }
    }

    public User requestSandedUser(User user){
        for (Notification notification : notifications) {
            if (notification!=null){
                if (notification.getType().equals("request")){
                    if (notification.getReceiverId()==user.getId()){
                      return   userService.getUserById(notification.getSenderId());
                    }
                }
            }
        }
        return null;
    }

}