package org.example.model;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class Massage extends Base {
    private  int senderId;
    private  int receiverId;
    private  String senderName;
    private String massage;


}
