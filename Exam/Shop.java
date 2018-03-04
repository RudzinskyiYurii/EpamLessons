package com.Exam;

public class Shop {
    public void usageAllTHings(){
        ToolsService toolsService = new ToolsService();


        //toolsService.printList(toolsService.listOfToolsForTree());
        toolsService.printList(toolsService.sortByType());
        toolsService.getAllToolsForTree();

    }
}
