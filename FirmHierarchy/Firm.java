package com.FirmHierarchy;


import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Firm {

    public void firmWorking(){
        printingFirmTreeAsText(simulationOfFirmWorking(createRandomEmployees()));

//        Employee emp1 = Employee.newBuilder()
//                .setEmployeeName("Augistin")
//                .setEmployeeSalary(100)
//                .build();
//
//        Employee emp2 = Employee.newBuilder()
//                .setEmployeeName("Paul")
//                .setEmployeeSalary(200)
//                .build();
//
//        Employee emp3 = Employee.newBuilder()
//                .setEmployeeName("Julia")
//                .setEmployeeSalary(150)
//                .build();
//
//        //some one decided that emp1 ready to rise))
//        emp1.setRaised(true);
//        System.out.println(emp1.getPosition().onLowManager());
//        emp1.addWard(emp2);
//        emp1.addWard(emp3);
//        System.out.println(emp3.getMaster().getName());
//        for (Employee e : emp1.getWards())
//            System.out.println(e.getName());

        /*emp1.setRaised(true);
        System.out.println(emp1.getPosition().onHighManager());
        System.out.println(emp1.getPosition().onLowManager());
        System.out.println(emp1.getPosition().onSimpleEmployee());
        System.out.println(emp1.getName() + " has " + emp1.getSalary() + "$ salary.");
        emp1.setLowered(true);
        System.out.println(emp1.getPosition().onSimpleEmployee());
        System.out.println(emp1.getPosition().onLowManager());

        System.out.println(emp1.getName() + " has " + emp1.getSalary() + "$ salary.");*/
    }



    public List<Employee> createRandomEmployees(){
        List<Employee> employees = new LinkedList<>();
        for (int i = 0; i < 20; i++){
            employees.add(Employee.newBuilder()
                    .setEmployeeName("Employee" + (i + 1))
                    .setEmployeeSalary(100 + (new Random().nextDouble()) * 100)
                    .build());
        }
        return employees;
    }

    public List<Employee> simulationOfFirmWorking(List<Employee> employees){

        for (int j = 0; j < 3; j++) {
            for (Employee e : employees) {
                e.setRaised(new Random().nextBoolean());
                e.getPosition().onHighManager();
                e.getPosition().onLowManager();

                for (int i = 0; i < new Random().nextInt(3); i++) {
                    e.addWard(getRandomEmployee(employees));
                }
            }
        }

        return employees;
    }

    private Employee getRandomEmployee(List<Employee> employees){
        return employees.get(new Random().nextInt(18));
    }

    private void printingFirmTreeAsText(List<Employee> employees) {
        for (Employee e : employees) {
            if (e.getMaster() == null)
                System.out.println(e.getName() + " without master");
            else
                System.out.println(e.getName() + " has master " + e.getMaster().getName());
        }
    }

}
