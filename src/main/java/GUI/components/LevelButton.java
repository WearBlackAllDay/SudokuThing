package GUI.components;

import GUI.SudokuThing;
import GUI.util.Icons;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LevelButton extends JButton {
    public LevelButton() {
        this.addButton();
    }

    private void addButton() {
        this.setPreferredSize(new Dimension(64, 64));
        this.setFocusable(false);
        this.addMouseListener(mouseListener);
    }
    private final MouseAdapter mouseListener = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            solve();
            SudokuThing.INSTANCE.updateBoxes();
            if((getState() && SwingUtilities.isRightMouseButton(e)) || (!getState() && SwingUtilities.isLeftMouseButton(e))) {
                mistake();
            }
        }
    };
    private boolean buttonState;

    public void setState(boolean state) {
        buttonState = state;
    }

    public boolean getState() {
        return buttonState;
    }

    public void ruleOut() {
        this.setEnabled(false);
        this.setIcon(new ImageIcon(Icons.CROSS));
        this.setDisabledIcon(new ImageIcon(Icons.CROSS));
    }

    public void confirm() {
        this.setEnabled(false);
        this.setIcon(new ImageIcon(Icons.FILLED));
        this.setDisabledIcon(new ImageIcon(Icons.FILLED));
    }

    public void solve() {
        if(getState()) {
            confirm();
        }
        else {
            ruleOut();
        }
        this.removeMouseListener(mouseListener);
    }

    private void mistake() {
        SudokuThing.INSTANCE.looseHP();
    }

    public void reset() {
        this.setEnabled(true);
        this.setSelected(false);
        this.setIcon(null);
        this.setDisabledIcon(null);
        this.addMouseListener(mouseListener);
    }
}

