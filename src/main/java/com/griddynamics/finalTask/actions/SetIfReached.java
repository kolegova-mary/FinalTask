package com.griddynamics.finalTask.actions;

import com.griddynamics.finalTask.Goal;
import com.griddynamics.finalTask.Manager;
import com.griddynamics.finalTask.User;

import java.util.NoSuchElementException;

import static com.griddynamics.finalTask.FinalTask.in;

public class SetIfReached implements Action {
    @Override
    public void execute( ) {
        System.out.println("Write first name of the user:");
        String firstName = in.nextLine();
        System.out.println("Write last name of the user:");
        String lastName = in.nextLine();
        User user = null;
        Goal goal = null;
        try {
            user = Manager.findUser(firstName, lastName);
        } catch (NoSuchElementException e) {
            System.out.println("User not found.");
            return;
        }
        System.out.println("Write name of the goal:");
        String name = in.nextLine();
        try {
            goal = user.findGoal(name);
        } catch (NoSuchElementException e) {
            System.out.println("Goal not found.");
            return;
        }
        System.out.println("Have the user already reached the goal? Write yes or no:");
        String answer = in.nextLine();
        try {
            goal.setReachedIf(ActionParser.parseBoolean(answer));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

