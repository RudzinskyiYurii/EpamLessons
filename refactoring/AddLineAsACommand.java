package com.refactoring;

import java.util.HashMap;
import java.util.Map;

public class AddLineAsACommand implements AddTheLine {
    public static final String EXECUTE = "!execute";
    public static final String CUSTOMCOMMAND = "!custom_command";
    public static final String DIRECTIVE = "!single_line_directive";

    @Override
    public  StringBuilder addTheLine(StringBuilder scope, String line){
        // Depending of what comes after the '!' character,
        // process the entire "scope" and/or the command in "line".
        createCommandsBuilder(line).usedCommand(line, scope);

        return new StringBuilder();
    }

    public Command createCommandsBuilder(String line) {

        Map<String, Command> commands = new HashMap<>();
        commands.put(EXECUTE, new ExecuteScope());
        commands.put(CUSTOMCOMMAND, new RunCustomCommand());
        commands.put(DIRECTIVE, new ProcessDirective());

        return commands.get(line);
    }


}
