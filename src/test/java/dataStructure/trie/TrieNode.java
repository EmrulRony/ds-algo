package dataStructure.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEndOfTheString;

    public TrieNode() {
        this.children = new HashMap<>();
        this.isEndOfTheString = false;
    }
}
