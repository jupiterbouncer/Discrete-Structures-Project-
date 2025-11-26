import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;

public class TutorApp extends JFrame{
    private ArrayList<Topic> topics;
    private FeedbackEngine feedbackEngine;
    private HintSystem hintSystem;
    private User currentUser;

    private JTextField userNameField, currentLevelField;
    private JTextArea outputArea;
    private JButton startButton;
    private JButton hintButton;
    private JButton CICButton, expressingConditionalsButton, definitionsButton, truthTableButton, logicalExpressionsButton;

    public TutorApp(){
        setTitle("Tutor App");
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(new JLabel("Username: "));
        userNameField = new JTextField(15);
        add(userNameField);

        add(new JLabel("Current level: "));
        currentLevelField = new JTextField(2);
        add(currentLevelField);

        // Initializing the START button
        startButton = new JButton("START");
        System.out.println("Start button clicked!");
        add(startButton);

        // Adding the logic buttons
        CICButton = new JButton("Converse, Inverse and Contrapositive");
        add(CICButton);

        expressingConditionalsButton = new JButton("Expressing Conditionals");
        add(expressingConditionalsButton);

        definitionsButton = new JButton("Definitions");
        add(definitionsButton);

        truthTableButton = new JButton("Truth Table");
        add(truthTableButton);

        logicalExpressionsButton = new JButton("Logical Expressions");
        add(logicalExpressionsButton);

        // Output area
        outputArea = new JTextArea(25,30);
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea));

        // Integrating the feedback engine and the hint system
        feedbackEngine = new FeedbackEngine();
        hintSystem = new HintSystem();

        // Action Listeners
        startButton.addActionListener(e -> {
            User user = new User(userNameField.getText());
            if (!(user.getName() == null || user.getName().isBlank())) outputArea.append("Welcome " + user.getName() + "! Starting at level " + user.getLevel() + "\n");
            else outputArea.append("Input something in your username and level! \n");
        });

        CICButton.addActionListener(e -> {
            cicTopic = new CIC("Converse, Inverse and Contrapositives", "Dealing with converse, inverse and conditionals of a conditional statement");
            outputArea.append("\n " + cicTopic.title + " \n" + cicTopic.description + " \n");
            
            cicTopic.addContent("Let's talk converses of conditional statements");
            cicTopic.addContent("Inverses of conditional statements");
            cicTopic.addContent("Contrapositives of conditional statements");
            
            cicTopic.displayContent();

            Exercise ex1 = new Exercise("CIC_Q1", "What is the converse of 'If Jamal comes to class, then there is a quiz'?", "C", 1, feedbackEngine, hintSystem);
            ex1.addOption("A. If there is no quiz, then Jamal doesn't come to class");
            ex1.addOption("B. If Jamal doesn't come to class, then there is no quiz");
            ex1.addOption("C. If there is a quiz, then Jamal comes to class");

            cicTopic.addExercise(ex1);
            cicTopic.startExercises();
        });

        definitionsButton.addActionListener(e -> {
            Definitions def = new Definitions("Definitions", "Basic logcial definitions");
            def.addContent("A proposition must be a declarative statement");
            def.addContent("Logical connectives include AND, OR, NOT and IF-THEN");

            def.displayContent();

            Exercise ex1 = new Exercise("DEF_Q1", "Which of the following is a proposition", "A", 1, feedbackEngine, hintSystem);
            ex1.addOption("A. The sky is blue");
            ex1.addOption("B. Close the door!");
            ex1.addOption("C. Is it raining?");
            ex1.addOption("D. Look at me");

            def.addExercise(ex1);
            def.startExercises();
        });

        expressingConditionalsButton.addActionListener(e -> {
            
        });

        truthTableButton.addActionListener(e -> {
            
        });

        logicalExpressionsButton.addActionListener(e -> {
            
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new TutorApp();
    }
}
