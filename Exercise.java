import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Exercise {
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

    private OutputHandler outputHandler;

    // Constructor
    public Exercise(String exerciseID, String question, String correctAnswer, int points, FeedbackEngine feedbackEngine, HintSystem hintSystem, OutputHandler outputHandler){
        this.exerciseID = exerciseID;
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.points = points;
        this.options = new ArrayList<>();
        this.feedbackEngine = feedbackEngine;
        this.hintSystem = hintSystem;
        this.answered = false;
        this.outputHandler = outputHandler;
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
       outputHandler.print("Question: " + question); 
       if (!options.isEmpty()){
        for (String option: options){
            outputHandler.print(option);
        }
    }
}

    // Collecting a user's answer
    public boolean checkAnswer(){
        userAnswer = JOptionPane.showInputDialog(null, "Enter the letter corresponding to your answer: ");

        answered = true;

        if (userAnswer.equalsIgnoreCase(correctAnswer)){
            outputHandler.print("Correct");
            return true;
        }

        outputHandler.print("Wrong answer");
        // Refers to the hasmap containing the exercise ID and the user answer
        outputHandler.print(feedbackEngine.analyzeError(this, userAnswer));
        return false;
    }

    // Retrieving a hint
    public String getHint(){
        return hintSystem.getHint(exerciseID, 1);
    }

    // This is used in the FeedbackEngine to provide the appropriate suggestion to a user's error
    public String detectErrorType(String userAnswer){

        // For question 1 of the CIC topic
        if (exerciseID.contains("CIC_Q1") && userAnswer.contains("A")){
            return "contrapositive_CIC_Q1";
        }
        if (exerciseID.contains("CIC_Q1") && userAnswer.contains("B")){
            return "inverse_CIC_Q1";
        }

        // For question 2 of the CIC topic
        if (exerciseID.contains("CIC_Q2") && userAnswer.contains("B")){
            return "contrapositive_CIC_Q2";
        }
        if (exerciseID.contains("CIC_Q2") && userAnswer.contains("C")){
            return "converse_CIC_Q2";
        }

        // For question 3 of the CIC topic
        if (exerciseID.contains("CIC_Q3") && userAnswer.contains("A")){
            return "inverse_CIC_Q3";
        }
        if (exerciseID.contains("CIC_Q3") && userAnswer.contains("C")){
            return "converse_CIC_Q3";
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


