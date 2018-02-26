package com.Exam;

public class Shop {
    public void usageAllTHings(){
        ToolsService toolsService = new ToolsService();

        toolsService.printList(toolsService.sortedListOfTools());
        toolsService.printList(toolsService.listOfToolsForTree());
    }
}
