package org.example.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.Base;

import java.util.*;

@Data
@NoArgsConstructor
public class Post extends Base {
    private int ownerId;
    private Object post;
    private int likes;
    private int postId;




}

