package com.Exam.toolsExamples;

import com.Exam.builder.ToolsBuilder;
import com.Exam.interfaces.TestInterface;
import com.Exam.interfaces.ToolForTree;

public class TestBuilder extends ToolsBuilder implements TestInterface, ToolForTree {

    public void buildType(){
        tool.addType(addTestType());
        tool.addType(addTreeType());
    }

    public void buildName(){
        tool.setName("Test");
    }

    @Override
    public String addTestType() {
        return "Test";
    }

    @Override
    public String addTreeType() {
        return "Tree";
    }
}
