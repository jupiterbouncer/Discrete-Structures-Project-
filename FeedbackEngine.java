import java.util.HashMap;

public class FeedbackEngine{
    // Private member field 
    private HashMap<String, String> errorFeedback;

    public FeedbackEngine(){
        errorFeedback = new HashMap<>();

        errorFeedback.put("contrapositive_CIC_Q1", "It looks like you mixed up the contrapositive and converse"
        + "Remember: The contrapositive of p → q is ¬p → ¬q while the converse is q → p");

        errorFeedback.put("inverse_CIC_Q1", "It looks like you mixed up the inverse and converse"
        + "Remember: The inverse of p → q is ¬p → ¬q while the converse is q → p");


        errorFeedback.put("contrapositive_CIC_Q2", "It looks like you mixed up the contrapositive and inverse"
        + "Remember: The contrapositive of p → q is ¬q → ¬p while the inverse should be ¬p → ¬q");

        errorFeedback.put("converse_CIC_Q2", "It looks like you mixed up the converse and inverse"
        + "Remember: The converse of p → q is q → p while the inverse should be ¬p → ¬q");


        errorFeedback.put("inverse_CIC_Q3", "It looks like you mixed up the inverse and the contrapositive"
        + "Remember: The inverse of p → q is ¬p → ¬q while the contrapositive should be ¬q → ¬p");

        errorFeedback.put("converse_CIC_Q3", "It looks like you mixed up the converse and the contrapositive"
        + "Remember: The converse of p → q is q → p while the contrapositive should be ¬q → ¬p");


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
