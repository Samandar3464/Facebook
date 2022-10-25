package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class DataBase {
    public static Gson gson = new Gson();

    public static boolean writeUser(User newUser) throws IOException {
        ArrayList<User> users = readUser();
        users.add(newUser);
        File file = new File("files\\users.txt");
        file.createNewFile();
        String s = gson.toJson(users);
        BufferedWriter bufferedWriter = new BufferedWriter((new FileWriter(file)));
        bufferedWriter.write(s);
        bufferedWriter.close();
        return true;
    }

    public static ArrayList<User> readUser() throws IOException {
        File file = new File("files\\users.txt");
        file.createNewFile();
        FileReader fileReader = new FileReader(file);
        ArrayList<User> usersList = gson.fromJson(fileReader, new TypeToken<List<User>>() {
        }.getType());
        fileReader.close();
        return usersList;
    }


    public static boolean notificationsWrite(Notification newNotification) throws IOException {
        Stack<Notification> notifications = notificationsRead();

        notifications.add(newNotification);
        File notification = new File("files\\notifications.txt");

        notification.createNewFile();
        String s = gson.toJson(notifications);
        BufferedWriter bufferedWriter = new BufferedWriter((new FileWriter(notification)));
        bufferedWriter.write(s);
        bufferedWriter.close();
        return true;
    }

    public static Stack<Notification> notificationsRead() throws IOException {
        File notification = new File("files\\notifications.txt");
        notification.createNewFile();
        FileReader fileReader = new FileReader(notification);
        Stack<Notification> notifications = gson.fromJson(fileReader, new TypeToken<Stack<Notification>>() {
        }.getType());
        fileReader.close();
        return notifications;
    }


    public static boolean postWrite(Post post) throws IOException {
        HashMap<Integer, Post> posts = postRead();
        posts.put(post.getOwnerId(), post);
        File postFile = new File("files\\posts.txt");

        postFile.createNewFile();
        String s = gson.toJson(posts);
        BufferedWriter bufferedWriter = new BufferedWriter((new FileWriter(postFile)));
        bufferedWriter.write(s);
        bufferedWriter.close();
        return true;
    }

    public static HashMap<Integer, Post> postRead() throws IOException {
        File post = new File("files\\posts.txt");
        post.createNewFile();
        FileReader fileReader = new FileReader(post);
        HashMap<Integer, Post> posts = gson.fromJson(fileReader, new TypeToken<HashMap<Integer, Post>>() {
        }.getType());
        fileReader.close();
        return posts;
    }


    public static boolean commitWrite(Commit commit) throws IOException {
        HashMap<Integer, Commit> commits = commitRead();
        commits.put(commit.getId(), commit);
        File commitFile = new File("files\\commits.txt");
        commitFile.createNewFile();
        String s = gson.toJson(commits);
        BufferedWriter bufferedWriter = new BufferedWriter((new FileWriter(commitFile)));
        bufferedWriter.write(s);
        bufferedWriter.close();
        return true;
    }

    public static HashMap<Integer, Commit> commitRead() throws IOException {
        File commit = new File("files\\commits.txt");
        commit.createNewFile();
        FileReader fileReader = new FileReader(commit);
        HashMap<Integer, Commit> commits = gson.fromJson(fileReader, new TypeToken<HashMap<Integer, Commit>>() {
        }.getType());
        fileReader.close();
        return commits;
    }


    public static boolean massageWrite(Massege massege) throws IOException {
        HashMap<Integer, Massege> massages = massageRead();
        massages.put(massege.getId(), massege);
        File massageFile = new File("files\\massages.txt");

        massageFile.createNewFile();
        String s = gson.toJson(massages);
        BufferedWriter bufferedWriter = new BufferedWriter((new FileWriter(massageFile)));
        bufferedWriter.write(s);
        bufferedWriter.close();
        return true;
    }

    public static HashMap<Integer, Massege> massageRead() throws IOException {
        File massage = new File("files\\massage.txt");
        massage.createNewFile();
        FileReader fileReader = new FileReader(massage);
        HashMap<Integer, Massege> massages = gson.fromJson(fileReader, new TypeToken<HashMap<Integer, Massege>>() {
        }.getType());
        fileReader.close();
        return massages;
    }


    public static boolean chatWrite(Chat chat) throws IOException {
        HashMap<Integer, Chat> chats = chatRead();
        chats.put(chat.getId(), chat);
        File chatFile = new File("files\\chats.txt");

        chatFile.createNewFile();
        String s = gson.toJson(chats);
        BufferedWriter bufferedWriter = new BufferedWriter((new FileWriter(chatFile)));
        bufferedWriter.write(s);
        bufferedWriter.close();
        return true;
    }

    public static HashMap<Integer, Chat> chatRead() throws IOException {
        File chatFie = new File("files\\chats.txt");
        chatFie.createNewFile();
        FileReader fileReader = new FileReader(chatFie);
        HashMap<Integer, Chat> chats = gson.fromJson(fileReader, new TypeToken<HashMap<Integer, Chat>>() {
        }.getType());
        fileReader.close();
        return chats;
    }


}
