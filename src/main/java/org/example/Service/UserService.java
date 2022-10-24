package org.example.Service;

import org.example.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
   static List<User> allUsers =new ArrayList<>();



    public  boolean Registration(User user){
        if(login(user.getPhoneNumber())!=null){
            return false;
        }
        allUsers.add(user);
        return true;
    }

    public User login(String phoneNumber){
        for (User user : allUsers) {
            if(user!=null){
                if(user.getPhoneNumber().equals(phoneNumber)){
                    return user;
                }
            }
        }return null;
    }

  public int getIdByPhoneNumber(String phoneNumber){
      for (User user : allUsers) {
          if(user!=null){
              if(user.getPhoneNumber().equals(phoneNumber)){
                  return user.getId();
              }
          }
      }return 0;
  }


    public boolean delete(int id) {
        for (User user : allUsers) {
            if(user.getId()!=0) {
                if (user.getId() == id) {
                    allUsers.remove(user);
                    return true;
                }
            }
        }return false;
    }


    public Object getById(int id) {
        return null;
    }
}
