package quiz.app;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class Login extends JFrame implements ActionListener {

    JTextField text;
    JButton next, exit;

    public Login() {

        int frameWidth = 900;
        int frameHeight = 650;

        setLayout(null);

        // ================= ENTER YOUR NAME =================

        JLabel nameLabel = new JLabel("Enter Your Name", SwingConstants.CENTER);

        // Directly below QUIZ TEST
        nameLabel.setBounds(0, 300, frameWidth, 30);

        nameLabel.setFont(new Font("SansSerif", Font.BOLD, 20));

        nameLabel.setForeground(Color.WHITE);
        add(nameLabel);

        // ================= TEXT FIELD =================

        int fieldWidth = 280;
        int fieldHeight = 32;
        int fieldX = (frameWidth - fieldWidth) / 2;

        text = new JTextField();

        text.setBounds(fieldX, 335, fieldWidth, fieldHeight);

        text.setFont(new Font("SansSerif", Font.PLAIN, 18));
        text.setHorizontalAlignment(JTextField.CENTER);

        add(text);

        // ================= BUTTONS =================

        int buttonWidth = 110;
        int buttonHeight = 35;
        int gap = 25;

        int totalWidth = (buttonWidth * 2) + gap;

        int buttonStartX = (frameWidth - totalWidth) / 2;

        // ================= NEXT =================

        next = new JButton("Next");

        next.setBounds(buttonStartX, 380, buttonWidth, buttonHeight);
        next.setBackground(new Color(22, 99, 54));

        next.setForeground(Color.WHITE);
        next.setFont(new Font("SansSerif", Font.BOLD, 14));

        next.setFocusPainted(false);
        next.addActionListener(this);
        add(next);

        // ================= EXIT =================

        exit = new JButton("Exit");
        exit.setBounds(buttonStartX + buttonWidth + gap, 380, buttonWidth, buttonHeight);
        exit.setBackground(new Color(22, 99, 54));
        exit.setForeground(Color.WHITE);
        exit.setFont(new Font("SansSerif", Font.BOLD, 14));

        exit.setFocusPainted(false);
        exit.addActionListener(this);
        add(exit);

        // ================= BACKGROUND IMAGE =================

        URL imgUrl = ClassLoader.getSystemResource("icons/login.png");

        if (imgUrl != null) {

            ImageIcon icon = new ImageIcon(imgUrl);

            Image image = icon.getImage().getScaledInstance(frameWidth, frameHeight, Image.SCALE_SMOOTH);

            ImageIcon backgroundIcon = new ImageIcon(image);

            JLabel background = new JLabel(backgroundIcon);
            background.setBounds(0, 0, frameWidth, frameHeight);
            add(background);
            // Put background behind login controls
            getContentPane().setComponentZOrder(background, getContentPane().getComponentCount() - 1);
        }
        else
        {
            getContentPane().setBackground(Color.WHITE);
            System.out.println("login.png not found!");
        }

        // ================= FRAME =================

        setSize(frameWidth, frameHeight);

        setLocationRelativeTo(null);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // ================= BUTTON ACTION =================

    @Override
    public void actionPerformed(ActionEvent e) {
        // NEXT
        if (e.getSource() == next) {
            String userName = text.getText().trim();
            if (userName.isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Please enter your name!",
                        "Login Required",
                        JOptionPane.WARNING_MESSAGE
                );
                text.requestFocus();
                return;
            }

            // Proceed to Rules screen
            dispose();
            new Rules(userName);
        }

        // EXIT
        else if (e.getSource() == exit) {
            System.exit(0);
        }
    }

    // ================= MAIN =================

    public static void main(String[] args) {

        new Login();
    }
}