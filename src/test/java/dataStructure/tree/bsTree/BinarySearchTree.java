package dataStructure.tree.bsTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    private TreeNode root;

    private void insert(int value) {
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode currentNode = queue.poll();
                if (value <= currentNode.getValue()) {
                    if (currentNode.getLeftNode() == null) {
                        currentNode.setLeftNode(new TreeNode(value));
                    } else {
                        queue.add(currentNode.getLeftNode());
                    }
                } else if (value > currentNode.getValue()) {
                    if (currentNode.getRightNode() == null) {
                        currentNode.setRightNode(new TreeNode(value));
                    } else {
                        queue.add(currentNode.getRightNode());
                    }
                }
            }
        } else {
            root = new TreeNode(value);
        }
    }

    public void levelOrderTraverse() {
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode currentNode = queue.remove();
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

    public void remove(int value) {
        removeNode(root, value);
    }

    private void removeNode(TreeNode root, int value) {
        if (root == null) {
            return;
        }
        if (root.getValue() == value) {
            if (root.getLeftNode() == null && root.getRightNode() == null) {
                root = null;
            } else if (root.getLeftNode() != null && root.getRightNode() == null) {
                root = root.getLeftNode();
            } else if (root.getRightNode() != null && root.getLeftNode() == null) {
                root = root.getRightNode();
            } else {
                TreeNode leastRightMostNode = getLeastRightMostNode(root.getRightNode());
                root.setValue(leastRightMostNode.getValue());
                removeNode(root.getRightNode(), leastRightMostNode.getValue());
            }
        }
        removeNode(root.getLeftNode(), value);
        removeNode(root.getRightNode(), value);
    }

    private TreeNode getLeastRightMostNode(TreeNode root) {
        if (root.getLeftNode() != null) {
            getLeastRightMostNode(root.getLeftNode());
        }
        return root;
    }

    // Root --> Left --> Right
    public void preOrderTraversal() {
        if (root != null) {
            preOrderTraversalInternal(root);
        }
    }

    private void preOrderTraversalInternal(TreeNode root) {
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

    private void inOrderTraversalInternal(TreeNode root) {
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

    private void postOrderTraversalInternal(TreeNode root) {
        if (root != null) {
            preOrderTraversalInternal(root.getLeftNode());
            preOrderTraversalInternal(root.getRightNode());
            System.out.println(root.getValue());
        }
    }

    public boolean search(int value) {
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode currentNode = queue.remove();
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
        BinarySearchTree binaryTree = new BinarySearchTree();
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
