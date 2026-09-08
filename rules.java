package quiz.app;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rules extends JFrame implements ActionListener {

    JButton start;
    String name;

    Rules(String name) {
        this.name = name;

        int frameWidth = 900;
        int frameHeight = 650;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/back.png"));
        Image i = i1.getImage().getScaledInstance(frameWidth, frameHeight, Image.SCALE_SMOOTH);
        ImageIcon i2 = new ImageIcon(i);
        JLabel image = new JLabel(i2);
        image.setLayout(null);
        setContentPane(image);

        // Heading - centered horizontally across the whole frame
        JLabel heading = new JLabel("Welcome " + name + " to QUIZ TEST", SwingConstants.CENTER);
        heading.setBounds(0, 40, frameWidth, 40);
        heading.setFont(new Font("SansSerif", Font.BOLD, 28));
        heading.setForeground(Color.WHITE);
        image.add(heading);

        // Box that holds the rules
        int boxWidth = 620;
        int boxHeight = 420;
        int boxX = (frameWidth - boxWidth) / 2;
        int boxY = 110;

        JPanel rulesBox = new JPanel();
        rulesBox.setLayout(null);
        rulesBox.setBounds(boxX, boxY, boxWidth, boxHeight);
        rulesBox.setBackground(new Color(255, 255, 255, 230));
        rulesBox.setBorder(new LineBorder(new Color(22, 99, 54), 3, true));
        image.add(rulesBox);

        JLabel rules = new JLabel("<html>1. The quiz contains 10 multiple-choice questions.<br><br>"
                + "2. You have 15 seconds to answer each question.<br><br>"
                + "3. Each correct answer carries 10 marks.<br><br>"
                + "4. No negative marking for wrong answers.<br><br>"
                + "5. Click Next to move to the next question.<br><br>"
                + "6. Click Submit after completing the quiz.<br><br>"
                + "7. Your final score will be displayed at the end.</html>");
        rules.setBounds(20, 15, boxWidth - 40, boxHeight - 90);
        rules.setFont(new Font("SansSerif", Font.BOLD, 18));
        rules.setForeground(new Color(0, 0, 139));
        rulesBox.add(rules);

        // Start button - centered inside the box, near the bottom
        start = new JButton("Start");
        int btnWidth = 140;
        int btnHeight = 40;
        start.setBounds((boxWidth - btnWidth) / 2, boxHeight - btnHeight - 20, btnWidth, btnHeight);
        start.setFont(new Font("SansSerif", Font.BOLD, 16));
        start.setBackground(new Color(22, 99, 54));
        start.setForeground(Color.WHITE);
        start.setFocusPainted(false);
        start.addActionListener(this);
        rulesBox.add(start);

        setSize(frameWidth, frameHeight);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Quiz(name);
    }

    public static void main(String[] args) {
        new Rules("User");
    }
}