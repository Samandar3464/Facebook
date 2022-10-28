package org.example.service;
import org.example.DataBase;
import org.example.model.Base;
import org.example.model.Commit;
import org.example.model.Post;

public class CommitService extends Base {
    public  boolean add(Commit commit){
            DataBase.commits.put(commit.getId(),commit);
            return true;
    }

    public void clickLike(Post post){
        int i = post.getLikes() + 1;
        post.setLikes(i);
    }

}
