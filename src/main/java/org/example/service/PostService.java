package org.example.service;

import org.example.DataBase;
import org.example.model.Base;
import org.example.model.Post;

public class PostService extends Base {
    public boolean add(Post post) {
        DataBase.posts.put(post.getId(), post);
        return true;
    }

    public void showAllPostsCurrentUser(int userId) {
        for (Integer integer : DataBase.posts.keySet()) {
            if (DataBase.posts.get(integer).getOwnerId() == userId && DataBase.posts.get(integer).isActive()) {
                System.out.println(DataBase.posts.get(integer));
            }
        }
    }

    public boolean deletePost(int postId ,int userId) {
        for (Integer integer : DataBase.posts.keySet()) {
            if (DataBase.posts.get(integer).getOwnerId() == userId && DataBase.posts.get(integer).isActive()) {
                if(DataBase.posts.get(integer).getId()==postId){
                    DataBase.posts.get(integer).setActive(false);
                    return true;
                }
            }
        }
        return false;
    }

    public Post showOnePost(int postId, int userId){
        for (Integer integer : DataBase.posts.keySet()) {
            if (DataBase.posts.get(integer).getOwnerId() == userId && DataBase.posts.get(integer).isActive()) {
            if(DataBase.posts.get(integer).getId()==postId)
                return DataBase.posts.get(integer);
            }
        }
        return null;
    }

    public Post forNotification(int postId){
        for (Integer integer : DataBase.posts.keySet()) {
            if (integer==postId){
                return DataBase.posts.get(integer);
            }
        }
        return null;
    }
}



