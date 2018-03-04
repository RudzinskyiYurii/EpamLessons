package com.lesson10;

public class OpenedStatus extends Status {

    public OpenedStatus(Task task){
        super(task);
        task.setOpened(true);
    }

    @Override
    public String onClose() {
        if (task.isOpened()){
            task.changeStatus(new ResolvedStatus(task));
            return "Task closed";
        }
        else
            return "Fatal error!";

    }

    @Override
    public String onOpen() {
        if (!task.isResolved() & !task.isReopened()){
            task.changeStatus(new ResolvedStatus(task));
            return "Task opened";
        }
        else
            return "Fatal error!";
    }

    @Override
    public String onReopen() {
        return "Fatal error!";
    }

    @Override
    public String onResolve() {
        return "Fatal error!";
    }
}
