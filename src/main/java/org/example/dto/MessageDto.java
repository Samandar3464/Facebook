package org.example.dto;

import org.example.model.Massage;
import org.example.model.User;

import java.util.Scanner;

public class MessageDto {
    public Scanner scannerStr = new Scanner(System.in);
    public static void createMessage(User currentUser, User user) {
        String message="";
    }

    public Massage createMessage(int chatId, int senderId, String firstName) {
        String message= scannerStr.nextLine();
        if (message.equals("0"))return null;
        return new Massage(senderId,chatId,firstName,message);
    }
}
