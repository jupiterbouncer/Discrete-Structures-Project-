import java.util.ArrayList;

public class TutorApp {

    // feedback and scoring system
}

class User{
    
}

class Definitions{

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

    public void displayContent(){

    }

    public void startExercises(){

    }

    public double getCompletionRate(){

    }

    public void addExercise(Exercise exercise){

    }
}

class Exercise{

}

class LogicalConnectives{
    // logical connectives
}

class TruthTables{
    // truth tables

}

class ExpressingConditionals{
    // the different ways of expressing conditionals
    
}

class CIC{
    // the converse, inverse, and contrapositive of a conditional
}

class FeedbackEngine{

}

class HintSystem{

}

class ScoreTracker{

}