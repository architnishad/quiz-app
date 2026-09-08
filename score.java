package quiz.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Score extends JFrame {

    public Score(String name, int score) {

        // Frame setup
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        // 1. "Your Score is" Label
        JLabel yourScoreLabel = new JLabel("Your Score is", SwingConstants.CENTER);
        yourScoreLabel.setBounds(460, 335, 260, 30);
        yourScoreLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
        yourScoreLabel.setForeground(new Color(10, 25, 68));
        add(yourScoreLabel);

        // 2. Score Number (Large Blue Digits)
        JLabel scoreValue = new JLabel(String.valueOf(score), SwingConstants.CENTER);
        scoreValue.setBounds(460, 375, 260, 90);
        scoreValue.setFont(new Font("Segoe UI", Font.BOLD, 72));
        scoreValue.setForeground(new Color(0, 102, 255));
        add(scoreValue);

        // 3. Green EXIT Button (Centered below the white card)
        JButton exit = new JButton("EXIT");
        exit.setBounds(412, 595, 175, 50);
        exit.setBackground(new Color(16, 137, 72));
        exit.setForeground(Color.WHITE);
        exit.setFont(new Font("Segoe UI", Font.BOLD, 18));
        exit.setFocusPainted(false);
        exit.setBorderPainted(false);
        exit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(exit);

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Login();
            }
        });

        // 4. Background Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/score.png"));
        Image i2 = i1.getImage().getScaledInstance(1000, 750, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel background = new JLabel(i3);
        background.setBounds(0, 0, 1000, 750);
        add(background);

        // Window Settings
        setSize(1000, 750);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Score("User", 0);
    }
}