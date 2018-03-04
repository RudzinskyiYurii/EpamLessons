package com.FirmHierarchy.positions;

import com.FirmHierarchy.Employee;

public class LowManager extends Position{

    public LowManager(Employee employee) {
        super(employee);
        employee.setNothingChanged(true);
    }

    @Override
    public String onHighManager() {
        if (employee.isRaised()){
            employee.changePosition(new HighManager(this.employee));
            // when grow up -> salary grow at 20%
            employee.setSalary(employee.getSalary() * 1.2);
            //employee.getMaster().getWards().remove(employee);
            employee.setManager(true);
            return employee.getName() + " become a high manager!";
        }
        else
            return "Fatal error!";
    }

    @Override
    public String onLowManager() {
        if (employee.isNothingChanged()) {
            employee.changePosition(new LowManager(this.employee));
            employee.setManager(true);
            return employee.getName() + " is still low manager!";
        }
        else
            return "Fatal error!";
    }

    @Override
    public String onSimpleEmployee() {
        if (employee.isLowered()){
            employee.changePosition(new SimpleEmployee(this.employee));
            // when grow down -> salary grow down at 30%
            employee.setSalary(employee.getSalary() * 0.7);
            employee.setManager(false);
            return employee.getName() + " has been lowered to simple employee!";
        }
        else
            return "Fatal error!";
    }
}
