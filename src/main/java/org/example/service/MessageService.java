package org.example.service;

import org.example.model.Massege;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public  class MessageService {
    public Map<Integer,Massege> messages = new HashMap<>();
    public boolean addMessage(Massege massege){
       messages.put(massege.getId(),massege);
       return true;
    }
    public boolean deleteMessage(int messageId, int userid){
        if (messages.get(messageId)!=null&&messages.get(messageId).getSenderId()==userid){
            messages.remove(messageId);
        }
        return false;
    }
    public Massege getMessageById(int messageId){
        return messages.get(messageId);
    }

}
