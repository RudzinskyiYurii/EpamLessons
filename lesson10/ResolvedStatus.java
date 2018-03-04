package com.lesson10;

public class ResolvedStatus extends Status{

    public ResolvedStatus(Task task){
        super(task);
        task.setResolved(true);
    }

    @Override
    public String onClose() {

        if (task.isResolved() ){
            task.changeStatus(new ClosedStatus(task));
            return "Task closed";
        }
        else
            return "Fatal error!";
    }

    @Override
    public String onOpen() {
        return "Fatal error!";
    }

    @Override
    public String onReopen() {
        if (task.isOpened() | task.isResolved() ){
            task.changeStatus(new ReopenedStatus(task));
            return "Task reopened";
        }
        else
            return "Fatal error!";
    }

    @Override
    public String onResolve() {
        if (task.isOpened() | task.isResolved() ){
            task.changeStatus(new ResolvedStatus(task));
            return "Task resolved";
        }
        else
            return "Fatal error!";
    }
}
