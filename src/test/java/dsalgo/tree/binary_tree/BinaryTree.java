package dsalgo.tree.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    private BinaryTreeNode root;

    private void insert(int value) {
        if (root != null) {
            Queue<BinaryTreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                BinaryTreeNode currentNode = queue.remove();
                if (currentNode.getLeftNode() == null) {
                    currentNode.setLeftNode(new BinaryTreeNode(value));
                    break;
                } else if (currentNode.getRightNode() == null) {
                    currentNode.setRightNode(new BinaryTreeNode(value));
                    break;
                } else {
                    queue.add(currentNode.getLeftNode());
                    queue.add(currentNode.getRightNode());
                }
            }
        } else {
            root = new BinaryTreeNode(value);
        }
    }

    public void levelOrderTraverse() {
        if (root != null) {
            Queue<BinaryTreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                BinaryTreeNode currentNode = queue.remove();
                System.out.println(currentNode.getValue());
                if (currentNode.getLeftNode() != null) {
                    queue.add(currentNode.getLeftNode());
                }
                if (currentNode.getRightNode() != null) {
                    queue.add(currentNode.getRightNode());
                }
            }
        }
    }

    // Root --> Left --> Right
    public void preOrderTraversal() {
        if (root != null) {
            preOrderTraversalInternal(root);
        }
    }

    private void preOrderTraversalInternal(BinaryTreeNode root) {
        if (root != null) {
            System.out.println(root.getValue());
            preOrderTraversalInternal(root.getLeftNode());
            preOrderTraversalInternal(root.getRightNode());
        }
    }

    // Left --> Root --> Right
    public void inOrderTraversal() {
        if (root != null) {
            inOrderTraversalInternal(root);
        }
    }

    private void inOrderTraversalInternal(BinaryTreeNode root) {
        if (root != null) {
            inOrderTraversalInternal(root.getLeftNode());
            System.out.println(root.getValue());
            inOrderTraversalInternal(root.getRightNode());
        }
    }

    // Left --> Right --> Root
    public void postOrderTraversal() {
        if (root != null) {
            postOrderTraversalInternal(root);
        }
    }

    private void postOrderTraversalInternal(BinaryTreeNode root) {
        if (root != null) {
            preOrderTraversalInternal(root.getLeftNode());
            preOrderTraversalInternal(root.getRightNode());
            System.out.println(root.getValue());
        }
    }

    public boolean search(int value) {
        if (root != null) {
            Queue<BinaryTreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                BinaryTreeNode currentNode = queue.remove();
                if (currentNode.getValue() == value) {
                    return true;
                }
                if (currentNode.getLeftNode() != null) {
                    queue.add(currentNode.getLeftNode());
                }
                if (currentNode.getRightNode() != null) {
                    queue.add(currentNode.getRightNode());
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        int[] arr = {20, 100, 3, 50, 15, 250, 35, 222};
        for (int num : arr) {
            binaryTree.insert(num);
        }

        System.out.println("--- Level Order ---");
        binaryTree.levelOrderTraverse();

        System.out.println("--- PreOrder ---");
        binaryTree.preOrderTraversal();

        System.out.println("--- InOrder ---");
        binaryTree.inOrderTraversal();

        System.out.println("--- PostOrder ---");
        binaryTree.postOrderTraversal();

        System.out.println("--- Search ---");
        boolean searchResult = binaryTree.search(222);
        System.out.println("Found: " + searchResult);
    }
}
