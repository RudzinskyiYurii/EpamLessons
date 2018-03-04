package com.refactoring;

public class AddWholeLine implements AddTheLine{

    @Override
    public  StringBuilder addTheLine (StringBuilder scope, String line){
        // No processing directive, i.e. add the "line"
        // to the current scope.
        return scope.append(line);
    }
}
