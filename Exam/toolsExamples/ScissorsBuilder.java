package com.Exam.toolsExamples;

import com.Exam.builder.ToolsBuilder;
import com.Exam.interfaces.ToolForBrush;

public class ScissorsBuilder extends ToolsBuilder implements ToolForBrush {
    public void buildType(){
        tool.setType("Brush");
    }

    @Override
    public void buildName() {
        tool.setName("Scissors");
    }
}
