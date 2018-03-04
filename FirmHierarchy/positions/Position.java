package com.FirmHierarchy.positions;

import com.FirmHierarchy.Employee;

public abstract class Position {
    public Employee employee;

    public Position(Employee employee){
        this.employee = employee;
    }

    public abstract String onHighManager();
    public abstract String onLowManager();
    public abstract String onSimpleEmployee();
    //public abstract void onDirector();
}
