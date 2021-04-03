package com.griddynamics.finalTask.actions;

import static com.griddynamics.finalTask.FinalTask.in;

public class ExitAction implements Action {
    @Override
    public void execute() {
        in.close();
        System.exit(0);
    }
}
