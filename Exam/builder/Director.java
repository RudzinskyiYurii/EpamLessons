package com.Exam.builder;

public class Director {
    private ToolsBuilder toolsBuilder;

    public void setToolsBuilder(ToolsBuilder toolsBuilder){
        this.toolsBuilder = toolsBuilder;
    }

    public Tool getTool(){
        return toolsBuilder.getTool();
    }

    public void contsructTool(){
        toolsBuilder.createTool();
        toolsBuilder.buildType();
        toolsBuilder.buildName();
    }
}
