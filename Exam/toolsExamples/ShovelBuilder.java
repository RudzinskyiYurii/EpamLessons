package com.Exam.toolsExamples;

import com.Exam.builder.ToolsBuilder;
import com.Exam.interfaces.ToolForBrush;
import com.Exam.interfaces.ToolForGround;
import com.Exam.interfaces.ToolForTree;

public class ShovelBuilder extends ToolsBuilder implements ToolForGround, ToolForTree, ToolForBrush {
    public void buildType(){
        tool.setType("All");
    }

    public void buildName(){
        tool.setType("Shovel");
    }
}
