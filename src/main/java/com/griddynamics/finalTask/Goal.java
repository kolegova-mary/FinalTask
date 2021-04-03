package com.griddynamics.finalTask;

import javax.annotation.Nonnull;
import java.util.UUID;

public class Goal {
    private String goalId;
    private final String name;
    private String description;
    private boolean isReached;

    /**
     * @param name        - name of a goal
     * @param description - provides the main idea of the goal
     * @param reachedIf   - is it reached (true/false)
     */
    public Goal(@Nonnull String name, @Nonnull String description, boolean reachedIf) {
        this.goalId = UUID.randomUUID().toString();
        validateGoalName(name);
        this.name = name;
        setDescription(description);
        this.isReached = reachedIf;
    }

    /**
     * @return - generated ID for goal
     */
    public String getGoalId() {
        return goalId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isReachedIf() {
        return isReached;
    }

    public void setGoalId(String goalId) {
        this.goalId = goalId;
    }

    @Override
    public String toString() {
        return "Goal:" +
                "goalId='" + goalId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", isReached=" + isReached + '\'';
    }

    public void setDescription(@Nonnull String description) {
        if (!(description.length() >= 10 && description.length() <= 50)) {
            throw new IllegalArgumentException("Description should be no less than 10 and no more than 50.");
        }
        this.description = description;
    }

    public void setReachedIf(boolean reachedIf) {
        this.isReached = reachedIf;
    }

    /**
     * @param name - name of a goal
     */
    public static void validateGoalName(String name) {
        if (!name.matches("[a-zA-Z0-9 ]{6,20}")) {
            throw new IllegalArgumentException("Goal name should be no less than 6 " +
                    "and no more than 20. It shouldn't contain symbols like: \"!@#$%^&*(){}”|?><:;\"");
        }
    }
}
