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


    public void clickLike(Post post, int id){
        if (post.getLikes().add(id)) {
            System.out.println("Liked");
        } else {
            post.getLikes().remove(id);
            System.out.println("disliked");
        }
    }

    public boolean delete(int nextInt, String userName) {
        if (!DataBase.commits.isEmpty()&&DataBase.commits.get(nextInt)!=null&&DataBase.commits.get(nextInt).isActive()) {
            DataBase.commits.get(nextInt).setActive(false);
            return true;
        }
        return false;
    }
}
