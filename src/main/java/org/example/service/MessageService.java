package org.example.service;

import org.example.DataBase;
import org.example.model.Massage;

import java.io.IOException;
import java.text.SimpleDateFormat;

public  class MessageService {

    public boolean addMessage(Massage massage) throws IOException {
        DataBase.massages.put(massage.getId(), massage);
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
            String s="";
            for (Integer integer : DataBase.massages.keySet()) {
                if (DataBase.massages.get(integer).isActive()&&
                        DataBase.massages.get(integer).getReceiverId() == chatId) {
                    SimpleDateFormat dateFormat=new SimpleDateFormat("dd/hh:mm");
                    s+=integer+" "+DataBase.massages.get(integer).getSenderName() + ":  " + DataBase.massages.get(integer).getMassage()+ "\n"+ dateFormat.format(DataBase.massages.get(integer).getDate())+"\n";
                }
            }
            System.out.println(s);
        }
    }


