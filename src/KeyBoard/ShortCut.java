package KeyBoard;

import java.util.function.Function;

public class ShortCut {
    protected int key;
    protected int modifier;
    protected Function<Object,Object> function;

    public ShortCut(int key, int modifier, Function<Object,Object> function) {
        this.key = key;
        this.modifier = modifier;
        this.function = function;
    }

    public void run(Object o){
        function.apply(o);
    }
}
