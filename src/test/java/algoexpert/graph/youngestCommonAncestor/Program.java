package algoexpert.graph.youngestCommonAncestor;

public class Program {
    public static AncestralTree getYoungestCommonAncestor(AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {
        // Write your code here.
        int descendantOneDepth = getDepthOfDescendant(topAncestor, descendantOne);
        int descendantTwoDepth = getDepthOfDescendant(topAncestor, descendantTwo);
        if (descendantOneDepth > descendantTwoDepth) {
            return getYoungestCommonAncestorInternal(descendantTwo, descendantOne, descendantOneDepth - descendantTwoDepth);
        }
        return getYoungestCommonAncestorInternal(descendantOne, descendantTwo, descendantTwoDepth - descendantOneDepth);
    }

    private static AncestralTree getYoungestCommonAncestorInternal(AncestralTree nearDescendant,
                                                                   AncestralTree distantDescendant, int depthDiff)
    {
        while (depthDiff > 0) {
            distantDescendant = distantDescendant.ancestor;
            depthDiff--;
        }
        while (nearDescendant != distantDescendant) {
            nearDescendant = nearDescendant.ancestor;
            distantDescendant = distantDescendant.ancestor;
        }
        return nearDescendant;
    }

    private static int getDepthOfDescendant(AncestralTree ancestor, AncestralTree descendant) {
        int depth = 0;
        while (descendant != ancestor) {
            depth++;
            descendant = descendant.ancestor;
        }
        return depth;
    }

    static class AncestralTree {
        public char name;
        public AncestralTree ancestor;

        AncestralTree(char name) {
            this.name = name;
            this.ancestor = null;
        }

        // This method is for testing only.
        void addAsAncestor(AncestralTree[] descendants) {
            for (AncestralTree descendant : descendants) {
                descendant.ancestor = this;
            }
        }
    }
}
