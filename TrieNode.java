import java.util.*;

public class TrieNode {

    Map<Character, TrieNode> map;
    boolean isWord;

    public TrieNode() {
        this.map = new HashMap<>();
        this.isWord = false;
    }

    public TrieNode(Map<Character, TrieNode> map, boolean isWord) {
        this.map = map;
        this.isWord = isWord;
    }

}
