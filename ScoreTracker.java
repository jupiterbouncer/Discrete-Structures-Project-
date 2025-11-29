public class ScoreTracker {
        /* This class tracks a user's performance.
           It stores how many questions the user has attempted, how many they got correct, and their streaks.
        */
        // Attributes
        private int totalScore = 0;

        public void addPoints(int points){
            totalScore += points;
        }

        public int getTotalScore(){
            return totalScore;
        }
}
