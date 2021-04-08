package com.griddynamics.finalTask;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

public class User {
    private String userId;
    private final String firstName;
    private final String lastName;
    private String nickName;
    private String phoneNumber;
    private List<Goal> goals;

    /**
     * @param firstName   - first name couldn't be edited
     * @param lastName    - last name couldn't be edited
     * @param nickName    - could be changed
     * @param phoneNumber - user phone number
     */
    public User(@Nonnull String firstName, @Nonnull String lastName, @Nonnull String nickName, @Nonnull String phoneNumber) {
        this.userId = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
        validatePhone(phoneNumber);
        this.phoneNumber = phoneNumber;
        this.goals = new ArrayList<>();
    }

    /**
     * @param goalName - name of a goal
     * @return - Object Goal
     * @throws NoSuchElementException - there is no such goal of user
     */
    public Goal findGoal(String goalName) throws NoSuchElementException {
        return goals.stream()
                .filter(goal -> goal.getName().equalsIgnoreCase(goalName))
                .findAny().get();
    }

    public void writeGoals() {
        if (goals == null || goals.isEmpty()) {
            System.out.println("There are no goals");
        } else {
            for (Goal goal : goals) {
                System.out.println(goal);
            }
        }
    }

    /**
     * @param goal - name of a goal, that needs to be added
     */
    public void addGoal(Goal goal) {
        goals.add(goal);
    }

    public String getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public List<Goal> getGoals() {
        return goals;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setNickName(@Nonnull String nickName) {
        this.nickName = nickName;
    }

    public void setPhoneNumber(@Nonnull String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setGoals(List<Goal> goals) {
        this.goals = goals;
    }

    @Override
    public String toString() {
        return "User:" +
                "userId='" + userId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'';
    }
    public static void validatePhone(String name) {
        if (!name.matches("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$")) {
            throw new IllegalArgumentException("Wrong phone format.");
        }
    }

}
