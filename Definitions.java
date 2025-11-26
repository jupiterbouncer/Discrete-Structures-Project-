import java.util.ArrayList;

public class Definitions{
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

    private OutputHandler outputHandler;

    public Definitions(String title, String description, OutputHandler outputHandler){
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

    public String getTitle(){
        return title;
    }

    public int getPoints(){
        return this.totalPoints;
    }

    // Display lesson material
    public void displayContent(){
        int count = 1;
        outputHandler.print("===" + title + "===");
        for (String section : content){
            outputHandler.print(count + "." + section);
            count++;
        }
    }

    // Run exercises
    public void startExercises(){
        outputHandler.print("Starting exercises for: " + title);
        for (Exercise exercise : exercises){
            exercise.displayQuestion();

            boolean correct = exercise.checkAnswer();

            if (correct) {
                score += exercise.getPoints();
                outputHandler.print(getCompletionRate() + "%");
            } else {
                outputHandler.print("Incorrect. Hint: " + exercise.getHint());
            }
            outputHandler.print("\n");
        }
        this.completed = true;
        outputHandler.print("You scored " + score + "/" + totalPoints + "(" + ((int) score/totalPoints * 100) + "%)");
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

    // Add lesson material
    public void addContent(String text){
        this.content.add(text);
    }

    // Add an exercise to this topic
    public void addExercise(Exercise ex){
        exercises.add(ex);
        totalPoints += ex.getPoints();
    }
    
}

