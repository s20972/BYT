package com.company;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Editor {
    private static Deque<TextArea.Memento> stateHistory;
    private TextArea textArea ;

    public Editor (){
        stateHistory = new LinkedList<>();
        textArea = new TextArea();
    }
    public void write(String text){
        textArea.set(text);
        stateHistory.add(textArea.takeSnapshot());
    }
    public void undo(){
        textArea.restore(stateHistory.pop());
    }
    public static void main(){
        Editor editor = new Editor();
        editor.write("Hello!!");
        System.out.print(stateHistory.toString());
        editor.write("Hello and Bye");
        editor.write("Keflkwfkwefkewkfl");

        editor.undo();

    }
}
