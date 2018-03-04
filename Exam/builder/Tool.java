package com.Exam.builder;

import java.util.LinkedList;
import java.util.List;

public class Tool {
    private List<String> type = new LinkedList<>();
    private String name;

    public void addType (String type){
        this.type.add(type);
    }

    public List<String> getType(){
        return type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
