package org.example.dto;

import org.example.model.Post;

import java.util.Scanner;

public class PostDto {
    Scanner scanner = new Scanner(System.in);

    public Post creatPost(int userId) {
        Post post =new Post();
        System.out.println("enter new post ");
        String newPost = scanner.nextLine();
        post.setPost(newPost);
        post.setOwnerId(userId);
        return post;
    }
   public int deletePost(){
       System.out.println("enter post id for delete ");
       return scanner.nextInt();
   }
}
