package dataStructure.trie;

public class Trie {
    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String str) {
        TrieNode currentNode = root;
        for (int i = 0; i < str.length(); i++) {
            char character = str.charAt(i);
            TrieNode node = root.children.get(character);
            if (node == null) {
                node = new TrieNode();
                currentNode.children.put(character, node);
            }
            currentNode = node;
        }
        currentNode.isEndOfTheString = true;
    }

    public boolean searchStr(String str) {
        TrieNode currentNode = root;
        for (int i = 0; i < str.length(); i++) {
            char character = str.charAt(i);
            TrieNode node = currentNode.children.get(character);
            if (node == null) {
                return false;
            }
            currentNode = node;
        }
        return currentNode.isEndOfTheString;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("manchester");
//        trie.insert("united");
//        trie.insert("manchester-city");
//        trie.insert("man");

        System.out.println(trie.searchStr("manchester"));
//        System.out.println(trie.searchStr("united"));
//        System.out.println(trie.searchStr("man"));
    }
}
