package org.example.service;

import org.example.Base;
import org.example.DataBase;
import org.example.model.Post;

public class CommitService extends Base {
    public  boolean add(Post post){
            DataBase.posts.put(post.getId(),post);
            return true;
    }


}
