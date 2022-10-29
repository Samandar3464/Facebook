package org.example.model;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.*;
@Getter
@Setter

public class Post extends Base {
private int ownerId;
private  String post;
private Set<Integer> likes =new HashSet();
protected List<Integer> commits=new LinkedList<>();

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", ownerId=" + ownerId +
                ", post='" + post + '\'' +
                '}';
    }
}

