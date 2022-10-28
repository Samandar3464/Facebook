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
        for (Integer integer : DataBase.commits.keySet()) {
            if (DataBase.commits.get(integer).getPostId()==postId){
                System.out.println(DataBase.commits.get(integer));
            }
        }
    }
}
