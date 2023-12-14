package Sudoku;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class DifficultyMenu extends JPanel {

    private ArrayList<EventListener> listeners = new ArrayList<>();

    JLabel titleLabel = new JLabel("Select Difficulty");

    JButton easyButton = new JButton("Easy");
    JButton mediumButton = new JButton("Medium");
    JButton hardButton = new JButton("Hard");
    JButton backButton = new JButton("Back");

    JPanel buttonPanel = new JPanel();

    DifficultyMenu() {
        setVisible(false);
        setSize(727, 949);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // Use BoxLayout with Y_AXIS

        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center the text horizontally
        add(titleLabel);

        easyButton.setFont(new Font("Calibri", Font.PLAIN, 14));
        easyButton.setBackground(new Color(0x2dce98));
        easyButton.setForeground(Color.white);
        easyButton.setUI(new StyledButtonUI());

        mediumButton.setFont(new Font("Calibri", Font.PLAIN, 14));
        mediumButton.setBackground(new Color(0x2dce98));
        mediumButton.setForeground(Color.white);
        mediumButton.setUI(new StyledButtonUI());

        hardButton.setFont(new Font("Calibri", Font.PLAIN, 14));
        hardButton.setBackground(new Color(0x2dce98));
        hardButton.setForeground(Color.white);
        hardButton.setUI(new StyledButtonUI());

        backButton.setFont(new Font("Calibri", Font.PLAIN, 14));
        backButton.setBackground(new Color(0x2dce98));
        backButton.setForeground(Color.white);
        backButton.setUI(new StyledButtonUI());

        easyButton.addActionListener(e -> {
            notifyListeners("EasyGame");
        });

        mediumButton.addActionListener(e -> {
            notifyListeners("MediumGame");
        });

        hardButton.addActionListener(e -> {
            notifyListeners("HardGame");
        });

        backButton.addActionListener(e -> {
            notifyListeners("MainMenu");
        });

        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Use FlowLayout with CENTER alignment
        buttonPanel.add(easyButton);
        buttonPanel.add(mediumButton);
        buttonPanel.add(hardButton);
        buttonPanel.add(backButton);

        add(buttonPanel);
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

