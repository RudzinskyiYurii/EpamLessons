package com.Exam.builder;


public abstract class ToolsBuilder {
    public Tool tool;

    public Tool getTool(){
        return tool;
    }

    public void createTool(){
       tool = new Tool();
    }
    public abstract void buildType();
    public abstract void buildName();
}
