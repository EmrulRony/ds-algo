package algoexpert.binary_tree.BSTConstruct;

public class Program {
    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public BST insert(int value) {
            if (this.value > value) {
                if (this.left != null) {
                    this.left.insert(value);
                } else {
                    this.left = new BST(value);
                }
            } else {
                if (this.right != null) {
                    this.right.insert(value);
                } else {
                    this.right = new BST(value);
                }
            }
            return this;
        }

        public boolean contains(int value) {
            // Write your code here.
            boolean contains = false;
            if (this.value == value) {
                contains = true;
            } else if (this.value > value && this.left != null) {
                contains = this.left.contains(value);
            } else if (this.value <= value && this.right != null) {
                contains = this.right.contains(value);
            }
            return contains;
        }

        public BST remove(int value) {
            return removeInternal(value, null);
        }

        public BST removeInternal(int value, BST parent) {
            // Write your code here.
            if (this.value == value) {
                if (this.left != null && this.right != null) {
                    BST leastRightMostNode = findLeastRightMostNode(this.right);
                    this.value = leastRightMostNode.value;
                    this.right = this.right.removeInternal(leastRightMostNode.value, this.right);
                }
                else if (this.left != null && this.right == null) {
                    if (parent == null) {
                        if (this.left.left != null) {
                            return this.left;
                        }
                        this.value = this.left.value;
                        this.left = null;
                        return this;
                    }
                    return this.left;
                } else if (this.left == null && this.right != null) {
                    if (parent == null) {
                        if (this.right.right != null) {
                            return this.right;
                        }
                        this.value = this.right.value;
                        this.right = null;
                        return this;
                    }
                    return this.right;
                } else {
                    return null;
                }
            } else if (this.value > value) {
                if (parent == null) {
                    BST tree = this.left.removeInternal(value, this);
                    this.value = tree.value;
                    return tree;
                }
                this.left = this.left.removeInternal(value, this);
            } else {
                if (parent == null) {
                    BST tree = this.right.removeInternal(value, this);
                    this.value = tree.value;
                    return tree;
                }
                this.right = this.right.removeInternal(value, this);
            }
            return this;
        }

        private BST findLeastRightMostNode(BST root) {
            if (root.left != null) {
                return findLeastRightMostNode(root.left);
            }
            return root;
        }
    }
}

