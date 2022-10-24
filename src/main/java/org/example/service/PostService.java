package org.example.service;

import org.example.model.Post;

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class PostService {

    public static Scanner scannerint = new Scanner(System.in);
    public static Scanner scannersrt = new Scanner(System.in);
    public static HashMap<Integer,Objects> posts = new HashMap<>();

    public boolean add(){
        return true;
    }

    public boolean addPost(int ownId,Objects post){
        if(ownId!=0 && post!=null){
            posts.put(ownId,post);
        }
        return true;
    }

    public void start(){
        int var = 10;
        while (var!=0){
            System.out.println("1. Add Commit , 2. Click like botton 3. Back");
            var = scannerint.nextInt();
            switch (var){
                case 1->{
                    System.out.println("write your commit");
//                    write code
                }
                case 2->{
                    System.out.println("like like like");
//                    click like botton
                }
            }
        }
    }



}
