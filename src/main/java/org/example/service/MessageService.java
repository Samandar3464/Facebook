package org.example.service;

import org.example.DataBase;
import org.example.model.Massege;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public  class MessageService {

    public boolean addMessage(Massege massege) throws IOException {
        DataBase.massages.put(massege.getId(), massege);
        return true;
    }

    public boolean deleteMessage(int messageId, int userid) throws IOException {
        if (DataBase.massages.get(messageId)!=null&&DataBase.massages.get(messageId).getSenderId()==userid){
            DataBase.massages.get(messageId).setActive(false);
            return true;
        }
            return false;
        }

        public void showAllMessages ( int chatId){
            if (DataBase.massages == null) return;
            for (Integer integer : DataBase.massages.keySet()) {
                if (DataBase.massages.get(integer).isActive()&&
                        DataBase.massages.get(integer).getReceiverId() == chatId) {
                    SimpleDateFormat dateFormat=new SimpleDateFormat("dd/hh:mm");
                    System.out.println(integer+" "+DataBase.massages.get(integer).getSenderName() + ":  " + DataBase.massages.get(integer).getMassage()+ "\n"+ dateFormat.format(DataBase.massages.get(integer).getDate()));
                }
            }
        }
    }


