package algoexpert.graph.detectCycleIngraph;

public class Program {

    public boolean cycleInGraph(int[][] edges) {
        // Write your code here.
        boolean[] visited = new boolean[edges.length];
        boolean[] inCallStack = new boolean[edges.length];
        boolean hasCycle = false;
        for (int node = 0; node < edges.length; node++) {
            if (visited[node]) {
                continue;
            }
            hasCycle = findCycle(node, edges, visited, inCallStack);
            if (hasCycle) {
                return true;
            }
        }
        return hasCycle;
    }

    private boolean findCycle(int node, int[][] edges, boolean[] visited, boolean[] inCallStack) {
        visited[node] = true;
        inCallStack[node] = true;
        int[] neighbours = edges[node];
        boolean hasCycle = false;
        for (int neighbourNode : neighbours) {
            if (visited[neighbourNode] && inCallStack[neighbourNode]) {
                return true;
            }
            hasCycle = findCycle(neighbourNode, edges, visited, inCallStack);
            if (hasCycle) {
                return true;
            }
        }
        inCallStack[node] = false;
        return hasCycle;
    }
}
