package org.example.service;

import org.example.model.Commit;
import org.example.model.User;

import java.util.HashMap;

public class CommitService extends Commit {
    public static HashMap<Integer, Commit> commits = new HashMap<>();

    public boolean add(Commit commit){
        if(getId()!=0) {
            commits.put(getPostId(), commit);
            return true;
        }
        return false;
    }

    public boolean remove(Commit commit){
        if(commit.getId()!=0){
            commits.remove(commit.getId());
            return true;
        }
        return false;
    }

    public void print(User user,Commit commit){
        System.out.println("who->  "+user.getFirstName()+"\n"+"What->  "+commit.getCommit()+"\n");
//        System.out.println(posts);
    }

}

