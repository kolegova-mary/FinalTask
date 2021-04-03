package com.griddynamics.finalTask.actions;

import com.griddynamics.finalTask.Goal;
import com.griddynamics.finalTask.Manager;
import com.griddynamics.finalTask.User;

import java.util.NoSuchElementException;

import static com.griddynamics.finalTask.FinalTask.in;
import static com.griddynamics.finalTask.actions.ActionParser.parseBoolean;

public class AddGoalAction implements Action {

    @Override
    public void execute() {
        System.out.println("Write first name, who has/had this goal?");
        String firstName = in.nextLine();
        System.out.println("Write last name, who has/had this goal?");
        String lastName = in.nextLine();
        //it shouldn’t contain numbers and special characters like: “!@#$%^&*(){}”|?><:;’”
        //it shouldn’t be less than 6 characters and more than 20
        System.out.println("Write name of the goal:");
        String name = in.nextLine();
        //it shouldn’t be less than 10 characters and more than 50
        System.out.println("Write description of the goal:");
        String description = in.nextLine();
        System.out.println("Is it reached? Write yes or no, please:");
        String isReached = in.nextLine();
        try {
            User user = Manager.findUser(firstName, lastName);
            Goal goal = new Goal(name, description, parseBoolean(isReached));
            user.addGoal(goal);
        } catch (NoSuchElementException e) {
            System.out.println("User not found.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
