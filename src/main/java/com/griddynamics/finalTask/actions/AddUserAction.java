package com.griddynamics.finalTask.actions;

import com.griddynamics.finalTask.Manager;
import com.griddynamics.finalTask.User;

import static com.griddynamics.finalTask.FinalTask.in;

public class AddUserAction implements Action {

    @Override
    public void execute() {
        System.out.println("Write first name of the user:");
        String firstName = in.nextLine();
        System.out.println("Write last name of the user:");
        String lastName = in.nextLine();
        System.out.println("Write nickname");
        String nickName = in.nextLine();
        System.out.println("Write new phone number:");
        String phone = in.nextLine();
        Manager.addUser(new User(firstName, lastName, nickName, phone));
    }

}
