import java.util.*;
import java.io.*;

public class Trie {
    private static TrieNode root;

    public Trie() throws FileNotFoundException {
        root = new TrieNode();
        initDictionary("/Users/jonathanwang/Downloads/Projects/SpellChecker/words.txt");
    }

    private static void initDictionary(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner input = new Scanner(file);

        Set<String> dict = new HashSet<String>();

        while (input.hasNextLine()) {
            String word = input.nextLine();
            insert(word);
        }

        input.close();
    }

    private static void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            boolean isWord = i == word.length() - 1 ? true : false;
            if (!curr.map.containsKey(c)) {
                curr.map.put(c, new TrieNode(new HashMap<>(), isWord));
            }
            curr = curr.map.get(c);
        }
    }

    // Iterate through the word check the last boolean.
    public static boolean isWord(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            boolean lastChar = i == word.length() - 1 ? true : false;

            if (lastChar) {
                return curr.map.get(c).isWord;
            }

            if (!curr.map.containsKey(c)) {
                return false;
            }

            curr = curr.map.get(c);
        }

        return false;
    }

}