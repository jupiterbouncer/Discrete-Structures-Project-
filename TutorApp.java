import javax.swing.*;
import java.awt.*;

public class TutorApp extends JFrame{
    public static TutorApp CURRENT_INSTANCE;
    private FeedbackEngine feedbackEngine;
    private HintSystem hintSystem;
    private User currentUser;

    private Exercise currentExercise = null;
    private Topic selectedTopic = null;

    private JTextField userNameField;

    private JTextArea outputArea;

    private JButton startButton;
    private JButton hintButton;
    private JButton CICButton, expressingConditionalsButton, definitionsButton, truthTableButton, logicalExpressionsButton, logicalConnectivesButton;

    private OutputHandler outputHandler;

    public void setCurrentExercise(Exercise exercise){
        this.currentExercise = exercise;
    }

    public TutorApp(){
        CURRENT_INSTANCE = this;

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

        // Initializing the hint button
        hintButton = new JButton("HINT");
        add(hintButton);

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

        logicalConnectivesButton = new JButton("Logical Connectives");
        add(logicalConnectivesButton);

        // Output area
        outputArea = new JTextArea(35,55);
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea));
        outputHandler = text -> outputArea.append(text + "\n");

        // Integrating the feedback engine and the hint system
        feedbackEngine = new FeedbackEngine();
        hintSystem = new HintSystem();

        outputArea.append("Enter your name and click on start to proceed \n");

        // Action Listeners (Once the start button is clicked, the topics can be accessed)
        startButton.addActionListener(e -> {

            currentUser = new User(userNameField.getText());
            if (currentUser.getUserName().isBlank()) {
                outputArea.append("Input something in your username!\n");
                return;
            }

            outputArea.append("Welcome " + currentUser.getUserName() + " to your Tutor App! \n");
                
            if (selectedTopic == null) {
                    outputArea.append("Select a topic first! \n");
                    return;    
            }

            selectedTopic.startExercises();
            outputArea.append("Click any topic button to start \n");
        });
        

        hintButton.addActionListener(hb -> {
            if (currentExercise == null) {
                outputArea.append("No active question - select a topic first \n");
                return;
            }

            currentExercise.requestHint(hintSystem, outputHandler);
            String hint = currentExercise.getHint(hintSystem);
            outputArea.append("Hint: " + hint + "\n");
        });

                CICButton.addActionListener(f -> {

                    if (currentUser.getUserName().isBlank()) {
                        outputArea.append("Input your username first!\n");
                    return;
                }

                CIC cicTopic = new CIC("Converse, Inverse and Contrapositives", "Dealing with converse, inverse and conditionals of a conditional statement", outputHandler);

                outputArea.append("\n " + cicTopic.getTitle() + " \n" + cicTopic.getDescription() + " \n");
            
                outputArea.append("\n");

                cicTopic.addContent("Let's talk about the converse, inverse and contrapositive of conditional statements" +
                "\n We will be considering the different ways of converting the conditional statement (p → q), where p is the premise and q is the antecedent \n" +
                "\n Most examples at this level will be of the form If p, then q" +
                "\n The CONVERSE of p → q is q → p i.e If q, then p" +
                "\n The INVERSE of p → q is ¬p → ¬q i.e If ¬p, then ¬q" +
                "\n The CONTRAPOSITIVE of p → q is ¬q → ¬p i.e If ¬q, then ¬p");

                cicTopic.displayContent();

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

                selectedTopic = cicTopic;
                outputArea.append("\nLoaded: " + cicTopic.getTitle() + "\n");
                outputArea.append("Press start when you're ready to begin the exercise");
                });

            definitionsButton.addActionListener(g -> {

                if (currentUser.getUserName().isBlank()) {
                        outputArea.append("Input your username first!\n");
                    return;
                }

                Definitions def = new Definitions("Definitions", "Basic logical definitions", outputHandler);
                def.addContent("A proposition must be a declarative statement");
                def.addContent("Logical connectives include AND, OR, NOT and IF-THEN");

                def.displayContent();

                Exercise ex1 = new Exercise("DEF_Q1", "Which of the following is a proposition", "A", 1, feedbackEngine, hintSystem, outputHandler);
                ex1.addOption("A. The sky is blue");
                ex1.addOption("B. Close the door!");
                ex1.addOption("C. Is it raining?");

                def.addExercise(ex1);

                selectedTopic = def;
                outputArea.append("\nLoaded: " + def.getTitle() + "\n");
                outputArea.append("Press start when you're ready to begin the exercise\n");
            });

            truthTableButton.addActionListener(i -> {

                if (currentUser.getUserName().isBlank()) {
                        outputArea.append("Input your username first!\n");
                    return;
                }

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
                    "TT_Q1",
                    "In the truth table for AND, when is P ∧ Q true?",
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
                    "TT_Q2",
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
                    "TT_Q3",
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

                selectedTopic = tt;
                outputArea.append("\nLoaded: " + tt.getTitle() + "\n");
                outputArea.append("Press start when you're ready to begin the exercise");
            });
            

            logicalConnectivesButton.addActionListener(k -> {

                if (currentUser.getUserName().isBlank()) {
                        outputArea.append("Input your username first!\n");
                    return;
                }

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
                implies.addExample("p → q");
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
                
                selectedTopic = lc;
                outputArea.append("\nLoaded: " + lc.getTitle() + "\n");
                outputArea.append("Press start when you're ready to begin the exercise");
            });

            expressingConditionalsButton.addActionListener(ec -> {

                if (currentUser.getUserName().isBlank()) {
                        outputArea.append("Input your username first!\n");
                    return;
                }

                ExpressingConditionals ecTopic = new ExpressingConditionals("Expressing Conditionals", "Covering the different ways to express a conditional statement", outputHandler);

                ecTopic.addContent("The different ways of expressing p → q are: ");
                ecTopic.addContent("- If p, then q");
                ecTopic.addContent("- q whenever p");
                ecTopic.addContent("- p implies q");
                ecTopic.addContent("- p only if q");
                ecTopic.addContent("- q if p");
                ecTopic.addContent("- q unless ¬p");
                ecTopic.addContent("- q unless ¬p");
                ecTopic.addContent("- A necessary condition for p is q");
                ecTopic.addContent("- A sufficient condition for q is p");

                ecTopic.addContent("\n");

                ecTopic.addContent("You can express the biconditional p ↔ q with: ");
                ecTopic.addContent("- p if and only if q and conversely");
                ecTopic.addContent("- p iff q");

                ecTopic.addContent("\n Always remember to pick out the parts and slot them in the various forms accordingly! \n");
                
                ecTopic.displayContent();

                //exercises

                Exercise ex1 = new Exercise("EC_Q1", "Rewrite 'A shape is a square if it is a rectangle with four equal sides' in the 'if ..., then ...' form", "C", 1, feedbackEngine, hintSystem, outputHandler);
                ex1.addOption("A. If a shape is not a square, then it is not a rectangle");
                ex1.addOption("B. If a shape is a square, then it is a rectangle with four sides");
                ex1.addOption("C. If a rectangle has four equal sides, then it is a square");

                ecTopic.addExercise(ex1);

                Exercise ex2 = new Exercise("EC_Q2", "Rewrite 'You will pass the course unless you fail the final exam' in the 'if ..., then ...' form", "B", 1, feedbackEngine, hintSystem, outputHandler);
                ex2.addOption("A. If you fail the final exam, you will not pass the course");
                ex2.addOption("B. If you do not fail the final exam, then you will pass the course");
                ex2.addOption("C. If you pass the course, then you must have not failed the final exam");

                ecTopic.addExercise(ex2);

                selectedTopic = ecTopic;
                outputArea.append("\nLoaded: " + ecTopic.getTitle() + "\n");
                outputArea.append("Press start when you're ready to begin the exercise");

            });

        setVisible(true);
    }

    public static void main(String[] args) {
        new TutorApp().getContentPane().setBackground(Color.GRAY);;
    }
}

