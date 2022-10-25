package org.example.service;

import org.example.DataBase;
import org.example.model.Massege;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public  class MessageService {

    public boolean addMessage(Massege massege) throws IOException {


       return true;
    }
    public boolean deleteMessage(int messageId, int userid) throws IOException {
               HashMap<Integer,Massege> messages = DataBase.massageRead();
        if (messages.get(messageId)!=null&&messages.get(messageId).getSenderId()==userid){
            messages.remove(messageId);
            DataBase.massageWrite(messages);
        }
        return false;
    }
//    public Massege getMessageById(int messageId){
//
//    }

}
