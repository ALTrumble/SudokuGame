package Sudoku;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class GameOverMenu extends JPanel {

    private ArrayList<EventListener> listeners = new ArrayList<>();

    JLabel titleLabel = new JLabel("Game Over Menu (temporary text)");
    JPanel buttonPanel = new JPanel();

    JButton mainButton = new JButton("Return to Main Menu");
    JButton exitButton = new JButton("Quit");

    JLabel mistakesLabel = new JLabel("Mistakes Made: 0/3");
    JLabel cellsSolved = new JLabel("Cells solved: 0/0");

    JLabel timeElapsedLabel = new JLabel("Time Elapsed: 00:00:00");

    GameOverMenu() {
        setVisible(false);
        setSize(727, 949);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // Use BoxLayout with Y_AXIS

        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setAlignmentX(CENTER_ALIGNMENT); // Center the text horizontally
        add(titleLabel);

        mainButton.setBackground(new Color(0x2dce98));
        mainButton.setForeground(Color.white);
        mainButton.setUI(new StyledButtonUI());

        mistakesLabel.setFont(new Font("Arial", Font.BOLD, 20));
        mistakesLabel.setAlignmentX(CENTER_ALIGNMENT);
        add(mistakesLabel);

        cellsSolved.setFont(new Font("Arial", Font.BOLD, 20));
        cellsSolved.setAlignmentX(CENTER_ALIGNMENT);
        add(cellsSolved);

        timeElapsedLabel.setFont(new Font("Arial", Font.BOLD, 20));
        timeElapsedLabel.setAlignmentX(CENTER_ALIGNMENT);
        add(timeElapsedLabel);

        mainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notifyListeners("MainMenu");
            }
        });

        exitButton.setBackground(new Color(0x2dce98));
        exitButton.setForeground(Color.white);
        exitButton.setUI(new StyledButtonUI());

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS)); // Use BoxLayout with X_AXIS
        buttonPanel.add(mainButton);
        buttonPanel.add(Box.createHorizontalStrut(10)); // Add some horizontal space
        buttonPanel.add(exitButton);
        buttonPanel.setAlignmentX(CENTER_ALIGNMENT); // Center the buttonPanel horizontally
        add(buttonPanel);
    }

    public void toggleWinLose(boolean win, int[] stats, String time) {
        int mistakes = stats[0];
        int solved = stats[1];
        int unsolved = stats[2];

        if (win) {
            titleLabel.setText("Congratulations!");
        } else {
            titleLabel.setText("Game Over!");
        }

        mistakesLabel.setText("Mistakes Made: " + mistakes + "/3");
        cellsSolved.setText("Cells Solved: " + solved + "/" + unsolved);
        timeElapsedLabel.setText("Time Elapsed: " + time);

        revalidate();
        repaint();
    }

    public void addEventListener(EventListener listener) {
        listeners.add(listener);
    }

    public void notifyListeners(String info) {
        for (EventListener listener : listeners) {
            listener.EventOccured(info);
        }
    }
}
