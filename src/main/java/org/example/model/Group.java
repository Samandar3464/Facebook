package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Group {
    private int groupId;
    private String groupName;
    private String groupDescriptions;
    protected List<Integer> membersId = new ArrayList<>();
    protected List<Integer> messages = new ArrayList<>();
}
