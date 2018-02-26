package com.Exam;

import com.Exam.builder.Director;
import com.Exam.builder.Tool;
import com.Exam.builder.ToolsBuilder;
import com.Exam.interfaces.ToolForTree;
import com.Exam.toolsExamples.LakeBuilder;
import com.Exam.toolsExamples.ScissorsBuilder;
import com.Exam.toolsExamples.ShovelBuilder;
import com.refactoring.Command;


import java.util.*;

public class ToolsService {
    public Tool creatingTool(ToolsBuilder toolsBuilder) {


    Director director = new Director();

    director.setToolsBuilder(toolsBuilder);
    director.contsructTool();

return director.getTool();

}

public List<Tool> createToolsList(){
        List<Tool> tools = new LinkedList<>();

        tools.add(creatingTool(new ShovelBuilder()));
        tools.add(creatingTool(new LakeBuilder()));
        tools.add(creatingTool(new ScissorsBuilder()));

        return tools;
}


public List<Tool> sortedListOfTools(){
    List<Tool> tools = createToolsList();
      List<Tool> sortedList = new LinkedList<>();
      Map<String, Tool> toolsType = new HashMap<>();
      for(Tool t: tools ){
          toolsType.put(t.getType(), t);
      }
      /*  Map<String, Tool> treeToolsType = new TreeMap<>(toolsType);
      for (Tool t: treeToolsType.values())
          sortedList.add(t);*/

    Map<String, Tool> treeOfTypes = new TreeMap<>(new Comparator<String>() {
        @Override
        public int compare(String s, String t1) {
            return s.compareTo(t1);
        }
    });
      treeOfTypes.putAll(toolsType);
    for (Tool t: treeOfTypes.values())
        sortedList.add(t);

      return sortedList;
}

public List<Tool> listOfToolsForTree(){
        List<Tool> list = new LinkedList<>();
    List<Tool> tools = createToolsList();
        for (Tool t : tools){
            if (t.getClass() == ToolForTree.class)
                list.add(t);
        }
    return list;
}

public void printList(List<Tool> tools){
        for (Tool t : tools)
            System.out.println(t.getType() + "\t\t\t" + t.getName());
}

}
