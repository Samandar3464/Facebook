package org.example.service;

import org.example.model.Post;
import org.example.model.User;

import java.util.HashMap;

public class PostService extends Post {
    public static int count = 0;
    public static HashMap<Integer, String> posts = new HashMap<>();



    public boolean add(Post post){
        posts.put(post.getId(), post.post);
        return true;
    }

    public static boolean remove(Post post){
        if(post.getId()!=0){
            posts.remove(post.getId());
            return true;
        }
        return false;
    }

    public boolean like(User user, Post post){
        post.setLikes(++count);
        return true;
    }

    public static boolean dislike(Post post){
        post.setLikes(--count);
        return true;
    }

    public void print(User user,Post post){
        System.out.println("who->  "+user.getFirstName()+"\n"+"What->  "+post.post+"\n"+"likes->  "+post.getLikes());
//        System.out.println(posts);
    }
}
