import java.util.ArrayList;
public class LogicalConnectives implements Topic{
//Topic covering the logical connectives

    //details
    private String title ;
    private String description ;

    private ArrayList <String> content;
    private ArrayList <Connectives> connectives;
    private ArrayList <Exercise> exercises;
    private ArrayList<String> examples;

    private int totalPoints;
    private int score;
    private boolean completed;
    private int hintCount;

    private OutputHandler outputHandler;
    private FeedbackEngine feedbackEngine;
    private HintSystem hintSystem;


    public LogicalConnectives(String title, String description, OutputHandler outputHandler ) {
        this.title = title;
        this.description = description;
        this.connectives = new ArrayList<>();
        this.content = new ArrayList<>();
        this.exercises = new ArrayList<>();
        this.examples = new ArrayList<> () ;
        this.totalPoints = 0 ;
        this.score = 0;
        this.completed = false;
        this.hintCount = 0;
        this.outputHandler = outputHandler;


    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }
    public int getPoints() {
        return this.totalPoints;
    }
    public void addContent(String text) {
        content.add(text);
    }
    public void addConnective(Connectives c) {
        connectives.add(c);
    }
    public void addExercise(Exercise exercise) {
        exercises.add(exercise);
        totalPoints += exercise.getPoints();
    }
    public void displayContent() {
        outputHandler.print("----" + title + "-----");

        outputHandler.print(description + "\n");

        for (String line : content) {
            outputHandler.print("." + line);
        }
        for (Connectives c : connectives) {
            outputHandler.print("\n" + c.getTitle() + " (" + c.getSymbol() + ")");
            for (String ex : c.getExamples()) {
                outputHandler.print(" Example : " + ex);
            }
        }
    }
    public void startExercises() {
        outputHandler.print("\n --- Exercises on : " + title + "---");
        for (Exercise exercise : exercises) {
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
        outputHandler.print("Your score: " + score + "/" + totalPoints + " in " + getTitle() + " exercises");



    }





}
