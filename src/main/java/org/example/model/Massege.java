package org.example.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.Base;
@Data
@AllArgsConstructor
public class Massege extends Base {
    private  int senderId;
    private  int receiverId;
    private  String senderName;
    private String massage;

}
