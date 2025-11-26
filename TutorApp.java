import javax.swing.*;
import java.awt.*;

public class TutorApp extends JFrame{
    private FeedbackEngine feedbackEngine;
    private HintSystem hintSystem;
    private User currentUser;

    private JTextField userNameField, currentLevelField;
    private JTextArea outputArea;
    private JButton startButton;
    private JButton hintButton;
    private JButton CICButton, expressingConditionalsButton, definitionsButton, truthTableButton, logicalExpressionsButton;

    private OutputHandler outputHandler = text -> outputArea.append(text + "\n");

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
        add(startButton);

        // Adding the buttons for topics
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
        outputArea = new JTextArea(25,55);
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea));

        // Integrating the feedback engine and the hint system
        feedbackEngine = new FeedbackEngine();
        hintSystem = new HintSystem();

        // Action Listeners (Once the start button is clicked, the topics can be accessed)
        startButton.addActionListener(e -> {
            currentUser = new User(userNameField.getText());
            if (!(currentUser.getUserName() == null || currentUser.getUserName().isBlank())) outputArea.append("Welcome " + currentUser.getUserName() + "! Starting at level " + currentUser.getCurrentLevel() + "\n");
            else outputArea.append("Input something in your username and level! \n");

            CICButton.addActionListener(f -> {
            CIC cicTopic = new CIC("Converse, Inverse and Contrapositives", "Dealing with converse, inverse and conditionals of a conditional statement", outputHandler);
            outputArea.append("\n " + cicTopic.getTitle() + " \n" + cicTopic.getDescription() + " \n");
            
            cicTopic.addContent("Let's talk converses of conditional statements");
            cicTopic.addContent("Inverses of conditional statements");
            cicTopic.addContent("Contrapositives of conditional statements");
            
            cicTopic.displayContent();
            outputArea.append("\n");

            Exercise ex1 = new Exercise("CIC_Q1", "What is the converse of 'If Jamal comes to class, then there is a quiz'?", "C", 1, feedbackEngine, hintSystem, outputHandler);
            ex1.addOption("A. If there is no quiz, then Jamal doesn't come to class");
            ex1.addOption("B. If Jamal doesn't come to class, then there is no quiz");
            ex1.addOption("C. If there is a quiz, then Jamal comes to class");

            Exercise ex2 = new Exercise("CIC_Q2", "What is the inverse of 'If Jamal comes to class, then there is a quiz'?", "A", 1, feedbackEngine, hintSystem, outputHandler);
            ex1.addOption("A. If Jamal doesn't come to class, then there is no quiz");
            ex1.addOption("B. If there is no quiz, then Jamal doesn't come to class");
            ex1.addOption("C. If there is a quiz, then Jamal comes to class");

            Exercise ex3 = new Exercise("CIC_Q3", "What is the contrapositive of 'If Jamal comes to class, then there is a quiz'?", "B", 1, feedbackEngine, hintSystem, outputHandler);
            ex1.addOption("A. If Jamal doesn't come to class, then there is no quiz");
            ex1.addOption("B. If there is no quiz, then Jamal doesn't come to class");
            ex1.addOption("C. If there is a quiz, then Jamal comes to class");

            cicTopic.addExercise(ex1);
            cicTopic.addExercise(ex2);
            cicTopic.addExercise(ex3);
            cicTopic.startExercises();
        });

        definitionsButton.addActionListener(g -> {
            Definitions def = new Definitions("Definitions", "Basic logcial definitions", outputHandler);
            def.addContent("A proposition must be a declarative statement");
            def.addContent("Logical connectives include AND, OR, NOT and IF-THEN");

            def.displayContent();
            outputArea.append("\n");

            Exercise ex1 = new Exercise("DEF_Q1", "Which of the following is a proposition", "A", 1, feedbackEngine, hintSystem, outputHandler);
            ex1.addOption("A. The sky is blue");
            ex1.addOption("B. Close the door!");
            ex1.addOption("C. Is it raining?");
            ex1.addOption("D. Look at me");

            def.addExercise(ex1);
            def.startExercises();
        });

        expressingConditionalsButton.addActionListener(h -> {
            
        });

        truthTableButton.addActionListener(i -> {
            
        });

        logicalExpressionsButton.addActionListener(j -> {
            
        });

        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new TutorApp();
    }
}
