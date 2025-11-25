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

    @Override
    public String getTitle(){
        return title;
    }

    public int getPoints(){
        return this.totalPoints;
    }

    // Add lesson material
    public void addContent(String text){
        content.add(text);
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
    @Override
    public void addExercise(Exercise ex){
        exercises.add(ex);
        totalPoints += ex.getPoints();
    }
}


class LogicalConnectives {
    // logical connectives
}

class TruthTables{
    // truth tables

}

class ExpressingConditionals{
    // the different ways of expressing conditionals
    
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
