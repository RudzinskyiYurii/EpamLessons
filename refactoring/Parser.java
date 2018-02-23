package com.refactoring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

public class Parser {

    public final static char DOLLARSIGN = '$';
    public final static char EXCLAMATIONMARK = '!';


    public void Parse() throws IOException

    {
        String scriptTextToProcess = "";
        StringBuilder scope = new StringBuilder();
        String line = readLine(scriptTextToProcess);

        AddTheLine addLine;


        while (line != null)
        {
            addLine = usageTheLine(line);
            scope = addLine.addTheLine(scope, line);
            line = readLine(scriptTextToProcess);
        }
    }

    private AddTheLine usageTheLine(String line) {


        Map<Character, AddTheLine> parseredCommands = new HashMap<>();

        parseredCommands.put(DOLLARSIGN,new AddLineAsAVariable());
        parseredCommands.put(EXCLAMATIONMARK,new AddLineAsACommand());


        return parseredCommands.get(line.charAt(0));
    }

    private String readLine(String scriptTextToProcess) throws IOException {

        //StringReader reader = new StringReader(scriptTextToProcess);
        //BufferedReader bufReader = new BufferedReader(reader);
        //return bufReader.readLine();
        return new BufferedReader(new StringReader(scriptTextToProcess)).readLine();
    }

}
