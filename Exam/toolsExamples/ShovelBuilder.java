package com.Exam.toolsExamples;

import com.Exam.builder.ToolsBuilder;
import com.Exam.interfaces.ToolForBrush;
import com.Exam.interfaces.ToolForGround;
import com.Exam.interfaces.ToolForTree;

public class ShovelBuilder extends ToolsBuilder implements ToolForGround, ToolForTree, ToolForBrush {
    public void buildType(){
        tool.addType(addTreeType());
        tool.addType(addBrushType());
        tool.addType(addGroundType());
    }

    public void buildName(){
        tool.setName("Shovel");
    }

    @Override
    public String addTreeType() {
        return "Tree";
    }

    @Override
    public String addBrushType() {
        return "Brush";
    }

    @Override
    public String addGroundType() {
        return "Ground";
    }
}
