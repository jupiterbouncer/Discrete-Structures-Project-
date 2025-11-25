import java.util.HashMap;

public class HintSystem {

    private HashMap<String, String[]> hintBank;
    
    public HintSystem(){
        hintBank = new HashMap<>();

        hintBank.put("CIC_Q1", new String[]{
            "Hint 1: The inverse negates both p and q (p → q becomes ¬p → ¬q)",
            "Hint 2: The contrapositive negates AND switches the componenets (p → q becomes ¬q → ¬p).",
            "Hint 3: For 'if p then q', contrapositive = 'if not q then p'"
        });

        hintBank.put("TruthTable_Q1", new String[]{
            "Hint 1: Fill columns for AND and OR next",
            "Hint 2: Remember, AND is true only when both inputs are true",
            "Hint 3: Remember, OR is false only when both inputs are false"
        });

        // add a new key with their possible hints

    }

    public String getHint(String exerciseID, int level){
        if (!hintBank.containsKey(exerciseID)) return "No hints available for this exercise";

        String[] hints = hintBank.get(exerciseID);
        if (level < 1 || level > hints.length) return "No more hints available";

        return hints[level - 1];
    }

    public int hintCount(String exerciseID) {
        return hintBank.containsKey(exerciseID) ? hintBank.get(exerciseID).length : 0;
    }
}