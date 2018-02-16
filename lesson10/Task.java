package com.lesson10;

public class Task {
    private boolean opened;
    private boolean closed;
    private boolean reopened;
    private boolean resolved;
    private Status status;

    public Task(){
        this.status = new OpenedStatus(this);
        setOpened(true);
    }

    public boolean isOpened(){
        return opened;
    }

    public boolean isClosed(){
        return closed;
    }

    public boolean isReopened(){
        return reopened;
    }

    public boolean isResolved(){
        return resolved;
    }

    public void setOpened(boolean opened) {
        if (opened){
            this.closed = false;
            this.reopened = false;
            this.resolved = false;
        }
        this.opened = opened;
    }

    public void changeStatus(Status status){
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setClosed(boolean closed) {
        if (closed){
            this.opened = false;
            this.reopened = false;
            this.resolved = false;
        }
        this.closed = closed;
    }

    public void setReopened(boolean reopened) {
        if (reopened){
            this.opened = false;
            this.closed = false;
            this.resolved = false;
        }
        this.reopened = reopened;
    }

    public void setResolved(boolean resolved) {
        if (resolved){
            this.opened = false;
            this.reopened = false;
            this.closed = false;
        }
        this.resolved = resolved;
    }
}
