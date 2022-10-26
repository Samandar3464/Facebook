package org.example.service;

import org.example.model.Post;

import java.util.HashMap;
import java.util.Objects;

public class PostService extends Post {

    //    public static Post post = new Post();
    public static int count = 0;
    public static HashMap<Integer, Post> posts = new HashMap<>();

    public boolean add(Post post){
        if(getOwnerId()!=0) {
            posts.put(getOwnerId(), post);
            return true;
        }
        return false;
    }

    public static boolean remove(Post post){
        if(post.getId()!=0){
            posts.remove(post.getId());
            return true;
        }
        return false;
    }
    public boolean like(){
        count++;
        return true;
    }

    public boolean dislike(){
        count--;
        return true;
    }

//    public static HashMap<Integer,Post> posts = new HashMap<>();
//    public static HashMap<Integer, Commit> commits = new HashMap<>();
//    public static ArrayList<HashMap<Integer, Objects>> posts = new ArrayList<>();

    public void print(){
        System.out.println(posts);
    }




}
