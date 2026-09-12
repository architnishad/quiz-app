package quiz.app;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class quiz extends JFrame implements ActionListener
{
    String[][] questions= new String[10][5];
    String[][] answers = new String[10][2];
    String[][] useranswers = new String[10][1];
    JLabel qno, question, timeLabel;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoptions;

    JButton next, submit, lifeline;

    int timer = 15;
    int count = 0;
    int score = 0;

    javax.swing.Timer countdownTimer;

    String name;

    quiz(String name) {
        this.name = name;
        setBounds(50, 0, 1440, 850);
        getContentPane().setBackground(Color.WHITE);
        setUndecorated(true);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(getClass().getResource("quiz.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1440, 392);
        add(image);

        qno = new JLabel();
        qno.setBounds(100, 450, 50, 30);
        qno.setFont(new Font("SansSerif", Font.PLAIN, 24));
        add(qno);

        question = new JLabel();
        question.setBounds(150, 450, 900, 30);
        question.setFont(new Font("SansSerif", Font.PLAIN, 24));
        add(question);

        timeLabel = new JLabel();
        timeLabel.setBounds(1100, 480, 300, 30);
        timeLabel.setFont(new Font("SansSerif", Font.BOLD, 25));
        timeLabel.setForeground(Color.RED);
        add(timeLabel);

        // ---- HTML basics ----
        questions[0][0] = "Which tag is used to create a hyperlink in HTML?";
        questions[0][1] = "<link>";
        questions[0][2] = "<a>";
        questions[0][3] = "<href>";
        questions[0][4] = "<hlink>";

        questions[1][0] = "Which HTML tag is used to define an internal style sheet?";
        questions[1][1] = "<css>";
        questions[1][2] = "<script>";
        questions[1][3] = "<style>";
        questions[1][4] = "<styles>";

        questions[2][0] = "What is the correct HTML element for the largest heading?";
        questions[2][1] = "<h6>";
        questions[2][2] = "<heading>";
        questions[2][3] = "<head>";
        questions[2][4] = "<h1>";

        questions[3][0] = "Which attribute is used to provide an alternate text for an image?";
        questions[3][1] = "title";
        questions[3][2] = "alt";
        questions[3][3] = "src";
        questions[3][4] = "longdesc";

        questions[4][0] = "Which HTML tag is used to insert a line break?";
        questions[4][1] = "<break>";
        questions[4][2] = "<lb>";
        questions[4][3] = "<br>";
        questions[4][4] = "<newline>";

        // ---- Java basics ----
        questions[5][0] = "Number of primitive data types in Java are.?";
        questions[5][1] = "6";
        questions[5][2] = "7";
        questions[5][3] = "8";
        questions[5][4] = "9";

        questions[6][0] = "What is the size of float and double in java.?";
        questions[6][1] = "32 and 64";
        questions[6][2] = "32 and 32";
        questions[6][3] = "64 and 64";
        questions[6][4] = "64 and 32";

        questions[7][0] = "When an array is passed to a method, what does the method receive?";
        questions[7][1] = "The reference of the array";
        questions[7][2] = "A copy of the array";
        questions[7][3] = "Length of the array";
        questions[7][4] = "Copy of first element";

        questions[8][0] = "Arrays in java are.?";
        questions[8][1] = "Object References";
        questions[8][2] = "Objects";
        questions[8][3] = "Primitive data type";
        questions[8][4] = "None";

        questions[9][0] = "To which of the following does the class String belong to.";
        questions[9][1] = "java.lang";
        questions[9][2] = "java.awt";
        questions[9][3] = "java.applet";
        questions[9][4] = "java.String";

        answers[0][1] = "<a>";
        answers[1][1] = "<style>";
        answers[2][1] = "<h1>";
        answers[3][1] = "alt";
        answers[4][1] = "<br>";
        answers[5][1] = "8";
        answers[6][1] = "32 and 64";
        answers[7][1] = "The reference of the array";
        answers[8][1] = "Objects";
        answers[9][1] = "java.lang";

        opt1 = new JRadioButton();
        opt1.setBounds(170, 520, 700, 30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("SansSerif", Font.PLAIN, 20));
        add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(170, 560, 700, 30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("SansSerif", Font.PLAIN, 20));
        add(opt2);

        opt3 = new JRadioButton();
        opt3.setBounds(170, 600, 700, 30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("SansSerif", Font.PLAIN, 20));
        add(opt3);

        opt4 = new JRadioButton();
        opt4.setBounds(170, 640, 700, 30);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("SansSerif", Font.PLAIN, 20));
        add(opt4);

        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);

        next = new JButton("Next");
        next.setBounds(700, 750, 200, 30);
        next.setFont(new Font("SansSerif", Font.PLAIN, 18));
        next.setBackground(new Color(22, 99, 54));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        lifeline = new JButton("Help");
        lifeline.setBounds(930, 750, 200, 30);
        lifeline.setFont(new Font("SansSerif", Font.PLAIN, 18));
        lifeline.setBackground(new Color(22, 99, 54));
        lifeline.setForeground(Color.WHITE);
        lifeline.addActionListener(this);
        add(lifeline);

        submit = new JButton("Submit");
        submit.setBounds(1150, 750, 200, 30);
        submit.setForeground(Color.BLACK);
        submit.setFont(new Font("SansSerif", Font.PLAIN, 18));
        submit.setBackground(new Color(255, 215, 0));
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);

        // Countdown handled by a Swing Timer instead of blocking paint()/EDT
        countdownTimer = new javax.swing.Timer(1000, e -> {
            timer--;
            if (timer >= 0)
            {
                timeLabel.setText("Time left - " + timer + " seconds");
            }
            else
            {
                timeLabel.setText("Time's up!!");
                countdownTimer.stop();
                advance(true); // timed out, auto-advance
            }
        });

        start(count);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            advance(false);
        } else if (ae.getSource() == lifeline) {
            if (count == 2 || count == 4 || count == 6 || count == 8 || count == 9) {
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            } else {
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }
            lifeline.setEnabled(false);
        }
        else if (ae.getSource() == submit) {
            recordAnswer();
            finishQuiz();
        }
    }

    private void advance(boolean timedOut) {
        recordAnswer();

        opt1.setEnabled(true);
        opt2.setEnabled(true);
        opt3.setEnabled(true);
        opt4.setEnabled(true);
        lifeline.setEnabled(true);

        if (count == 9) {
            finishQuiz();
            return;
        }

        if (count == 8) {
            next.setEnabled(false);
            submit.setEnabled(true);
        }

        count++;
        start(count);
    }

    private void recordAnswer() {
        if (groupoptions.getSelection() == null) {
            useranswers[count][0] = "";
        } else {
            useranswers[count][0] = groupoptions.getSelection().getActionCommand();
        }
    }

    private void finishQuiz() {
        countdownTimer.stop();
        score = 0;
        for (int i = 0; i < useranswers.length; i++) {
            if (useranswers[i][0] != null && useranswers[i][0].equals(answers[i][1])) {
                score += 10;
            }
        }
        setVisible(false);
        new score(name, score);
    }

    public void start(int count) {
        qno.setText("" + (count + 1) + ". ");
        question.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);

        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);

        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);

        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);

        groupoptions.clearSelection();

        timer = 15;
        timeLabel.setText("Time left - " + timer + " seconds");
        countdownTimer.restart();
    }

    public static void main(String[] args) {
        new quiz("User");
    }
}