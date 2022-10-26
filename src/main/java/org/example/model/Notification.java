package org.example.model;

import lombok.Data;
import org.example.Base;

@Data
public class Notification extends Base {
    private String type;
    private int senderId;
    private int receiverId;
    private int postId;
    private boolean isActive;
    private String notificationMessage;

    public Notification(String type, int senderId, int receiverId,String notificationMessage) {  // request
        this.type = type;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.notificationMessage=notificationMessage;
        this.isActive=true;
    }

    public Notification(int senderId, int postId, String type,String notificationMessage) { // post
        this.type = type;
        this.postId = postId;
        this.senderId = senderId;
        this.notificationMessage=notificationMessage;
        this.isActive=true;
    }
}
