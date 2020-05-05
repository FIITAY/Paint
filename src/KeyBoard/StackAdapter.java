package KeyBoard;

import Painting.StackController;

public class StackAdapter {
    private StackController sc;

    public StackAdapter(StackController sc) {
        this.sc = sc;
    }

    public Object undo(Object parm){
        sc.undo();
        return null;
    }

    public Object redo(Object parm){
        sc.redo();
        return null;
    }

    public Object clear(Object parm){
        sc.clear();
        return null;
    }
}
