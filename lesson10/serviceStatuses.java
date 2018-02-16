package com.lesson10;

public class serviceStatuses {

    public void usageStatus() {
        Task task1 = new Task();

        System.out.println(task1.getStatus().onOpen());
        System.out.println(task1.getStatus().onClose());
        System.out.println(task1.getStatus().onOpen());
        System.out.println(task1.getStatus().onResolve());
        System.out.println(task1.getStatus().onOpen());
        System.out.println(task1.getStatus().onClose());
        System.out.println(task1.getStatus().onReopen());
        System.out.println(task1.getStatus().onReopen());
        System.out.println(task1.getStatus().onClose());
        System.out.println(task1.getStatus().onResolve());
        System.out.println(task1.getStatus().onOpen());
        System.out.println(task1.getStatus().onClose());

    }
}
