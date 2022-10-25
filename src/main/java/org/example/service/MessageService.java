package org.example.service;

import org.example.DataBase;
import org.example.model.Massege;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MessageService {

    public boolean addMessage(Massege massege) throws IOException {
        DataBase.massages.put(massege.getId(), massege);
        return true;
    }

    public boolean deleteMessage(int messageId, int userid) throws IOException {
        if (DataBase.massages.get(messageId) != null && DataBase.massages.get(messageId).getSenderId() == userid) {
            DataBase.massages.remove(messageId);
            return true;
        }
            return false;
        }

        public void showAllMessages ( int chatId){
            if (DataBase.massages == null) return;
            for (Integer integer : DataBase.massages.keySet()) {
                if (DataBase.massages.get(integer).getReceiverId() == chatId) {
                    System.out.println(DataBase.massages.get(integer).getSenderName() + ":  " + DataBase.massages.get(integer).getMassage());
                }
            }
        }
    }


