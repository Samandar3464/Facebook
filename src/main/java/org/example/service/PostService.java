package org.example.service;

import org.example.Base;
import org.example.DataBase;
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

    public boolean deletePost(int postId) {
        DataBase.posts.get(postId).setActive(false);
        return true;
    }
}
