package com.Exam;

import com.Exam.builder.Director;
import com.Exam.builder.Tool;
import com.Exam.builder.ToolsBuilder;
import com.Exam.interfaces.ToolForTree;
import com.Exam.toolsExamples.LakeBuilder;
import com.Exam.toolsExamples.ScissorsBuilder;
import com.Exam.toolsExamples.ShovelBuilder;
import com.Exam.toolsExamples.TestBuilder;


import java.util.*;

public class ToolsService {
    List<Tool> tools = new LinkedList<>();

    private Tool creatingTool(ToolsBuilder toolsBuilder) {


        Director director = new Director();

        director.setToolsBuilder(toolsBuilder);
        director.contsructTool();

        return director.getTool();

    }

    public List<Tool> createToolsList() {
        //List<Tool> tools = new LinkedList<>();

        tools.add(creatingTool(new ShovelBuilder()));
        tools.add(creatingTool(new LakeBuilder()));
        tools.add(creatingTool(new ScissorsBuilder()));

        return tools;
    }

    //bad sorting using map tree :(

//    public List<Tool> sortedListOfTools() {
//        List<Tool> tools = createToolsList();
//        List<Tool> sortedList = new LinkedList<>();
//        Map<String, Tool> toolsType = new HashMap<>();
//        for (Tool t : tools) {
//            toolsType.put(t.getType(), t);
//        }
//      /*  Map<String, Tool> treeToolsType = new TreeMap<>(toolsType);
//      for (Tool t: treeToolsType.values())
//          sortedList.add(t);*/
//
//        Map<String, Tool> treeOfTypes = new TreeMap<>(new Comparator<String>() {
//            @Override
//            public int compare(String s, String t1) {
//                return s.compareTo(t1);
//            }
//        });
//        treeOfTypes.putAll(toolsType);
//        sortedList.addAll(treeOfTypes.values());
//
//        return sortedList;
//    }

    /*public List<Tool> listOfToolsForTree() {
        List<Tool> list = new LinkedList<>();
        List<Tool> tools = createToolsList();
        for (Tool t : tools) {
            if (t.getClass() == ToolForTree.class)
                list.add(t);
        }
        return list;
    }*/

    //changing print format to userfriendly
    public void printList(List<Tool> tools) {
        System.out.println("-----------------------------------------");
        System.out.printf("%-10s\t\t%-10s\n" ,"Tool`s name" , "Tool`s type");
        System.out.println("-----------------------------------------");
        for (Tool t : tools)
            System.out.printf("%-10s\t\t%-10s\n" ,t.getName() , t.getType());
        System.out.println("-----------------------------------------\n");
    }


    //--------------------------------------------------------------------------------------------------
    //change some methods

    //good sorting
    public List<Tool> sortByType(){
        List<Tool> tools = createToolsList();
        sortedTypes(tools);
        Collections.sort(tools, new Comparator<Tool>(){
            @Override
            public int compare(Tool t1, Tool t2){
                return t1.getType().get(0).charAt(0) < t2.getType().get(0).charAt(0) ? -1 : 0;
            }
        });
        return tools;
    }


    private void sortedTypes(List<Tool> tools){
        for (Tool t : tools)
            t.getType().sort(Comparator.naturalOrder());
    }


    public void getAllToolsForTree(){

        List<Tool> tools = new LinkedList<>();
        List<Tool> treeTools = new LinkedList<>();
        tools.add(creatingTool(new TestBuilder()));
        tools.add(creatingTool(new ShovelBuilder()));

        for (Tool t : tools){
            for (String type : t.getType())
                if (type.equals("Tree"))
                    treeTools.add(t);
        }
       printList(treeTools);
    }


}
