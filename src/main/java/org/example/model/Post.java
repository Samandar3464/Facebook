package org.example.model;
import lombok.Data;
import org.example.Base;
import java.util.*;
@Data

public class Post extends Base {
private int ownerId;
private  Object post;
private int likes;
protected List<Integer> commits=new LinkedList<>();

}

