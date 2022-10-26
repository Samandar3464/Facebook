package org.example.service;

import org.example.DataBase;
import org.example.model.Chat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChatService {
    public void showChats(ArrayList<Integer> chats, int userId) {
        for (int chat : chats) {
            if (DataBase.chats.get(chat) != null) {
                if (DataBase.chats.get(chat).getMemberId1() == userId)
                    System.out.println(DataBase.chats.get(chat).getId() + "=>  " + DataBase.chats.get(chat).getMemberName2());
                else
                    System.out.println(DataBase.chats.get(chat).getId() + "=>  " + DataBase.chats.get(chat).getMemberName1());
            }
        }
    }

    public Chat getChatById(int chatId) {
        return DataBase.chats.get(chatId);
    }

    public boolean addChat(Chat chat) {
        if (DataBase.chats.get(chat.getId()) == null) {
            DataBase.chats.put(chat.getId(), chat);
            return true;
        }
        return false;
    }

    public boolean deleteChat(int chatId) {
        return DataBase.chats.remove(chatId) != null;
    }


    public boolean isExitChat(int id, int id1) {
        for (Map.Entry<Integer, Chat> integerChatEntry : DataBase.chats.entrySet()) {
            if (integerChatEntry.getValue().getMemberId1()==id&&integerChatEntry.getValue().getMemberId2()==id1||
                    integerChatEntry.getValue().getMemberId1()==id1&&integerChatEntry.getValue().getMemberId2()==id){
                return true;
            }
        }
        return false;
    }
}


