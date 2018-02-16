package com.lesson10;

public class ReopenedStatus extends Status{

    public ReopenedStatus(Task task){
        super(task);
        task.setReopened(true);
    }

    @Override
    public String onClose() {
        return "Fatal error!";
    }

    @Override
    public String onOpen() {
        return "Fatal error!";
    }

    @Override
    public String onReopen() {
        if (task.isResolved()){
            task.changeStatus(new ReopenedStatus(task));
            return "Task reopened";
        }
        else
            return "Fatal error!";
    }

    @Override
    public String onResolve() {
        if (task.isReopened()){
            task.changeStatus(new ResolvedStatus(task));
            return "Task resolved";
        }
        else
            return "Fatal error!";
    }
}
