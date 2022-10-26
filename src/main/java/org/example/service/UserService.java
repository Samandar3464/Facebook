package org.example.service;

import org.example.DataBase;
import org.example.dto.UserDto;
import org.example.model.User;

import java.io.IOException;
import java.util.ArrayList;


public class UserService {


//    int number = 0;
//
//
//    public void sendSms(String phoneNumber) {
//
//        number = (int) (Math.random() * (9999 - 999 - 1) + 999);
//        System.out.println("SmS sent to +998(**)***" + phoneNumber.substring(5) + " number! " + number);
//    }
//
//    public boolean receiveTheCode(int code) {
//        if (code == number) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    public boolean edit(int id) throws IOException {
//        User user = (User) getById(id);
//        if (user != null) {
//            if (user.getId() == id) {
//                UserDto.logIn();
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public boolean registration(User user) throws IOException {
//        for (User allUser : DataBase.allUsers) {
//            if (login(user.getPhoneNumber()) == null) {
//                return false;
//            }
//        }
//        DataBase.allUsers.add(user);
//        return true;
//    }
//
//    private User login(String phoneNumber) throws IOException {
//        if (DataBase.allUsers != null) {
//            for (User user : DataBase.allUsers) {
//                if (user != null) {
//                    if (user.getPhoneNumber().equals(phoneNumber)) {
//                        return user;
//                    }
//                }
//            }
//        }
//
//        return null;
//    }
//
//    public User login(String phoneNumber, String password) throws IOException {
//
//        for (User user : DataBase.allUsers) {
//            if (user != null) {
//                if (user.getPhoneNumber().equals(phoneNumber) && user.getPassword().equals(password)) {
//                    return user;
//                }
//            }
//        }
//        return null;
//    }
//
//    public int getIdByPhoneNumber(String phoneNumber) {
//        for (User user : DataBase.allUsers) {
//            if (user != null) {
//                if (user.getPhoneNumber().equals(phoneNumber)) {
//                    return user.getId();
//                }
//            }
//        }
//        return 0;
//    }
//
//
//    public User getById(int userId) throws IOException {
//        for (User allUser : DataBase.allUsers) {
//            if (allUser != null) {
//                if (allUser.getId() == userId) {
//                    return allUser;
//                }
//            }
//=======

    public boolean registration(User user) {
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

    public  void showFriends(User user){
        for (User allUser : DataBase.allUsers) {
            if (allUser!=null){
                if (allUser.equals(user)){
                    System.out.println(allUser.getFriendsId());
                }
            }
        }
    }

    public User getByUserName(String userName) {
        for (User allUser : DataBase.allUsers) {
            if (allUser.getUserName().equals(userName)) return allUser;
        }
        return null;
    }
}

