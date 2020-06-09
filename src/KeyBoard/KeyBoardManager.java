package KeyBoard;

import Painting.StackController;
import Shapes.ShapeFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoardManager implements KeyEventDispatcher {

    ShortCut[] shortCuts;

    private StackAdapter sc;
    private ShapeAdapter sa;

    private static final int CTRL = KeyEvent.CTRL_DOWN_MASK;
    private static final int SHIFT = KeyEvent.SHIFT_DOWN_MASK;
    private static final int NONE = 0;

    public KeyBoardManager(StackController sc){
        this.sc = new StackAdapter(sc);
        this.sa = new ShapeAdapter();
        initiateShortCuts();
    }

    private void initiateShortCuts(){
        shortCuts = new ShortCut[]{
                new ShortCut(KeyEvent.VK_Z, CTRL, sc::undo),
                new ShortCut(KeyEvent.VK_Z, CTRL + SHIFT , sc::redo),
                new ShortCut(KeyEvent.VK_R, CTRL, sc::clear),
                new ShortCut(KeyEvent.VK_1, NONE, sa::changeRectangle),
                new ShortCut(KeyEvent.VK_2, NONE, sa::changeRoundedRectangle),
                new ShortCut(KeyEvent.VK_3, NONE, sa::changeOval),
                new ShortCut(KeyEvent.VK_4, NONE, sa::changeCircle),
                new ShortCut(KeyEvent.VK_5, NONE, sa::changeLine),
                new ShortCut(KeyEvent.VK_6, NONE, sa::changeFreeDraw),
                new ShortCut(KeyEvent.VK_F, NONE, sa::changeFill),
                new ShortCut(KeyEvent.VK_CLOSE_BRACKET, NONE, sa::increaseLineThickness),
                new ShortCut(KeyEvent.VK_OPEN_BRACKET, NONE, sa::decreaseLineThickness)
        };
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {
        if(e.getID()== KeyEvent.KEY_PRESSED){
            for(ShortCut s: shortCuts) {
                if (e.getKeyCode() == s.key && e.getModifiersEx() == s.modifier) {
                    s.run(null);
                    return true;
                }
            }
        }
        return false;
    }
}