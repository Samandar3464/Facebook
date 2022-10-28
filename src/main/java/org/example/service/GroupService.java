package org.example.service;

import org.example.DataBase;
import org.example.model.Group;

public class GroupService {
    MessageService messageService = new MessageService();
    Group group = new Group();
    public boolean addGroup(Group group){
        DataBase.groups.put(group.getGroupId(),group);
        return true;
    }

    public Group search(String groupName){
        for (Integer integer : DataBase.groups.keySet()) {
            if(DataBase.groups.get(integer).equals(groupName)){
                return DataBase.groups.get(integer);
            }
        }
        return null;
    }

    public boolean checkGroupName(String groupName){
        for (Integer integer : DataBase.groups.keySet()) {
            if(DataBase.groups.get(integer).equals(groupName)){
                return false;
            }
        }
        return true;
    }

    public void showallMessagesinGroup(int groupId, int userId){

        System.out.println(group.getGroupName());
        if(getById(groupId)!=null) {
            for (Integer integer : getById(groupId).getMembersId()) {
                if (integer == userId) {
                    messageService.showAllMessages(groupId);
                }
            }
        } else {
            System.out.println("group nut found");
        }
    }

    private Group getById(int groupId){
        for (Integer integer : DataBase.groups.keySet()) {
            if(integer == groupId){
                return DataBase.groups.get(integer);
            }
        }
        return null;
    }

    public void myGroups(int userId){
        for (Integer integer : DataBase.groups.keySet()) {
            for (Integer integer1 : DataBase.groups.get(integer).getMembersId()) {
                if(integer1 == userId){
                    System.out.println(DataBase.groups.get(integer1).getGroupName());
                }
            }
        }
    }

}
