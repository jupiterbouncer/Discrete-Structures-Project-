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
    private int hintIndex = 0;

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

        TutorApp.CURRENT_INSTANCE.setCurrentExercise(this);

        outputHandler.print("\nQuestion: " + question); 
        if (!options.isEmpty()){
            for (String option: options){
                outputHandler.print(option);
            }
        }
    }

    // Collecting a user's answer
    public boolean checkAnswer(){

        answered = false;
        if (!answered) {
            userAnswer = JOptionPane.showInputDialog(null, "Enter the letter corresponding to your answer within the options: ");
            userAnswer.trim().toUpperCase();

            if (userAnswer == null) outputHandler.print("No answer entered. Marked as failed");
            else answered = true;
        }

        if (userAnswer.equalsIgnoreCase(correctAnswer)){
            outputHandler.print("Correct");
            return true;

        } else {

            // Refers to the hashmap containing the exercise ID and the user answer
            outputHandler.print("Incorrect. " + feedbackEngine.analyzeError(this, userAnswer));
            return false;
    }
    }

    // Retrieving a hint
    public String getHint(HintSystem hintSystem){
        String hint = hintSystem.getHint(exerciseID, hintIndex);
        
        if (hintIndex < hintSystem.totalHints(exerciseID) - 1) hintIndex++;

        return hint;
    }

    // This is used in the FeedbackEngine to provide the appropriate suggestion to a user's error
    public String detectErrorType(String userAnswer){
        userAnswer = userAnswer.trim().toUpperCase();

        // For question 1 of the CIC topic
        if (exerciseID.contains("CIC_Q1") && userAnswer.equals("A")){
            return "contrapositive_CIC_Q1";
        }
        if (exerciseID.contains("CIC_Q1") && userAnswer.equals("B")){
            return "inverse_CIC_Q1";
        }

        // For question 2 of the CIC topic
        if (exerciseID.contains("CIC_Q2") && userAnswer.equals("B")){
            return "contrapositive_CIC_Q2";
        }
        if (exerciseID.contains("CIC_Q2") && userAnswer.equals("C")){
            return "converse_CIC_Q2";
        }

        // For question 3 of the CIC topic
        if (exerciseID.contains("CIC_Q3") && userAnswer.equals("A")){
            return "inverse_CIC_Q3";
        }
        if (exerciseID.contains("CIC_Q3") && userAnswer.equals("C")){
            return "converse_CIC_Q3";
        }

        // For question 1 of the Definitions topic
        if (exerciseID.contains("DEF_Q1") && userAnswer.equals("B")){
            return "command_DEF_Q1";
        }
        if (exerciseID.contains("DEF_Q1") && userAnswer.equals("C")){
            return "question_DEF_Q1";
        }

        // For question 2 of the Definitions topic
        if (exerciseID.contains("DEF_Q2") && userAnswer.equals("A")){
            return "height_DEF_Q2";
        }
        if (exerciseID.contains("DEF_Q2") && userAnswer.equals("C")){
            return "messi_DEF_Q2";
        }

        // For question 1 of the TruthTable topic
        if (exerciseID.contains("TT_Q1") && userAnswer.equals("B")){
            return "onetrue_TT_Q1";
        }
        if (exerciseID.contains("TT_Q1") && userAnswer.equals("C")){
            return "bothfalse_TT_Q1";
        }
        if (exerciseID.contains("TT_Q1") && userAnswer.equals("D")){
            return "falsep_TT_Q1";
        }

        // For question 2 of the TruthTable topic
        if (exerciseID.contains("TT_Q2") && userAnswer.equals("A")){
            return "TT_TT_Q2";
        }
        if (exerciseID.contains("TT_Q2") && userAnswer.equals("B")){
            return "FT_TT_Q2";
        }
        if (exerciseID.contains("TT_Q2") && userAnswer.equals("D")){
            return "FF_TT_Q2";
        }

        // For question 3 of the TruthTable topic
        if (exerciseID.contains("TT_Q3") && userAnswer.equals("A")){
            return "alwaystrue_TT_Q3";
        }
        if (exerciseID.contains("TT_Q3") && userAnswer.equals("B")){
            return "truep_TT_Q3";
        }
        if (exerciseID.contains("TT_Q3") && userAnswer.equals("C")){
            return "falseq_TT_Q3";
        }

        // For question 1 of the LogicalConnectives topic
        if (exerciseID.contains("LC_Q1") && userAnswer.equals("A")){
            return "conjunction_LC_Q1";
        }
        if (exerciseID.contains("LC_Q1") && userAnswer.equals("B")){
            return "disjunction_LC_Q1";
        }
        if (exerciseID.contains("LC_Q1") && userAnswer.equals("D")){
            return "biconditional_LC_Q1";
        }

        // For question 2 of the LogicalConnectives topic

        if (exerciseID.contains("LC_Q2") && userAnswer.equals("B")){
            return "and_LC_Q2";
        }
        if (exerciseID.contains("LC_Q2") && userAnswer.equals("C")){
            return "conditional_LC_Q2";
        }

        // For question 1 of the ExpressingConditionals topic
        if (exerciseID.contains("EC_Q1") && userAnswer.equals("A")){
            return "inverse_EC_Q1";
        }
        if (exerciseID.contains("EC_Q1") && userAnswer.equals("B")){
            return "converse_EC_Q1";
        }

        // For question 2 of the ExpressingConditionals topic
        if (exerciseID.contains("EC_Q2") && userAnswer.equals("A")){
            return "inverse_EC_Q2";
        }
        if (exerciseID.contains("EC_Q2") && userAnswer.equals("C")){
            return "converse_EC_Q2";
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


