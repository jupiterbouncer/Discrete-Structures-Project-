import java.util.HashMap;

public class HintSystem {

    // Private member field (a hashmap holding a string key and a string array value)
    private HashMap<String, String[]> hintBank;
    
    public HintSystem(){
        hintBank = new HashMap<>();

        hintBank.put("CIC_Q1", new String[]{
            "Hint: The inverse negates both p and q (p → q becomes ¬p → ¬q)",
            "Hint: The contrapositive negates AND switches the components (p → q becomes ¬q → ¬p).",
            "Hint: For 'if p then q', contrapositive = 'if not q then p'"
        });

        hintBank.put("CIC_Q3", new String[]{
            "Hint: The inverse negates both p and q (p → q becomes ¬p → ¬q)",
            "Hint: The contrapositive negates AND switches the componenets (p → q becomes ¬q → ¬p).",
            "Hint: For 'if p then q', contrapositive = 'if not q then p'"
        });

        hintBank.put("CIC_Q2", new String[]{
            "Hint: The inverse negates both p and q (p → q becomes ¬p → ¬q)",
            "Hint: The contrapositive negates AND switches the componenets (p → q becomes ¬q → ¬p).",
            "Hint: For 'if p then q', contrapositive = 'if not q then p'"
        });

        hintBank.put("DEF_Q1", new String[]{
            "Hint: Propositions must evaluate to either true or false"
        });

        hintBank.put("DEF_Q2", new String[]{
            "Hint: Propositions must evaluate to either true or false"
        });

        hintBank.put("TT_Q1", new String[]{
            "Hint: Remember, AND is true only when both inputs are true",
            "Hint: Remember, OR is false only when both inputs are false"
        });

        hintBank.put("TT_Q2", new String[]{
            "Hint: Remember, AND is true only when both inputs are true",
            "Hint: Remember, OR is false only when both inputs are false"
        });

        hintBank.put("TT_Q3", new String[]{
            "Hint: Remember, AND is true only when both inputs are true",
            "Hint: Remember, OR is false only when both inputs are false"
        });

        hintBank.put("LC_Q1", new String[]{
            "Hint: Which logical connective is unitary?"
        });

        hintBank.put("LC_Q2", new String[]{
            "Hint: Pick out the propositions you can find in this sentence",
            "Hint: Disjunction usually possesses 'or' in its statements"
        });

        hintBank.put("EC_Q1", new String[]{
            "Hint: Try remembering the different ways of arranging p → q",
            "Hint: q if p, is one of the ways of expressing p → q"
        });

        hintBank.put("EC_Q2", new String[]{
            "Hint: Try rearranging the statements as blocks",
            "Hint: q unless not p, is one of the ways of expressing p → q"
        });

    }

    public String getHint(String exerciseID, int hintIndex){
        if (!hintBank.containsKey(exerciseID)) return "No hints available for this exercise";

        String[] hints = hintBank.get(exerciseID);
        
        if (hintIndex < 0 || hintIndex > hints.length) return "No more hints";

        return hints[hintIndex];
    }

    public int hintCount(String exerciseID) {
        return hintBank.containsKey(exerciseID) ? hintBank.get(exerciseID).length : 0;
    }

    public int totalHints(String exerciseID) {
        if (exerciseID.contains("CIC")) return 3;
        if (exerciseID.contains("TT")) return 2;
        if (exerciseID.contains("DEF")) return 1;
        if (exerciseID.contains("LC")) return 1;

        else return 3;

    }
}
