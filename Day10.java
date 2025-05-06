// Root to Leaf Paths


class Solution {
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> currentPath = new ArrayList<>();
        dfs(root, currentPath, result);
        return result;
    }
    private static void dfs(Node node, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> result) {
        if (node == null) {
            return;
        }
        path.add(node.data);
        if (node.left == null && node.right == null) {
            result.add(new ArrayList<>(path));  
        } else {
            dfs(node.left, path, result);
            dfs(node.right, path, result);
        }
        path.remove(path.size() - 1);
    }
}