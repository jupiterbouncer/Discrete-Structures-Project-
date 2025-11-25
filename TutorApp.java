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
            String user = userNameField.getText();
            String level = currentLevelField.getText();
            if (!(user == null || user.isBlank())) outputArea.append("Welcome " + user + "! Starting at level " + level + "\n");
            else outputArea.append("Input something in your username and level! \n");
        });

        CICButton.addActionListener(e -> {
            cicTopic = new CIC("Converse, Inverse and Contrapositives", "Dealing with converse, inverse and conditionals of a conditional statement");
            outputArea.append("\n " + cicTopic.title + " \n" + cicTopic.description + " \n");
            
            cicTopic.addContent("Let's talk converses of conditional statements");
            cicTopic.addContent("Inverses of conditional statements");
            cicTopic.addContent("Contrapositives of conditional statements");
            
            cicTopic.displayContent();
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

        negationButton.addActionListener(e -> {
            outputArea.append("Negation rule");
        });

        implicationButton.addActionListener(e -> {
            outputArea.append("Implication rule");
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new TutorApp();
    }
}

class LogicalConnectives {
    // logical connectives
}

class TruthTables {
    // truth tables

}


class CIC {
    // Topic covering the converse, inverse, and contrapositive of a conditional

    // Basic details
    private String title;
    private String description;
    private ArrayList<String> content;

    // Activities and assessment
    private ArrayList<Exercise> exercises;
    private int totalPoints;
    private int score;

    // Feedback/tracking
    private boolean completed;
    private int hintCount;

    // Constructor
    public CIC(String title, String description){
        this.title = title;
        this.description = description;
        this.content = new ArrayList<>();
        this.exercises = new ArrayList<>();
        this.totalPoints = 0;
        this.score = 0;
        this.completed = false;
        this.hintCount = 0;
    }

    public int getPoints(){
        return this.totalPoints;
    }

    // Add lesson material
    public void addContent(String text){
        this.content.add(text);
    }

    // Display lesson material
    public void displayContent(){
        int count = 1;
        System.out.println("===" + title + "===");
        for (String section : content){
            System.out.println(count + "." + section);
            System.out.println();
            count++;
        }
    }

    // Run exercises
    public void startExercises(){
        System.out.println("Starting exercises for: " + title);
        for (Exercise exercise : exercises){
            exercise.displayQuestion();

            boolean correct = exercise.checkAnswer();

            if (correct) {
                score += exercise.getPoints();
            } else {
                System.out.println("Incorrect. Hint: " + exercise.getHint());
            }
        }
        completed = true;
        System.out.println("You scored " + score + "/" + totalPoints);
    }

    // Progress calculation
    public double getCompletionRate(){
        if (exercises.isEmpty()) return 0;

        int completedCount = 0;
        for (Exercise ex : exercises){
            if (ex.isAnswered()) completedCount++;
        }
        return (double) completedCount / exercises.size();
    }

    // Add an exercise to this topic
    public void addExercise(Exercise ex){
        exercises.add(ex);
        totalPoints += ex.getPoints();
    }
}


class Exercise {
    // Unique identifier for each question
    private String exerciseID;

    // Content
    private String question;
    private ArrayList<String> options;
    private String correctAnswer;

    // Tracking
    private boolean answered;
    private String userAnswer;
    private int points;

    // System integration
    private FeedbackEngine feedbackEngine;
    private HintSystem hintSystem;

    // Constructor
    public Exercise(String exerciseID, String question, String correctAnswer, int points,
        FeedbackEngine feedbackEngine, HintSystem hintSystem){
        this.exerciseID = exerciseID;
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.points = points;
        this.options = new ArrayList<>();
        this.feedbackEngine = feedbackEngine;
        this.hintSystem = hintSystem;
        this.answered = false;
    }

    // Multiple choice questions
    public void addOption(String option){
        options.add(option);
    }

    // Useful in the hashmap for retrieving the hint/feedback for an exercise
    public String getExerciseID(){
        return exerciseID;
    }

    // MCQ format
    public void displayQuestion(){
       System.out.println("Question: " + question); 
       if (!options.isEmpty()){
        int index = 1;
        for (String option: options){
            System.out.println(index + ")" + option);
            index++;
        }
    }
}

    // Collecting a user's answer
    public boolean checkAnswer(){
        System.out.print("Your answer: ");
        Scanner input = new Scanner(System.in);
        userAnswer = input.next();
        input.close();

        answered = true;

        if (userAnswer.equalsIgnoreCase(correctAnswer)){
            System.out.println("Correct");
            return true;
        }

        // Refers to the hasmap containing the exercise ID and the user answer
        System.out.println(feedbackEngine.analyzeError(this, userAnswer));
        return false;
    }

    // Retrieving a hint
    public String getHint(){
        return hintSystem.getHint(exerciseID, 1);
    }

    // This is used in the FeedbackEngine to provide the appropriate suggestion to a user's error
    public String detectErrorType(String userAnswer){
        if (exerciseID.contains("CIC") && userAnswer.contains("¬p → ¬q")){
            return "inverse_contrapositive";
        }
        return "generic_error";
    }

    // Increases the completion rate if a section is answered
    public boolean isAnswered(){
        return answered;
    }

    // Cumulating the total points
    public int getPoints(){
        return points;
    }
}

class FeedbackEngine{
    // Private member field 
    private HashMap<String, String> errorFeedback;

    public FeedbackEngine(){
        errorFeedback = new HashMap<>();

        errorFeedback.put("inverse_contrapositive", "It looks like you mixed up the inverse and contrapositive"
        + "Remember: The contrapositive of 'p → q' is '¬q → ¬p', while the inverse is '¬p → ¬q'");

        errorFeedback.put("truth_table_error", "Recheck your truth table. Make sure you evalute NOT before AND/OR");

        errorFeedback.put("conditional_misinterpretation", "You may be misunderstanding implications");

        // add more errors
    }

    // Retrieves the exercise and the user's answer as arguments for error detection
    public String analyzeError(Exercise exercise, String userAnswer){
        String errorType = exercise.detectErrorType(userAnswer);

        if(errorFeedback.containsKey(errorType)) return errorFeedback.get(errorType);

        return "Incorrect. Review the rules for this topic and try again";
    }

    // Getter method for feedback
    public String getFeedback(String errorType){
        return errorFeedback.getOrDefault(errorType, "Wrong answer, look at your face");
    }
}

class HintSystem {

    private HashMap<String, String[]> hintBank;
    
    public HintSystem(){
        hintBank = new HashMap<>();

        hintBank.put("CIC_Q1", new String[]{
            "Hint 1: The inverse negates both p and q (p → q becomes ¬p → ¬q)",
            "Hint 2: The contrapositive negates AND switches the components (p → q becomes ¬q → ¬p).",
            "Hint 3: For 'if p then q', contrapositive = 'if not q then p'"
        });

        hintBank.put("TruthTable_Q1", new String[]{
            "Hint 1: Fill columns for AND and OR next",
            "Hint 2: Remember, AND is true only when both inputs are true",
            "Hint 3: Remember, OR is false only when both inputs are false"
        });

        // add a new key with their possible hints

    }

    public String getHint(String exerciseID, int level){
        if (!hintBank.containsKey(exerciseID)) return "No hints available for this exercise";

        String[] hints = hintBank.get(exerciseID);
        if (level < 1 || level > hints.length) return "No more hints available";

        return hints[level - 1];
    }

    public int hintCount(String exerciseID) {
        return hintBank.containsKey(exerciseID) ? hintBank.get(exerciseID).length : 0;
    }
}

class ScoreTracker{

}




