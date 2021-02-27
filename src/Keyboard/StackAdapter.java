package Keyboard;

import Painting.StackController;

/**
 * adapter to access the stack controller using :: expressions
 * @author Itay Finci
 */
public class StackAdapter {
    private StackController sc;

    /**
     * create new stack adapter that controls a stck controller
     * @param sc a stack controller
     */
    public StackAdapter(StackController sc) {
        this.sc = sc;
    }

    /**
     * undo last action
     * @param parm null
     * @return null
     */
    public Object undo(Object parm){
        sc.undo();
        return null;
    }

    /**
     * redo last action
     * @param parm null
     * @return null
     */
    public Object redo(Object parm){
        sc.redo();
        return null;
    }

    /**
     * clear last action
     * @param parm null
     * @return null
     */
    public Object clear(Object parm){
        sc.clear();
        return null;
    }
}
