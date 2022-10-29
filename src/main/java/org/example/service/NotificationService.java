package org.example.service;

import org.example.DataBase;
import org.example.model.Notification;
import org.example.model.User;

import java.io.IOException;



public class NotificationService {
    public static void addNotification(Notification requestnotification) {
        DataBase.notifications.add(requestnotification);
    }
    public static void addPostNotification(Notification postNotification) {
        DataBase.notifications.add(postNotification);
    }
    public static boolean isExitNotification(User currentUser, User user) {
        if (DataBase.notifications.isEmpty()) return false;
        for (Notification notification : DataBase.notifications) {
            if (notification!=null&&notification.isActive()){
                if (notification.getSenderId()==currentUser.getId()&&notification.getReceiverId()==user.getId()) return true;
            }
        }
        return false;
    }

    public void showNotificationDefaultUser(User user) throws IOException {
            if (!DataBase.notifications.isEmpty()) System.out.println("\n" + "Enter requestId");
        for (Notification notification : DataBase.notifications) {
            if (notification != null&&notification.isActive()) {
                if (notification.getType().equals("request")) {
                    if (notification.getReceiverId() == user.getId()) {
                        System.out.println(notification.getId()+" : "+notification.getNotificationMessage());
                    }
                } else {
                    for (Integer contactId : user.getFriendsId()) {
                        if (contactId != null) {
                            if (contactId == notification.getSenderId()) {
                                System.out.println(notification.getId()+" : "+notification.getNotificationMessage());
                            }
                        }
                    }
                }
            }
        }
    }

    public Notification getNotificationById(int notificationId){
        for (int i = 0; i < DataBase.notifications.size(); i++) {
            if (DataBase.notifications.get(i)!=null&&DataBase.notifications.get(i).isActive()){
                if (DataBase.notifications.get(i).getId()==notificationId){
                    return DataBase.notifications.get(i);
                }
            }
        }
        return null;
    }
}