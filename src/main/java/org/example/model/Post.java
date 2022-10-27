package org.example.model;
import lombok.Data;

import java.util.*;
@Data

public class Post extends Base {
private int ownerId;
private  String post;
private int likes;
protected List<Integer> commits=new LinkedList<>();
}

