package org.example.service;

import org.example.DataBase;
import org.example.model.Notification;
import org.example.model.User;

import java.io.IOException;

import static org.example.DataBase.notifications;

public class NotificationService {
    public static void addNotification(Notification requestnotification) {
        DataBase.notifications.add(requestnotification);
    }

    public void showNotificationDefaultUser(User user) throws IOException {

        for (Notification notification : DataBase.notifications) {
            System.out.println("\n" + "Enter requestId for acceptance or delete");
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
            if (notifications.get(i)!=null&&DataBase.notifications.get(i).isActive()){
                if (notifications.get(i).getId()==notificationId){
                    return DataBase.notifications.get(i);
                }
            }
        }
        return null;
    }
}