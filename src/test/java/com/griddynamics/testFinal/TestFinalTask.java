package com.griddynamics.testFinal;

import com.griddynamics.finalTask.Goal;
import com.griddynamics.finalTask.Manager;
import com.griddynamics.finalTask.User;
import com.griddynamics.finalTask.actions.ActionParser;
import org.testng.annotations.Test;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TestFinalTask {
    @Test(expectedExceptions = IllegalStateException.class)
    public void testParser() {
        ActionParser actionParser = new ActionParser();
        actionParser.parse(10);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testShortNameOfGoal() {
        Goal goal = new Goal("", "qwjebuhfbsddqiwbduywebf", true);
    }

    @Test()
    public void testCorrectGoal1() {
        Goal goal = new Goal("qweqwe", "qwjqwewerb", false);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testLongNameOfGoal() {
        Goal goal = new Goal("hskfhsueorkdhenpslwiq", "qwjebuhfbsddBHISJQduywebf", true);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testWrongNameOfGoal() {
        Goal goal = new Goal("hs&*@&", "qwSCDSWSJQduywebf", true);
    }

    @Test()
    public void testSetDescriptionOfGoal() {
        Goal goal = new Goal("MURMURme", "qwSCDSW SJ Qdu", false);
        goal.setDescription("You need to complete smth");
        assertThat(goal, hasProperty("name", equalTo("MURMURme")));
        assertThat(goal, hasProperty("description", equalTo("You need to complete smth")));
        assertThat(goal, hasProperty("reachedIf", equalTo(false)));

    }

    @Test()
    public void testCorrectUser() {
        User user = new User("cvlrwqbnf&@G&D", "UBHSU9KXJjs", "NJKGiugecks", "+7847093173286");
        user.addGoal(new Goal("qweqweqweuweqweqHWu", "qwjqwe qwewe rbqwjq wewerbqwjRSLwerb", true));
        List<Goal> goals = user.getGoals();
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testWrongPhone() {
        User user = new User("cv&@G&D", "UcewrgKXJjs", "fcnrehBG*&DW", "123456789101168698686986896969698698989898");
    }

    @Test()
    public void testFindGoal() {
        User user = new User("cvlrwqbnf&@G&D", "UBHSU9KXJjs", "NJKGiugecks", "+7847093173286");
        user.addGoal(new Goal("qweqweqweuweqweqHWu", "qwjqwe qwewe rbqwjq wewerbqwjRSLwerb", true));
        user.addGoal(new Goal("qweqwe", "lelecimdajfb  sjkak", false));
        assertThat(user.findGoal("qweqwe"), hasProperty("description", equalTo("lelecimdajfb  sjkak")));
    }

    @Test()
    public void testManager() {
        User user1 = new User("cvlrwqbnf&@G&D", "UBHSU9KXJjs", "NJKGiugecks", "(495)1234567");
        Manager.addUser(user1);
        User user2 = new User("&@G&D", "U9KXJjs", "NJKGiugcercmecks", "8-926-123-45-67");
        Manager.addUser(user2);
        assertThat(Manager.findUser("&@G&D", "U9KXJjs"),samePropertyValuesAs(user2));
        assertThat(Manager.getUsers(), containsInAnyOrder(user1,user2));
    }
}
