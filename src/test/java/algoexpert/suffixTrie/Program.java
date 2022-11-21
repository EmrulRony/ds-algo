package algoexpert.suffixTrie;

import java.util.HashMap;
import java.util.Map;

public class Program {
    // Do not edit the class below except for the
    // populateSuffixTrieFrom and contains methods.
    // Feel free to add new properties and methods
    // to the class.
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    }

    static class SuffixTrie {
        TrieNode root = new TrieNode();
        char endSymbol = '*';

        public SuffixTrie(String str) {
            populateSuffixTrieFrom(str);
        }

        public void populateSuffixTrieFrom(String str) {
            // Write your code here.
            for (int i = 0; i < str.length(); i++) {
                TrieNode currentNode = root;
                for (int j = i; j < str.length(); j++) {
                    char character = str.charAt(j);
                    TrieNode node = currentNode.children.get(character);
                    if (node == null) {
                        node = new TrieNode();
                        currentNode.children.put(character, node);
                    }
                    currentNode = node;
                }
                currentNode.children.put(endSymbol, null);
            }
        }

        public boolean contains(String str) {
            // Write your code here.
            TrieNode currentNode = root;
            for (int i = 0; i < str.length(); i++) {
                char character = str.charAt(i);
                TrieNode node = currentNode.children.get(character);
                if (node == null) {
                    return false;
                }
                currentNode = node;
            }
            return currentNode.children.containsKey(endSymbol);
        }
    }
}
