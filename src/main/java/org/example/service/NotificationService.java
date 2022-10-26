package org.example.service;

import org.example.DataBase;
import org.example.model.Notification;
import org.example.model.User;

import java.io.IOException;
import java.util.*;

public class NotificationService {
    public void showNotificationDefaultUser(User user) throws IOException {
        for (Notification notification : DataBase.notifications) {
            if (notification != null) {
                if (notification.getType().equals("request")) {
                    if (notification.getReceiverId() == user.getId()) {
                        System.out.println(notification.getNotificationMessage());
                    }
                } else {
                    for (Integer contactId : user.getFriendsId()) {
                        if (contactId != null) {
                            if (contactId == notification.getSenderId()) {
                                System.out.println(notification.getNotificationMessage());
                            }
                        }
                    }
                }
            }
        }
    }

    public Notification OneRequest(User user ,int requestId) {
        for (Notification notification : DataBase.notifications) {
            if (notification != null) {
                if (notification.getType().equals("request")) {
                    if (notification.getReceiverId() == user.getId()&&notification.getId()==requestId) {
                        return notification;
                    }
                }
            }
        }
        return null;
    }
    public Notification getNotificationById(int notificationId){
        for (int i = 0; i < DataBase.notifications.size(); i++) {
            if (DataBase.notifications.get(i)!=null){
                if (DataBase.notifications.get(i).getId()==notificationId){
                    return DataBase.notifications.get(i);
                }
            }
        }
        return null;
    }
}