import java.util.ArrayList;

public class Connectives {


        private String title;
        private String symbol;
        private String description;
        private ArrayList<String> examples;

        public Connectives( String title, String symbol, String description) {

            this.title = title;
            this.symbol = symbol;
            this.description = description;
            this.examples = new ArrayList<>();

        }

    public void addExample(String example) {
        examples.add(example);
    }
    public String getTitle() {
            return this.title;
    }
    public String getSymbol() {
            return this.symbol;
    }
    public String getDescription() {
            return this.description;
    }
    public ArrayList<String> getExamples() {
        return examples;
    }
}
