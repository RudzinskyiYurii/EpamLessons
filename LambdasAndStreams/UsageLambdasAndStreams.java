package com.LambdasAndStreams;

import com.FirmHierarchy.positions.Position;
import com.LambdasAndStreams.Collections.CreatingCollection;
import com.LambdasAndStreams.Collections.Employee;
import com.LambdasAndStreams.Collections.Positions;
import com.lesson1.ex2.ex2_1.Sort;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class UsageLambdasAndStreams {
    List<Employee> collection = new CreatingCollection().creating();

    public void firstTask(){
        collection.stream()
                .skip(collection.size() - 4)
                .forEach(System.out::println);
    }

    public void secondTask(){
        collection.stream()
                .filter((e) -> (Positions.MANAGER.equals(e.getPosition())
                        | Positions.DIRECTOR.equals(e.getPosition())) & e.getName().startsWith("M"))
                .forEach(System.out::println);
    }

    public void thirdTask(){
        collection.stream()
                .filter((e) -> Positions.MANAGER.equals(e.getPosition()))
                .map((Employee::getName))
                //.collect(Collectors.toList());
                .forEach(System.out::println);
    }

    public void fourthTask(){
        collection.stream()
                .distinct()
                .filter((e) -> e.getWorkExperience() > 5)
                .forEach(System.out::println);
    }

    public void fifthTask(){
        List<Employee> newEmpl = collection.stream()
                .filter((e) -> "London".equals(e.getNativeCity()))
                .collect(Collectors.toList());
        for(Employee e: newEmpl ) System.out.println(e);
    }

    public void sixthTask(){
        System.out.println(collection.stream()
                .filter((e) -> e.getAge() > 30)
                .count());
    }

    public void seventhTask(){
        System.out.println(collection.stream()
                .mapToDouble((s) ->s.getWorkExperience())
                .average());
    }

    public void eigththTask(){
        collection.stream()
                .map((s) -> s.getWorkExperience() + 1)
                .forEach(e -> System.out.println(e));
    }

    public void ninthTask(){
        collection.stream()
                .filter(e -> !"Manchester".equals(e.getNativeCity()) && (e.getAge() > 25 && e.getAge() < 35))
                .forEach(System.out::println);

    }

    public void tenthTask(){
        collection.stream()
                .sorted(Comparator.comparing(e -> e.getAge()))
                .forEach(System.out::println);
    }


}
