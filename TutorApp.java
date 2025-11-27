import javax.swing.*;
import java.awt.*;

public class TutorApp extends JFrame{
    private FeedbackEngine feedbackEngine;
    private HintSystem hintSystem;
    private User currentUser;

    private JTextField userNameField;
    private JTextArea outputArea;
    private JButton startButton;
    private JButton hintButton;
    private JButton CICButton, expressingConditionalsButton, definitionsButton, truthTableButton, logicalExpressionsButton, logicalConnectivesButton;

    private OutputHandler outputHandler = text -> outputArea.append(text + "\n");

    public TutorApp(){
        setTitle("Tutor App");
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(new JLabel("Username: "));
        userNameField = new JTextField(15);
        add(userNameField);

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
            
            outputArea.append("\n");

            cicTopic.addContent("Let's talk about the converse, inverse and contrapositive of conditional statements" +
            "\n We will be considering the different ways of converting the conditional statement (p → q), where p is the premise and q is the antecedent \n" +
            "\n Most examples at this level will be of the form If p, then q" +
            "\n The CONVERSE of p → q is q → p i.e If q, then p" +
            "\n The INVERSE of p → q is ¬p → ¬q i.e If ¬p, then ¬q" +
            "\n The CONTRAPOSITIVE of p → q is ¬q → ¬p i.e If ¬q, then ¬p");

            outputArea.append("Press start when you're ready to begin the exercise");
            startButton.addActionListener(m -> {

            cicTopic.displayContent();
            outputArea.append("\n");

            outputHandler.print("Starting exercises for: " + cicTopic.getTitle());

            Exercise ex1 = new Exercise("CIC_Q1", "What is the converse of 'If Jamal comes to class, then there is a quiz'?", "C", 1, feedbackEngine, hintSystem, outputHandler);
            ex1.addOption("A. If there is no quiz, then Jamal doesn't come to class");
            ex1.addOption("B. If Jamal doesn't come to class, then there is no quiz");
            ex1.addOption("C. If there is a quiz, then Jamal comes to class");

            cicTopic.addExercise(ex1);

            outputArea.append("\n");
            
            Exercise ex2 = new Exercise("CIC_Q2", "What is the inverse of 'If Jamal comes to class, then there is a quiz'?", "A", 1, feedbackEngine, hintSystem, outputHandler);
            ex2.addOption("A. If Jamal doesn't come to class, then there is no quiz");
            ex2.addOption("B. If there is no quiz, then Jamal doesn't come to class");
            ex2.addOption("C. If there is a quiz, then Jamal comes to class");

            cicTopic.addExercise(ex2);

            outputArea.append("\n");

            Exercise ex3 = new Exercise("CIC_Q3", "What is the contrapositive of 'If Jamal comes to class, then there is a quiz'?", "B", 1, feedbackEngine, hintSystem, outputHandler);
            ex3.addOption("A. If Jamal doesn't come to class, then there is no quiz");
            ex3.addOption("B. If there is no quiz, then Jamal doesn't come to class");
            ex3.addOption("C. If there is a quiz, then Jamal comes to class");

            cicTopic.addExercise(ex3);
            cicTopic.startExercises();
            });

        });

        definitionsButton.addActionListener(g -> {
            Definitions def = new Definitions("Definitions", "Basic logical definitions", outputHandler);
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

        truthTableButton.addActionListener(i -> {
            TruthTables tt = new TruthTables("Truth Tables", "Construct truth tables for the basic logical connectives",outputHandler, feedbackEngine,hintSystem);

            tt.addContent("A truth table lists all the possible truth values of statements");
            tt.addContent("The truth value of the compound statement depends on its components.");
            tt.addContent("Each of the main connectives has its own truth table");

            tt.showNot();
            tt.showAnd();
            tt.showOr();
            tt.showImplication();
            tt.showBiconditional();

            tt.displayContent();

            //exercises

            Exercise ex1 = new Exercise(
                    "TT1",
                    "In the truth table for AND, when is P^Q true?",
                    "A",
                    1,
                    feedbackEngine,
                    hintSystem,
                    outputHandler
            );
            ex1.addOption("A. Only when P and Q are both true");
            ex1.addOption("B. When at least one is true");
            ex1.addOption("C. When both are false");
            ex1.addOption("D. When P is false");
            tt.addExercise(ex1);

            Exercise ex2 = new Exercise(
                    "TT2",
                    "In the implication (P → Q), which row is false?",
                    "C",
                    1,
                    feedbackEngine,
                    hintSystem,
                    outputHandler
            );
            ex2.addOption("A. T, T");
            ex2.addOption("B. F, T");
            ex2.addOption("C. T, F");
            ex2.addOption("D. F, F");
            tt.addExercise(ex2);

            Exercise ex3 = new Exercise(
                    "TT3",
                    "In the biconditional (↔), when is the statement true?",
                    "D",
                    1,
                    feedbackEngine,
                    hintSystem,
                    outputHandler
            );
            ex3.addOption("A. Always true");
            ex3.addOption("B. When P is true");
            ex3.addOption("C. When Q is false");
            ex3.addOption("D. When P and Q have the same truth value");
            tt.addExercise(ex3);

            tt.startExercises();
            
        });


        logicalConnectivesButton.addActionListener(k -> {
            LogicalConnectives lc = new LogicalConnectives (
                    "Logical Connectives",
                    "Learn NOT, OR, AND, IMPLICATION, BICONDITIONALS",
                    outputHandler
            );
            lc.addContent("Logical Connectives allow us to combine simple propositions into compound ones");
            lc.addContent("Common connectives include NOT, AND, OR, Implication and Biconditional");

            Connectives not = new Connectives("Negation", "¬", "A negation reverses the truth value of a proposition");
            not.addExample("¬p");
            lc.addConnective(not);

            Connectives and = new Connectives ("Conjunction","∧", "True only if both propositions are true" );
            and.addExample("p ∧ q");
            lc.addConnective(and);

            Connectives or = new Connectives("Disjunction", "∨", "Disjunctions are true if at least one of the propositions are true");
            or.addExample("p ∨ q");
            lc.addConnective(or);

            Connectives implies = new Connectives("Implication", "→", "Also known as conditional");
            implies.addExample("p→q");
            lc.addConnective(implies);

            Connectives iff = new Connectives ("Biconditional",  "p ↔ q", "If and only if" );
            iff.addExample(" p ↔ q ");
            lc.addConnective(iff);

            lc.displayContent();

            //Exercises
            Exercise ex1 = new Exercise (
                    "LC_Q1",
                    "Which connective returns the opposite truth value of a proposition p",
                    "C",
                    1,
                    feedbackEngine,
                    hintSystem,
                    outputHandler
                    );

            ex1.addOption("A: ∨ ");
            ex1.addOption("B: ∧ ");
            ex1.addOption("C : ¬");
            ex1.addOption("D : ↔");

            Exercise ex2 = new Exercise (
                    "LC_Q2",
                    "The disjunction of, p: I will buy a salad, q: i will buy meat pie is : ",
                    "A",
                    1,
                    feedbackEngine,
                    hintSystem,
                    outputHandler
            );
            ex2.addOption("A : I will buy a salad or meat pie");
            ex2.addOption("B: I will buy a salad and meat pie");
            ex2.addOption("C: If i buy a salad, I will buy meat pie");

            lc.addExercise(ex1);
            lc.addExercise(ex2);
            lc.startExercises();
        });

        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new TutorApp().getContentPane().setBackground(Color.GRAY);;
    }
}


