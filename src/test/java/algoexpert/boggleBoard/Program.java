package algoexpert.boggleBoard;

import java.util.*;

public class Program {
    public static List<String> boggleBoard(char[][] board, String[] words) {
        // Write your code here.
        Trie trie = new Trie();
        for (String word : words) {
            trie.insertWord(word);
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        Set<String> finalWords = new HashSet<>();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                traverseBoggleBoard(row, col, trie.root, board, visited, finalWords);
            }
        }
        return new ArrayList<String>(finalWords);
    }

    private static void traverseBoggleBoard(int row, int col, TrieNode trieNode, char[][] board, boolean[][] visited, Set<String> finalWords) {
        char character = board[row][col];
        TrieNode node = trieNode.children.get(character);
        if (visited[row][col] || node == null) {
            return;
        }
        if (node.children.containsKey('*')) {
            finalWords.add(node.word);
        }
        visited[row][col] = true;
        List<Integer[]> neighbourNodes = getNeighbourNodes(row, col, board);
        for (Integer[] neighbour : neighbourNodes) {
            traverseBoggleBoard(neighbour[0], neighbour[1], node, board, visited, finalWords);
        }
        visited[row][col] = false;
    }

    private static List<Integer[]> getNeighbourNodes(int row, int col, char[][] board) {
        List<Integer[]> neighbours = new ArrayList<>();
        if (row > 0) { // top
            neighbours.add(new Integer[]{row - 1, col});
        }
        if (row > 0 && col < board[0].length - 1) { // top right
            neighbours.add(new Integer[]{row - 1, col + 1});
        }
        if (col < board[0].length - 1) { // right
            neighbours.add(new Integer[]{row, col + 1});
        }
        if (row < board.length - 1 && col < board[0].length - 1) {  // bottom right
            neighbours.add(new Integer[]{row + 1, col + 1});
        }
        if (row < board.length - 1) { // bottom
            neighbours.add(new Integer[]{row + 1, col});
        }
        if (row < board.length - 1 && col > 0) { // bottom left
            neighbours.add(new Integer[] {row + 1, col - 1});
        }
        if (col > 0) { // left
            neighbours.add(new Integer[]{row, col - 1});
        }
        if (row > 0 && col > 0) { // top left
            neighbours.add(new Integer[]{row - 1, col - 1});
        }
        return neighbours;
    }

    static class Trie {
        TrieNode root;
        private static final Character END_SYMBOL = '*';

        public Trie() {
            this.root = new TrieNode();
        }

        public void insertWord(String word) {
            TrieNode currentNode = root;
            for (int i = 0; i < word.length(); i++) {
                char character = word.charAt(i);
                TrieNode node = currentNode.children.get(character);
                if (node == null) {
                    node = new TrieNode();
                    currentNode.children.put(character, node);
                }
                currentNode = node;
            }
            currentNode.children.put(END_SYMBOL, null);
            currentNode.word = word;
        }
    }

    static class TrieNode {
        Map<Character, TrieNode> children;
        String word = "";

        public TrieNode() {
            children = new HashMap<>();
        }
    }
}
