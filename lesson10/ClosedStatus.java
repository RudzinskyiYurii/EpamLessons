package com.lesson10;

public class ClosedStatus extends Status {
    public ClosedStatus(Task task){
        super(task);
        task.setClosed(true);

    }

    @Override
    public String onClose() {
        if (task.isOpened() | task.isResolved()){
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

        if (task.isClosed() ){
            task.changeStatus(new ReopenedStatus(task));
            return "Task reopened";
        }
        else
            return "Fatal error!";
    }

    @Override
    public String onResolve() {
        return "Fatal error!";
    }
}
