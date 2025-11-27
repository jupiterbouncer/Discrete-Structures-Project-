import java.util.ArrayList;
public class ExpressingConditionals {
    // Topic covering the different ways of expressing a conditional statement (p → q)

    // Attributes
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

    private OutputHandler outputHandler;

    // Constructor
    public ExpressingConditionals(String title, String description, OutputHandler outputHandler){
        this.title = title;
        this.description = description;
        this.content = new ArrayList<>();
        this.exercises = new ArrayList<>();
        this.totalPoints = 0;
        this.score = 0;
        this.completed = false;
        this.hintCount = 0;
        this.outputHandler = outputHandler;
    }

    // Getters
    public String getTitle(){
        return this.title;
    }

    public String getDescription(){
        return this.description;
    }

    public int getPoints(){
        return this.totalPoints;
    }

    // Methods
    // Checks if a topic is completed
    public boolean isCompleted() {
        return completed;
    }


    // Add lesson material
    public void addContent(String text){
        this.content.add(text);
    }

    // Display lesson material
    public void displayContent() {
        outputHandler.print("=== " + title + " ===");
        for (String section : content) {
            outputHandler.print(section);
            outputHandler.print(""); // blank line between sections
        }
    }
        // Run exercises (MCQs)
        public void startExercises() {
            if (exercises.isEmpty()) {
                outputHandler.print("No exercises available yet for: " + title);
                return;
            }

            outputHandler.print("Starting exercises for: " + title);
            outputHandler.print("");

            for (Exercise exercise : exercises) {
                exercise.displayQuestion();
                boolean correct = exercise.checkAnswer();

                if (correct) {
                    score += exercise.getPoints();
                } else {
                    outputHandler.print("Incorrect. Hint: " + exercise.getHint());
                    hintCount++; // track hint usage
                }

                outputHandler.print("");
            }

            this.completed = true;

            if (totalPoints > 0) {
                int percentage = (int) ((score * 100.0) / totalPoints);
                outputHandler.print("You scored " + score + "/" + totalPoints + " (" + percentage + "%)");
            } else {
                outputHandler.print("You scored " + score + "/" + totalPoints);
            }
        }

    // Progress calculation
    public double getCompletionRate(){
        if (exercises.isEmpty()) return 0.0;

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