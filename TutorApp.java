import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class TutorApp {

    // feedback and scoring system
}

class User {
    /* This class represents a learner using our programme
    Contains learner's identity and progress
     */
    // Attributes
    private String username;                      // Stores user's name
    private int currentLevel;                     // Stores user's current difficulty level
    private String currentTopicSection;           // Indicates the section the user has reached
    private ScoreTracker scoreTracker;            // Stores user's score
    private int availableHints;                   // stores number of hints left
    private HashSet<String> completedModules;     // Stores completed modules in a HashSet

    // Constructor
    public User(String username){
        this.username = username;
        this.currentLevel = 1;                            // Makes every user begin from difficulty level 1
        this.currentTopicSection = "Definitions";         // Definitions should be where each user starts from
        this.availableHints = 3;                          // Users begin with 3 hints
        this.scoreTracker = new ScoreTracker();
        this.completedModules = new HashSet<>();
    }

    //Getters and setters
    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
        this.username = userName;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    public String getCurrentTopicSection() {
        return currentTopicSection;
    }

    public void setCurrentTopicSection(String currentTopicSection) {
        this.currentTopicSection = currentTopicSection;
    }

    public class ScoreTracker {
        /* This class tracks a user's performance.
           It stores how many questions the user has attempted, how many they got correct, and their streaks.
        */
        // Attributes
        private int totalQuestionsAttempted;                    // total number of questions attempted
        private int totalCorrectAnswers;                        // total number of questions answered correctly
        private int currentStreak;                              // Current streak of correct answers
        private int maxStreak;                                  // highest streak ever achieved

        // Getters
        public int getTotalQuestionsAttempted() {
            return totalQuestionsAttempted;
        }
        public int getTotalCorrectAnswers() {
            return totalCorrectAnswers;
        }
        public int getCurrentStreak() {
            return currentStreak;
        }
        public int getMaxStreak() {
            return maxStreak;
        }

        // Constructor
        public ScoreTracker() {
            totalQuestionsAttempted = 0;
            totalCorrectAnswers = 0;
            currentStreak = 0;
            maxStreak = 0;
        }

        // Methods
        // Reecords an attempt to answer a question and updates streak
        public void recordAttemptedQuestion(boolean isCorrect) {
            totalQuestionsAttempted++;

            if (isCorrect) {
                totalCorrectAnswers++;
                currentStreak++;

                if (currentStreak > maxStreak) {
                    maxStreak = currentStreak;
                }
            }
            else {
                currentStreak = 0;                  // reset streak if user gets an answer wrong
            }
        }

        // Returns accuracy as a percentage
        public double getAccuracy() {
            if (totalQuestionsAttempted == 0) {
                return 0.0;
            }
            return (double) totalCorrectAnswers / totalQuestionsAttempted * 100.0;
        }

        // Resets all statistics
        public void resetScores() {
            totalQuestionsAttempted = 0;
            totalCorrectAnswers = 0;
            currentStreak = 0;
            maxStreak = 0;
        }


    }


    public int getAvailableHints() {
        return availableHints;
    }

    // Methods
    // Checks if a user can use any more hints
    public boolean canUseHint(){
        return availableHints > 0;
    }

    // Method for decrementing hints
    public void useHint(){
        if (canUseHint()) availableHints--;
    }

    // Method to give user's hints possibly as a reward
    public void addHint(int n){
        if (n > 0) availableHints += n;
    }

    // Method to add a module to the hashset of completed modules
    public void updateCompletedModules(String moduleName){
        completedModules.add(moduleName);
    }

    // Checks if a user has completed a particular module
    public boolean hasCompletedModule(String moduleName){
        return completedModules.contains(moduleName);
    }

    // Checks the modules that have been completed
    public HashSet<String> getCompletedModules(){
        return completedModules;
    }
}

// NEEDS COMPLETING!
class Definitions{
    // Topic covering the definitions

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

    public Definitions(String title, String description){
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
