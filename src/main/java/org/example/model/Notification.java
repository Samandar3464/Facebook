package org.example.model;

import lombok.Data;
import org.example.Base;

@Data
public class Notification extends Base {
    private String type;
    private int senderId;
    private int receiverId;
    private int postId;

    public Notification(String type, int senderId, int receiverId) {  // request
        this.type = type;
        this.senderId = senderId;
        this.receiverId = receiverId;
    }

    public Notification(int senderId, int postId, String type) { // post
        this.type = type;
        this.postId = postId;
        this.senderId = senderId;
    }
}
