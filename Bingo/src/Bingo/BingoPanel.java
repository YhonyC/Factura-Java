package Bingo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BingoPanel extends JPanel {

    private JButton[][] buttons;

    public BingoPanel() {
        buttons = new JButton[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                buttons[i][j] = new JButton();
                add(buttons[i][j]);

                final int row = i;
                final int col = j;

                buttons[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        buttons[row][col].setEnabled(false);

                        if (checkLine(row, col) || checkBingo()) {
                            System.out.println("¡Felicidades!");
                        }
                    }
                });
            }
        }
    }

    private boolean checkLine(int i, int j) {
        for (int k = 0; k < 5; k++) {
            if (!buttons[i][k].isEnabled()) {
                return false;
            }
        }

        for (int k = 0; k < 5; k++) {
            if (!buttons[k][j].isEnabled()) {
                return false;
            }
        }

        return true;
    }

    private boolean checkBingo() {
        for (int i = 0; i < 5; i++) {
            if (!buttons[i][i].isEnabled()) {
                return false;
            }
        }

        for (int i = 0; i < 5; i++) {
            if (!buttons[i][4 - i].isEnabled()) {
                return false;
            }
        }

        return true;
    }
}
