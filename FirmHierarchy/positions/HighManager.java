package com.FirmHierarchy.positions;

import com.FirmHierarchy.Employee;

public class HighManager extends Position {

    public HighManager(Employee employee) {
        super(employee);
        employee.setNothingChanged(true);
    }

    @Override
    public String onHighManager() {
        if (employee.isNothingChanged()) {
            employee.changePosition(new HighManager(this.employee));
            employee.setManager(true);
            return employee.getName() + " is still high manager!";
        }
        else
            return "Fatal error!";
    }

    @Override
    public String onLowManager() {
        if (employee.isLowered()){
            employee.changePosition(new LowManager(this.employee));
            // when grow down -> salary grow down at 30%
            employee.setSalary(employee.getSalary() * 0.7);
            employee.setManager(true);
            return employee.getName() + " has been lowered to low manager!";
        }
        else
            return "Fatal error!";
    }

    @Override
    public String onSimpleEmployee() {
        return "Fatal error!";
    }
}
