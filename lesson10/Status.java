package com.lesson10;

public abstract class Status {

    public Task task;

    public Status (Task task){
        this.task = task;
    }

    public abstract String onOpen();
    public abstract String onReopen();
    public abstract String onClose();
    public abstract String onResolve();

}
