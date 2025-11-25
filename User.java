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
}
