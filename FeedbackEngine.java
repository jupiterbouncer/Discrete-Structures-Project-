import java.util.HashMap;

public class FeedbackEngine{
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