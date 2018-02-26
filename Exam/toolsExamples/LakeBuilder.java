package com.Exam.toolsExamples;

import com.Exam.builder.ToolsBuilder;
import com.Exam.interfaces.ToolForBrush;
import com.Exam.interfaces.ToolForGround;
import com.Exam.interfaces.ToolForTree;

public class LakeBuilder extends ToolsBuilder implements ToolForBrush, ToolForTree, ToolForGround {
    public void buildType(){
        tool.setType("All");
    }

    public void buildName(){
        tool.setName("Lake");
    }
}
