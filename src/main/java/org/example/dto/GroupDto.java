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
            System.out.println("enter group descriptions ");
            String description = scanner.nextLine();
        System.out.println("enter group userName ");
        String username = scanner.nextLine();
            group.setGroupName(groupName);
            group.setGroupDescriptions(description);
            group.setUserName(username);
            group.getMembersId().add(userId);
            group.setAdminId(userId);
            return group;

    }
    public boolean joinGroup(int userId,String groupName){
        Group search = groupService.search(groupName);
        if (search!=null){
            search.getMembersId().add(userId);
            return true;
        }else return false;
    }


}
