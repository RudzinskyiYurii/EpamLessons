package com.Exam.toolsExamples;

import com.Exam.builder.ToolsBuilder;
import com.Exam.interfaces.ToolForBrush;

public class ScissorsBuilder extends ToolsBuilder implements ToolForBrush {
    public void buildType(){
        tool.addType(addBrushType());
    }

    @Override
    public void buildName() {
        tool.setName("Scissors");
    }

    @Override
    public String addBrushType() {
        return "Brush";
    }
}
