package com.griddynamics.finalTask;

import com.griddynamics.finalTask.actions.Action;
import com.griddynamics.finalTask.actions.ActionParser;
import com.griddynamics.finalTask.actions.MenuAction;

import java.util.Scanner;

/**
 * @author mkolegova
 */
public class FinalTask {
    public static final Scanner in = new Scanner(System.in);

    /**
     * @see ActionParser#parse(int)
     */
    public static void main(String[] args) {
        System.out.println("Hello!");
        //noinspection InfiniteLoopStatement
        while (true) {
            try {
                new MenuAction().execute();
                int actionNumber = Integer.parseInt(in.nextLine());
                Action action = new ActionParser().parse(actionNumber);
                action.execute();
            } catch (NumberFormatException|IllegalStateException e) {
                System.out.println("Write integer number from 1 to 9 please!");
            }
        }
    }
}
