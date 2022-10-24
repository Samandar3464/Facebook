package org.example.service;

import org.example.model.Massege;

import java.util.ArrayList;
import java.util.List;

public  class MessageService {
    public List<Massege> messages = new ArrayList<>();
    public boolean addMessage(Massege massege){
       return messages.add(massege);
    }
    public void showMessageByUserId(int userId){
        for (Massege message : messages) {
            if (message.getSenderId()==userId||message.getReceiverId()==userId){
                System.out.println(message.getMassage());
            }
        }
    }
    public boolean deleteMessageByUserId(int messageId, int userid){
        for (int i = 0; i < messages.size(); i++) {
            if(messages.get(i).getId()==messageId&&messages.get(i).getSenderId()==userid){
                messages.remove(i);
                return true;
            }
        }
        return false;
    }

}
