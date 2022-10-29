package org.example.service;

import org.example.DataBase;
import org.example.model.Group;
import org.example.model.User;

import java.util.Map;

public class GroupService {
    MessageService messageService = new MessageService();
    Group group = new Group();

    public boolean addGroup(Group group) {
        if (DataBase.groups.isEmpty() || DataBase.groups.get(group.getId()) == null) {
            for (Map.Entry<Integer, Group> integerGroupEntry : DataBase.groups.entrySet()) {
                if (integerGroupEntry.getValue().isActive()&&integerGroupEntry.getValue().getUserName().equals(group.getUserName())) {
                    return false;
                }
            }
            DataBase.groups.put(group.getId(), group);
            return true;
        }
        return false;
    }

    public Group search(String groupUserName) {
        for (Map.Entry<Integer, Group> integerGroupEntry : DataBase.groups.entrySet()) {
            if (integerGroupEntry.getValue().isActive()&&integerGroupEntry.getValue().getUserName().equals(groupUserName)) {
                return integerGroupEntry.getValue();
            }
        }
        return null;
    }


    public void showAllMessagesInGroup(int groupId, int userId) {

        System.out.println(group.getGroupName());
        if (getById(groupId) != null) {
            for (Integer integer : getById(groupId).getMembersId()) {
                if (integer == userId) {
                    messageService.showAllMessages(groupId);
                }
            }
        } else {
            System.out.println("group nut found");
        }
    }

    public Group getById(int groupId) {
        for (Integer integer : DataBase.groups.keySet()) {
            if (integer == groupId) {
                return DataBase.groups.get(integer);
            }
        }
        return null;
    }

    public void showUserGroups(User user) {
        if (DataBase.groups.isEmpty()) return;
        for (Integer integer : user.getGroupsId()) {
            if (DataBase.groups.get(integer)!=null&&DataBase.groups.get(integer).isActive()) {
                System.out.println(DataBase.groups.get(integer).getId()+" : "+DataBase.groups.get(integer).getGroupName());
            }
        }
    }

}
