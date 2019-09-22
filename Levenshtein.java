
public class Levenshtein {

    public static void main(String[] args) {
        String s1 = "string1";
        String s2 = "p";

        int[][] memo = new int[s1.length() + 1][s2.length() + 1];
        
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[i].length; j++) {
                memo[i][j] = -1;
            }
        }

        int shortestDistance = shortestDistance(s1, s2, memo);
        System.out.println(shortestDistance);
    }

    public static int shortestDistance(String s1, String s2, int[][] memo) {
        if (s1.isEmpty()) {
            return s2.length();
        }

        if (s2.isEmpty()) {
            return s1.length();
        }

        if (memo[s1.length()][s2.length()] != -1) {
            return memo[s1.length()][s2.length()];
        }

        int substitution = shortestDistance(s1.substring(1), s2.substring(1), memo) + costOfSubstitution(s1.charAt(0), s2.charAt(0));
        int insertion = shortestDistance(s1, s2.substring(1), memo) + 1;
        int deletion = shortestDistance(s1.substring(1), s2, memo) + 1;

        int min = min(substitution, insertion, deletion);
        memo[s1.length()][s2.length()] = min;
        return min;
    }

    public static int costOfSubstitution(char c1, char c2) {
        return c1 == c2 ? 0 : 1;
    }

    public static int min(int substitution, int insertion, int deletion) {
        return Math.min(deletion, (Math.min(substitution, insertion)));
    }

}