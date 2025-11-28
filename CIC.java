import java.util.ArrayList;

public class CIC implements Topic{
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
    private static int hintCount = 2;

    private OutputHandler outputHandler;

    // Constructor
    public CIC(String title, String description, OutputHandler outputHandler){
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
        return this.title;
    }

    public String getDescription(){
        return this.description;
    }

    public int getPoints(){
        return this.totalPoints;
    }

    public int getHintCount(){
        return this.hintCount;
    }

    // Add lesson material
    public void addContent(String text){
        this.content.add(text);
    }

    // Display lesson material
    public void displayContent(){
        outputHandler.print("===" + title + "===");
        for (String section : content){
            outputHandler.print(section);
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
            } else {
                outputHandler.print("Incorrect");
            }

            outputHandler.print("\n");
        }

        this.completed = true;
        outputHandler.print("You scored " + score + "/" + totalPoints);
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
