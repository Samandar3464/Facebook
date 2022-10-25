package org.example.service;

import org.example.DataBase;
import org.example.model.User;

public class UserService {

    public boolean registration(User user) {
       // DataBase.allUsers=new ArrayList<>();
            for (User allUser : DataBase.allUsers) {
                if (allUser != null) {
                    if (allUser.getPhoneNumber().equals(user.getPhoneNumber())) {
                       // DataBase.allUsers.add(user);
                        return false;
                    }
                }
            }
        DataBase.allUsers.add(user);
        return true;
    }
  
    public User logIn(String phoneNumber, String password) {
        if (DataBase.allUsers == null) return null;
        for (User user : DataBase.allUsers) {
            if (user !=null){
                if (user.getPhoneNumber().equals(phoneNumber)&& user.getPassword().equals(password)){
                    return user;
                }
            }
        }
        return null;
    }

    public User uptoDateAccount(int userId){
        for (User allUser : DataBase.allUsers) {
            if (allUser!=null){
                if (allUser.getId()==userId){
                    return getById(userId);

                }
            }
        }
    return null;
    }

    public void showUserAccount(User user){
        for (User allUser : DataBase.allUsers) {
            if (allUser!=null){
                if (allUser.equals(user)){
                    System.out.println(user);
                }
            }
        }
    }
    public User getById(int userId) {
        for (User user : DataBase.allUsers) {
            if (user != null) {
                if (user.getId() == userId) {
                    return user;
                }
            }
        }
        return null;
    }
}
