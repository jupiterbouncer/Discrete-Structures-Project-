import java.util.HashSet; //

public class User {
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
