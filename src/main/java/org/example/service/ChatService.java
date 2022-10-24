package org.example.service;

import org.example.model.Chat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChatService {
    public Map<Integer,Chat> chats = new HashMap();
    protected boolean addNewChat(Chat chat){
        if (chats.get(chat.getId())!=null) return false;
        chats.put(chat.getId(),chat);
        return true;
    }
}

