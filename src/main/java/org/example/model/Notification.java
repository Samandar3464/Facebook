package org.example.model;

import lombok.Data;

@Data
public class Notification extends Base {
    private String type;
    private int senderId;
    private int receiverId;
    private int postId;
    private String notificationMessage;

    public Notification(String type, int senderId, int receiverId, String notificationMessage) {  // request
        this.type = type;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.notificationMessage = notificationMessage;
    }

    public Notification(int senderId, int postId, String type, String notificationMessage) { // post
        this.senderId = senderId;
        this.postId = postId;
        this.type = type;
        this.notificationMessage = notificationMessage;
    }

    public Notification(String type, int senderId, int receiverId, int postId, String notificationMessage) {
        this.type = type;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.postId = postId;
        this.notificationMessage = notificationMessage;
    }
}
