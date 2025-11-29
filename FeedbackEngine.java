import java.util.HashMap;

public class FeedbackEngine{

    // Private member field (a hashmap holding a key string and a value string)
    private HashMap<String, String> errorFeedback;

    public FeedbackEngine(){

        // Creating a HashMap to store the different error types and their corresponding feedback
        errorFeedback = new HashMap<>();

        // Feedback for the CIC topic
        // Exercise 1
        errorFeedback.put("contrapositive_CIC_Q1", "It looks like you mixed up the contrapositive and converse. Remember: The contrapositive of p → q is ¬p → ¬q while the converse is q → p");

        errorFeedback.put("inverse_CIC_Q1", "It looks like you mixed up the inverse and converse. Remember: The inverse of p → q is ¬p → ¬q while the converse is q → p");

        // Exercise 2
        errorFeedback.put("contrapositive_CIC_Q2", "It looks like you mixed up the contrapositive and inverse. Remember: The contrapositive of p → q is ¬q → ¬p while the inverse should be ¬p → ¬q");

        errorFeedback.put("converse_CIC_Q2", "It looks like you mixed up the converse and inverse. Remember: The converse of p → q is q → p while the inverse should be ¬p → ¬q");

        // Exercise 3
        errorFeedback.put("inverse_CIC_Q3", "It looks like you mixed up the inverse and the contrapositive. Remember: The inverse of p → q is ¬p → ¬q while the contrapositive should be ¬q → ¬p");

        errorFeedback.put("converse_CIC_Q3", "It looks like you mixed up the converse and the contrapositive. Remember: The converse of p → q is q → p while the contrapositive should be ¬q → ¬p");

        // Feedback for the Definitions exercise
        // Exercise 1
        errorFeedback.put("command_DEF_Q1", "Remember that a proposition cannot be a command! It makes it impossible to evaluate");
        errorFeedback.put("question_DEF_Q1", "We cannot evaluate a quesiton to true or false, hence it is not a proposition");

        // Exercise 2
        errorFeedback.put("height_DEF_Q2", "This statement is strange but it is still declarative because we can evaluate it to either true or false");
        errorFeedback.put("messi_DEF_Q2", "This statement is declarative because we can evaluate it to either true or false");

        // Feedback for the TruthTable exercise
        // Exercise 1
        errorFeedback.put("onetrue_TT_Q1", "You're mixing up the AND and the OR functions. AND is only true when both p and q are true not just when one of them is true");
        errorFeedback.put("bothfalse_TT_Q1", "AND is only true when both p and q are true, not when both p and q are false");
        errorFeedback.put("falsep_TT_Q1", "AND is only true when both p and q are true, not when only p is false");

        // Exercise 2
        errorFeedback.put("TT_TT_Q2", "There's no reason for a conditional to be false if both the precedent and antecedent are true");
        errorFeedback.put("FT_TT_Q2", "Your reasoning is right but false implying true still evaluates to true. Remember the politician example");
        errorFeedback.put("FF_TT_Q2", "Close! Your reasoning is right but false implying false still evaluates to true. Remember the politician example");

        // Exercise 3
        errorFeedback.put("alwaystrue_TT_Q3", "A biconditional isn't always true. It takes just one to be false for it to be false (works conversely)");
        errorFeedback.put("truep_TT_Q3", "Remember biconditionals work both ways, both have to be true");
        errorFeedback.put("falseq_TT_Q3", "Remember biconditionals work both ways, none should be false");

        // Feedback for the LogicalConnectives exercise
        // Exercise 1
        errorFeedback.put("conjunction_LC_Q1", "This should already be wrong true since it takes two values");
        errorFeedback.put("disjunction_LC_Q1", "This should already be wrong since it takes two values");
        errorFeedback.put("biconditional_LC_Q1", "This should already be wrong since it takes two values");

        // Exercise 2
        errorFeedback.put("and_LC_Q2", "The conjunction of two propositions are likely to have 'and' or 'but' in them but isjunctions have 'or'");
        errorFeedback.put("conditional_LC_Q2", "Disjunctions have 'or'");

        // Feedback for the ExpressingConditionals exercise
        // Exercise 1
        errorFeedback.put("inverse_EC_Q1", "This statement is the inverse of the original statement");
        errorFeedback.put("converse_EC_Q1", "This statement is the converse of the original statement");

        // Exercise 2
        errorFeedback.put("inverse_EC_Q2", "This statement is the inverse of the original statement");
        errorFeedback.put("converse_EC_Q2", "This statement is the inverse of the original statement");

        // Generic error
        errorFeedback.put("generic_error", "Wrong!");
    }

    // Retrieves the exercise and the user's answer as arguments for error detection
    public String analyzeError(Exercise exercise, String userAnswer){
        userAnswer = userAnswer.trim().toUpperCase();

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
