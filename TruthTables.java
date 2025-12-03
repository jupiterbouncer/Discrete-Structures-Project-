import java.util.ArrayList;

public class TruthTables implements Topic {
    private String title;
    private String description;

    private ArrayList<String> content;
    private ArrayList<Exercise> exercises;

    private OutputHandler outputHandler;
    private FeedbackEngine feedbackEngine;
    private HintSystem hintSystem;

    private int totalPoints = 0;
    private int score = 0;


    public TruthTables(String title, String description, OutputHandler outputHandler, FeedbackEngine feedbackEngine, HintSystem hintSystem) {
        this.title = title;
        this.description = description;
        this.outputHandler = outputHandler;
        this.feedbackEngine = feedbackEngine;
        this.hintSystem = hintSystem;

        this.content = new ArrayList<>();
        this.exercises = new ArrayList<>();
    }

    public void addContent(String text) {
        content.add(text);
    }

    public void addExercise(Exercise ex) {
        exercises.add(ex);
        totalPoints += ex.getPoints();
    }

    public void displayContent() {
        outputHandler.print("\n------" + title + "-------");
        outputHandler.print(description + "\n");

        for (String c : content) {
            outputHandler.print("." + c);
        }
        outputHandler.print("\n");
    }

    public void showNot() {
        outputHandler.print("""
                Truth Table for NOT ( ¬ )
                P   ¬P
                ------
                T    F
                F    T
                """);
    }

    public void showAnd() {
        outputHandler.print("""
                Truth Table for AND ( ∧ )
                P   Q   P∧Q
                --------------
                T   T     T
                T   F     F
                F   T     F
                F   F     F
                """);
    }

    public void showOr() {
        outputHandler.print("""
                Truth Table for OR ( ∨ )
                P   Q   P∨Q
                --------------
                T   T     T
                T   F     T
                F   T     T
                F   F     F
                """);

    }

    public void showImplication() {
        outputHandler.print("""
                Truth Table for Implication ( → )
                P   Q   P→Q
                --------------
                T   T     T
                T   F     F
                F   T     T
                F   F     T
                """);

    }

    public void showBiconditional() {
        outputHandler.print("""
                Truth Table for Biconditional ( ↔ )
                P   Q   P↔Q
                --------------
                T   T     T
                T   F     F
                F   T     F
                F   F     T
                """);
    }

    public void startExercises() {
        outputHandler.print("\n---- Truth Table Exercises----\n");

        for (Exercise ex : exercises) {
            ex.displayQuestion();
            boolean correct = ex.checkAnswer();

            if (correct) {
                score += ex.getPoints();
            } else {
                outputHandler.print("Incorrect");
            }
        }
        outputHandler.print("\nYour score : " + score + "/" + totalPoints);
    }
}
