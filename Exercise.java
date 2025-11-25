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
        for (String option: options){
            System.out.println(option);
        }
    }
}

    // Collecting a user's answer
    public boolean checkAnswer(){
        System.out.print("Your answer: ");
        userAnswer = JOptionPane.showInputDialog(null, "Enter the letter to your answer: ");

        answered = true;

        if (userAnswer.equalsIgnoreCase(correctAnswer)){
            System.out.println("Correct");
            return true;
        }

        System.out.println("Wrong answer");
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


