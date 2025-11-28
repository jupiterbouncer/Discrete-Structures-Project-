import java.util.HashMap;

public class HintSystem {

    // Private member field (a hashmap holding a string key and a string array value)
    private HashMap<String, String[]> hintBank;
    
    public HintSystem(){
        hintBank = new HashMap<>();

        hintBank.put("CIC_Q1", new String[]{
            "Hint 1: The inverse negates both p and q (p → q becomes ¬p → ¬q)",
            "Hint 2: The contrapositive negates AND switches the componenets (p → q becomes ¬q → ¬p).",
            "Hint 3: For 'if p then q', contrapositive = 'if not q then p'"
        });

        hintBank.put("CIC_Q3", new String[]{
            "Hint 1: The inverse negates both p and q (p → q becomes ¬p → ¬q)",
            "Hint 2: The contrapositive negates AND switches the componenets (p → q becomes ¬q → ¬p).",
            "Hint 3: For 'if p then q', contrapositive = 'if not q then p'"
        });

        hintBank.put("CIC_Q2", new String[]{
            "Hint 1: The inverse negates both p and q (p → q becomes ¬p → ¬q)",
            "Hint 2: The contrapositive negates AND switches the componenets (p → q becomes ¬q → ¬p).",
            "Hint 3: For 'if p then q', contrapositive = 'if not q then p'"
        });

        hintBank.put("TT_Q1", new String[]{
            "Hint 1: Remember, AND is true only when both inputs are true",
            "Hint 2: Remember, OR is false only when both inputs are false"
        });

        hintBank.put("TT_Q2", new String[]{
            "Hint 1: Remember, AND is true only when both inputs are true",
            "Hint 2: Remember, OR is false only when both inputs are false"
        });

        hintBank.put("TT_Q3", new String[]{
            "Hint 1: Remember, AND is true only when both inputs are true",
            "Hint 2: Remember, OR is false only when both inputs are false"
        });

        hintBank.put("LC_Q1", new String[]{
            "Hint 1: ",
            "Hint 2: ",
            "Hint 3: "  
        });

        hintBank.put("LC_Q2", new String[]{
            "Hint 1: ",
            "Hint 2: ",
            "Hint 3: "
        });

        hintBank.put("EC_Q1", new String[]{
            "Hint 1: ",
            "Hint 2: ",
            "Hint 3: "
        });

        hintBank.put("EC_Q2", new String[]{
            "Hint 1: ",
            "Hint 2: ",
            "Hint 3: "
        });

        // add a new key with their possible hints

    }

    public String getHint(String exerciseID, int hintIndex){
        if (!hintBank.containsKey(exerciseID)) return "No hints available for this exercise";

        String[] hints = hintBank.get(exerciseID);
        
        if (hintIndex < 0 || hintIndex >= hints.length) return "No more hints";

        return hints[hintIndex];
    }

    public int hintCount(String exerciseID) {
        return hintBank.containsKey(exerciseID) ? hintBank.get(exerciseID).length : 0;
    }

    public int totalHints(String exerciseID) {
        if (exerciseID.contains("CIC")) return 3;
        if (exerciseID.contains("TT")) return 2;
        if (exerciseID.contains("DEF")) return 1;
        if (exerciseID.contains("LC")) return 3;

        else return 3;

    }
}
