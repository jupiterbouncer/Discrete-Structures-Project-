import java.util.HashMap;

public class FeedbackEngine{

    // Private member field (a hashmap holding a key string and a value string)
    private HashMap<String, String> errorFeedback;

    public FeedbackEngine(){

        // Creating a HashMap to store the different error types and their corresponding feedback
        errorFeedback = new HashMap<>();

        // Feedback for the CIC topic
        // Exercise 1
        errorFeedback.put("contrapositive_CIC_Q1", "It looks like you mixed up the contrapositive and converse"
        + "Remember: The contrapositive of p → q is ¬p → ¬q while the converse is q → p");

        errorFeedback.put("inverse_CIC_Q1", "It looks like you mixed up the inverse and converse"
        + "Remember: The inverse of p → q is ¬p → ¬q while the converse is q → p");

        // Exercise 2
        errorFeedback.put("contrapositive_CIC_Q2", "It looks like you mixed up the contrapositive and inverse"
        + "Remember: The contrapositive of p → q is ¬q → ¬p while the inverse should be ¬p → ¬q");

        errorFeedback.put("converse_CIC_Q2", "It looks like you mixed up the converse and inverse"
        + "Remember: The converse of p → q is q → p while the inverse should be ¬p → ¬q");

        // Exercise 3
        errorFeedback.put("inverse_CIC_Q3", "It looks like you mixed up the inverse and the contrapositive"
        + "Remember: The inverse of p → q is ¬p → ¬q while the contrapositive should be ¬q → ¬p");

        errorFeedback.put("converse_CIC_Q3", "It looks like you mixed up the converse and the contrapositive"
        + "Remember: The converse of p → q is q → p while the contrapositive should be ¬q → ¬p");


        // Feedback for the Definitions exercise
        // Exercise 1
        errorFeedback.put("command_DEF_Q1", "");
        errorFeedback.put("question_DEF_Q1", "");

        // Feedback for the TruthTable exercise
        // Exercise 1
        errorFeedback.put("onetrue_TT_Q1", "");
        errorFeedback.put("bothfalse_TT_Q1", "");
        errorFeedback.put("falsep_TT_Q1", "");

        // Exercise 2
        errorFeedback.put("TT_TT_Q2", "");
        errorFeedback.put("FT_TT_Q2", "");
        errorFeedback.put("FF_TT_Q2", "");

        // Exercise 3
        errorFeedback.put("alwaystrue_TT_Q3", "");
        errorFeedback.put("truep_TT_Q3", "");
        errorFeedback.put("falseq_TT_Q3", "");

        // Feedback for the LogicalConnectives exercise
        // Exercise 1
        errorFeedback.put("disjunction_LC_Q1", "");
        errorFeedback.put("biconditional_LC_Q1", "");

        // Exercise 2
        errorFeedback.put("and_LC_Q2", "");
        errorFeedback.put("conditional_LC_Q2", "");

        // Feedback for the ExpressingConditionals exercise
        // Exercise 1
        errorFeedback.put("inverse_EC_Q1", "");
        errorFeedback.put("converse_EC_Q1", "");

        // Exercise 2
        errorFeedback.put("inverse_EC_Q2", "");
        errorFeedback.put("converse_EC_Q2", "");

        // Generic error
        errorFeedback.put("generic_error", "Wrong!");

    }

    // Retrieves the exercise and the user's answer as arguments for error detection
    public String analyzeError(Exercise exercise, String userAnswer){
        String errorType = exercise.detectErrorType(userAnswer);

        // Using the error type (key) to fetch the feedback from the map
        if(errorFeedback.containsKey(errorType)) return errorFeedback.get(errorType);

        return "Incorrect. Review the rules for this topic and try again";
    }

    // Getter method for feedback
    public String getFeedback(String errorType){
        return errorFeedback.getOrDefault(errorType, "Wrong answer, look at your face");
    }
}

