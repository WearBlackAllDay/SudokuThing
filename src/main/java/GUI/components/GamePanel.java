package GUI.components;

import levels.Level;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class GamePanel extends JPanel {
    public GamePanel() {
        this(15);
    }
    public GamePanel(int gridSize){
        setGridSize(gridSize);
        addContent();
    }
    public GamePanel(Level level) {
        setGridSize(level.getSize());
        //TODO
    }

    private void addContent() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        for (int y = 0; y < gridSize; y++) {
            gbc.gridy = y;
            for (int x = 0; x < gridSize; x++) {
                gbc.gridx = x;
                this.add(new LevelButton(), gbc);
            }
        }
    }

    private int gridSize;

    public void setGridSize(int i) {
        gridSize = i;
    }

    public int getGridSize() {
        return gridSize;
    }

    public ArrayList<LevelButton> allButtons() {
        ArrayList<LevelButton> out = new ArrayList<>(gridSize * gridSize);
        for (Component lb : this.getComponents()) {
            if (lb instanceof LevelButton) {
                out.add((LevelButton) lb);
            }
        }
        return out;
    }
}
