package com.refactoring;

public class AddLineAsAVariable implements AddTheLine {
    @Override
    public  StringBuilder addTheLine (StringBuilder scope, String line){
        // Process the entire "line" as a variable,
        // i.e. add it to a collection of KeyValuePair.
        return scope;
    }
}
