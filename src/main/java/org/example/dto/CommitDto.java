package org.example.dto;

import org.example.DataBase;
import org.example.model.Commit;
import org.example.model.Post;

import java.util.Scanner;

public class CommitDto {
    Scanner scanner = new Scanner(System.in);

    public Commit creatCommit(Post post) {
        Commit commit = new Commit();
        System.out.println("enter commit ");
        String newCommit = scanner.nextLine();
        commit.setCommit(newCommit);
        commit.setPostId(post.getId());
        post.getCommits().add(commit.getId());
        DataBase.commits.put(commit.getId(), commit);
        return commit;
    }
}
