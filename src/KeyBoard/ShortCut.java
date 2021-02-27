package KeyBoard;

import java.util.function.Function;

/**
 * wrap a single shortcut - the keys that will activate it and the function that will be called
 * @author Itay Finci
 */
public class ShortCut {
    protected int key;
    protected int modifier;
    protected Function<Object,Object> function;

    /**
     * create a new shortcut
     * @param key the key that will activate the shortcut
     * @param modifier the modifies that required for this shortcut
     * @param function the function that will be called when the shortcut is requested
     */
    public ShortCut(int key, int modifier, Function<Object,Object> function) {
        this.key = key;
        this.modifier = modifier;
        this.function = function;
    }

    /**
     * run the function on action requested
     * @param o the object that is passed with the action
     */
    public void run(Object o){
        function.apply(o);
    }
}
