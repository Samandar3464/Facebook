package org.example.dto;

import org.example.model.Base;
import org.example.model.Group;
import org.example.service.GroupService;

import java.util.Scanner;

public class GroupDto extends Base {
    GroupService groupService = new GroupService();
    Scanner scanner = new Scanner(System.in);

    public Group creatGroup(int userId){
        Group group = new Group();

        System.out.println("enter group name? ");
        String groupName = scanner.nextLine();
        if(groupService.checkGroupName(groupName)) {
            System.out.println("enter group descriptions ");
            String description = scanner.nextLine();
            group.setGroupName(groupName);
            group.setGroupDescriptions(description);
            group.getMembersId().add(userId);
            return group;
        }else {
            return null;
        }
    }

    public boolean joinGroup(int userId,String groupName){
        Group search = groupService.search(groupName);
        if (search!=null){
            search.getMembersId().add(userId);
            return true;
        }else return false;
    }


}
