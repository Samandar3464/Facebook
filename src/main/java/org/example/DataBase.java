package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.example.model.*;

import java.io.*;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class DataBase {
    public static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public static BufferedWriter bufferedWriter = null;


    public static HashMap<Integer, Massege> massages = null;
    public static HashMap<Integer, Chat> chats = new HashMap<>();
    public static HashMap<Integer, Commit> commits = new HashMap<>();
    public static HashMap<Integer, Post> posts = new HashMap<>();
    public static Stack<Notification> notifications = new Stack<>();
    public static ArrayList<User> allUsers = new ArrayList<>();


    public static void start() throws IOException {
//        MESSAGE

        File massage = new File("files\\massages.json");
        massage.createNewFile();
        FileReader messageFileReader = new FileReader(massage);
        massages = gson.fromJson(messageFileReader, new TypeToken<HashMap<Integer, Massege>>() {
        }.getType());
        messageFileReader.close();
        if (massages == null) {
            massages = new HashMap<>();
        }

//        USER
        File user = new File("files\\users.json");
        user.createNewFile();
        FileReader userFileReader = new FileReader(user);
        allUsers = gson.fromJson(userFileReader, new TypeToken<ArrayList<User>>() {
        }.getType());
        messageFileReader.close();
        if (allUsers == null) {
            allUsers = new ArrayList<>();
        }


//        CHAT
        File chatFile = new File("files\\chats.json");
        chatFile.createNewFile();
        FileReader charFileReader = new FileReader(chatFile);
        chats = gson.fromJson(charFileReader, new TypeToken<HashMap<Integer, Chat>>() {
        }.getType());
        charFileReader.close();
        if (chats == null) {
            chats = new HashMap<>();
        }
//        COMMIT
        File commit = new File("files\\commits.json");
        commit.createNewFile();
        FileReader commitFileReader = new FileReader(commit);
        commits = gson.fromJson(commitFileReader, new TypeToken<HashMap<Integer, Commit>>() {
        }.getType());
        commitFileReader.close();
        if (commits == null) {
            commits = new HashMap<>();
        }
//        NOTIFICATION
        File notification = new File("files\\notifications.json");
        notification.createNewFile();
        FileReader notificationFileReader = new FileReader(notification);
        notifications = gson.fromJson(notificationFileReader, new TypeToken<Stack<Notification>>() {
        }.getType());
        notificationFileReader.close();
        if (notifications == null) {
            notifications = new Stack<>();
        }
//        POST
        File post = new File("files\\posts.json");
        post.createNewFile();
        FileReader postFileReader = new FileReader(post);
        posts = gson.fromJson(postFileReader, new TypeToken<HashMap<Integer, Post>>() {
        }.getType());
        postFileReader.close();
        if (posts == null) {
            posts = new HashMap<>();
        }
    }

    public static void save() throws IOException {
        String s = null;
//        MESSAGE
        File massageFile = new File("files\\massages.json");
        massageFile.createNewFile();
        s = gson.toJson(massages);
        bufferedWriter = new BufferedWriter((new FileWriter(massageFile)));
        bufferedWriter.write(s);
        bufferedWriter.close();

//        CHAT
        File chatFile = new File("files\\chats.json");
        chatFile.createNewFile();
        s = gson.toJson(chats);
        bufferedWriter = new BufferedWriter((new FileWriter(chatFile)));
        bufferedWriter.write(s);
        bufferedWriter.close();

//        COMMIT
        File commitFile = new File("files\\commits.json");
        commitFile.createNewFile();
        s = gson.toJson(commits);
        bufferedWriter = new BufferedWriter((new FileWriter(commitFile)));
        bufferedWriter.write(s);
        bufferedWriter.close();

//        NOTIFICATION
        File notification = new File("files\\notifications.json");
        notification.createNewFile();
        s = gson.toJson(notifications);
        bufferedWriter = new BufferedWriter((new FileWriter(notification)));
        bufferedWriter.write(s);
        bufferedWriter.close();

//        POST
        File postFile = new File("files\\posts.json");
        postFile.createNewFile();
        s = gson.toJson(posts);
        bufferedWriter = new BufferedWriter((new FileWriter(postFile)));
        bufferedWriter.write(s);
        bufferedWriter.close();

//        USER
        File userWrite = new File("files\\users.json");
        userWrite.createNewFile();
        s = gson.toJson(allUsers);
        bufferedWriter = new BufferedWriter((new FileWriter(userWrite)));
        bufferedWriter.write(s);
        bufferedWriter.close();
    }
}
