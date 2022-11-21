package dataStructure.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    Map<Character, TrieNode> children;

    public TrieNode() {
        this.children = new HashMap<>();
    }
}
