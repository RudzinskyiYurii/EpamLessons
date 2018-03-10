package com.LambdasAndStreams.Collections;

import java.util.ArrayList;
import java.util.List;

public class CreatingCollection {
    public List<Employee> creating() {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee("Matt", "London", 36, 15, Positions.MANAGER));

        employees.add(new Employee("Ivan", "Lviv", 55, 27, Positions.MANAGER));

        employees.add(new Employee("Mikel", "Marseille", 36, 13, Positions.MANAGER));

        employees.add(new Employee("Merry", "London", 25, 6, Positions.WORKER));

        employees.add(new Employee("Merry ", "London", 25, 6, Positions.WORKER));

        employees.add(new Employee("John", "Liverpool", 22, 1, Positions.WORKER));

        employees.add(new Employee("Robert", "Manchester", 45, 18, Positions.MANAGER));

        employees.add(new Employee("Tom ", "London", 37, 19, Positions.DIRECTOR));

        employees.add(new Employee("Eva", "Krakow", 29, 6, Positions.WORKER));

        employees.add(new Employee("Jared", "Manchester", 38, 14, Positions.WORKER));

        employees.add(new Employee("Jared", "Manchester", 38, 14, Positions.WORKER));

        employees.add(new Employee("Andriy", "Ternopil", 23, 4, Positions.WORKER));

        employees.add(new Employee("Marta", "Poltava", 33, 10, Positions.DIRECTOR));

        employees.add(new Employee("Emma", "Chicago", 22, 3, Positions.WORKER));

        employees.add(new Employee("Emilia", "London", 24, 7, Positions.WORKER));

        employees.add(new Employee("Emilia", "London", 24, 7, Positions.WORKER));

        return employees;

    }
}
