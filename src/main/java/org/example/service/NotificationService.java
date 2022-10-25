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
    public boolean deleteRequest(User user ,int requestId) {
        for (Notification notification : DataBase.notifications) {
            if (notification != null) {
                if (notification.getType().equals("request")) {
                    if (notification.getReceiverId() == user.getId()&&notification.getId()==requestId) {
                        return DataBase.notifications.remove(notification);
                    }
                }
            }
        }
        return false;
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
    public int getById(int notificationId){
        for (Notification notification1 : DataBase.notifications) {
            if (notification1!=null){
                if (notification1.getId()==notificationId){
                    return notification1.getSenderId();
                }
            }
        }
        return 0;
    }
}