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
    // Records an attempt to answer a question and updates streak
    public void recordAttemptedQuestion(boolean isCorrect) {
        totalQuestionsAttempted++;

        if (isCorrect) {
            totalCorrectAnswers++;
            currentStreak++;

            if (currentStreak > maxStreak) {
                maxStreak = currentStreak;
            }
        } else {
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


    public int getAvailableHints() {
        return availableHints;
    }
}


