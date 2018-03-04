package com.FirmHierarchy;

import com.FirmHierarchy.positions.Position;
import com.FirmHierarchy.positions.SimpleEmployee;

import java.util.HashSet;
import java.util.Set;

public class Employee {

    private String name;
    private double salary;

    private Set<Employee> wards = new HashSet<>();
    private boolean manager;
    private boolean raised;
    private boolean lowered;
    private boolean nothingChanged;
    private Position position;
    private Employee master;

    private Employee(){
        this.position = new SimpleEmployee(this);
    }

//    public Employee(Employee master){
//        this.master = master;
//        setNothingChanged(true);
//    }

    public Employee getMaster() {
        return master;
    }

    public void setMaster(Employee master) {

        this.master = master;
    }

    public static Builder newBuilder(){
        return new Employee().new Builder();
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public Set<Employee> getWards() {
        return wards;
    }

    public void setWards(Set<Employee> wards) {
        if (isManager())
            this.wards = wards;
        //else
            //System.out.println("You can`t have a ward!");
    }

    public void addWard(Employee employee){
        if (isManager()) {
            this.wards.add(employee);
            employee.setMaster(this);
        }
//        else
//            System.out.println("You can`t have a ward!");
    }

    public void setManager(boolean manager) {
        this.manager = manager;
    }

    public boolean isManager(){return manager;}


    /*-----Nested builder---------------------------------------------------------------------------------------------*/

    public class Builder{
        private Builder(){

        }

        public Builder setEmployeeName(String name){
            Employee.this.name = name;
            return this;
        }

        public Builder setEmployeeSalary(double salary){
            Employee.this.salary = salary;
            return this;
        }

        public Builder setEmployeeMaster(Employee master){
            Employee.this.master = master;
            return this;
        }

        public Builder setEmployeeWards(Set<Employee> wards){
            Employee.this.wards = wards;
            return this;
        }

        public Employee build(){
            System.out.println("Firm hired " + name);
            return Employee.this;
        }

    }
    /*------State logic-----------------------------------------------------------------------------------------------*/

    public boolean isRaised(){return raised;}
    public boolean isLowered(){return lowered;}
    public boolean isNothingChanged(){return nothingChanged;}

    public Position getPosition(){return position;}
    public void changePosition(Position position){this.position = position;}

    public void setRaised(boolean raised){
        if (raised){
            this.lowered = false;
            this.nothingChanged = false;
        }
        this.raised = raised;
    }

    public void setLowered (boolean lowered){
        if (lowered) {
            this.raised = false;
            this.nothingChanged = false;
        }
        this.lowered = lowered;
    }

    public void setNothingChanged (boolean nothingChanged){
        if (nothingChanged){
            this.lowered = false;
            this.raised = false;
        }
        this.nothingChanged = nothingChanged;
    }


}
