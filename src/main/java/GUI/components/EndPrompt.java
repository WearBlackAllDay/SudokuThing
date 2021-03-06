package GUI.components;

import GUI.SudokuThing;

import javax.swing.*;
import java.awt.*;

public class EndPrompt extends JDialog {
    public EndPrompt() {
        showPrompt();
    }

    public JLabel endText;
    private void showPrompt() {
        endText = new JLabel();
        JButton confirmButton = new JButton();

        endText.setHorizontalTextPosition(SwingConstants.CENTER);
        endText.setHorizontalAlignment(SwingConstants.CENTER);
        endText.setText("placeholder");

        confirmButton.setText("next Game");
        confirmButton.setPreferredSize(new Dimension(150,30));
        confirmButton.addActionListener(e -> {
            this.dispose();
            SudokuThing.INSTANCE.newRandomGame();
        });

        this.setLayout(new BorderLayout());
        this.add(endText,BorderLayout.NORTH);
        this.add(confirmButton,BorderLayout.CENTER);
        this.setTitle("Game Over");
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);
        this.setVisible(true);
        this.pack();
    }

    public void setEndtext(String text) {
        endText.setText(text);
    }
}
