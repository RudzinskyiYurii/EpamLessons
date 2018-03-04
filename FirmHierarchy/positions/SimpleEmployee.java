package com.FirmHierarchy.positions;

import com.FirmHierarchy.Employee;

public class SimpleEmployee extends Position {

    public SimpleEmployee(Employee employee) {
        super(employee);
        employee.setNothingChanged(true);
    }

    @Override
    public String onHighManager() {
        return "Fatal error!";
    }

    @Override
    public String onLowManager() {
        if (employee.isRaised()){
            employee.changePosition(new LowManager(this.employee));
            // when grow up -> salary grow at 20%
            employee.setSalary(employee.getSalary() * 1.2);
            employee.setManager(true);
            return employee.getName() + " become a low manager!";
        }
        else
            return "Fatal error!";
    }

    @Override
    public String onSimpleEmployee() {
        if (employee.isNothingChanged()) {
            employee.changePosition(new SimpleEmployee(this.employee));
            employee.setManager(false);
            return employee.getName() + " is still simple employee!";
        }
        else
            return "Fatal error!";
    }
}
