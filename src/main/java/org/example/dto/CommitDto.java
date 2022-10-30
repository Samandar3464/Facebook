package org.example.dto;

import org.example.DataBase;
import org.example.model.Commit;
import org.example.model.Post;

import java.util.Scanner;

public class CommitDto {
    Scanner scanner = new Scanner(System.in);
    public Commit creatCommit(Post post ,String userName) {
        Commit commit = new Commit();
        System.out.println("enter commit ");
        String newCommit = scanner.nextLine();
        commit.setCommit(newCommit);
        commit.setPostId(post.getId());
        commit.setCommitWriter(userName);
        post.getCommits().add(commit.getId());
        DataBase.commits.put(commit.getId(), commit);
        return commit;
    }
    public void showCommits(int postId){
        if (DataBase.commits==null) {
            return;
        }
        boolean b=true;
        for (Integer integer : DataBase.commits.keySet()) {
            if (DataBase.commits.get(integer).isActive()&&DataBase.commits.get(integer).getPostId()==postId){
                b=false;
                System.out.println(DataBase.commits.get(integer).getId()+" : "+DataBase.commits.get(integer).getCommit());
            }
        }
        if (b) System.out.println("Any commits not founded");
    }
}
