// Maximum sum of Non-adjacent nodes

class Solution {
    
    class Pair {
        int include;
        int exclude;

        Pair(int include, int exclude) {
            this.include = include;
            this.exclude = exclude;
        }
    }

    public int getMaxSum(Node root) {
        Pair result = dfs(root);
        return Math.max(result.include, result.exclude);
    }

    private Pair dfs(Node node) {
        if (node == null) {
            return new Pair(0, 0);
        }

        Pair left = dfs(node.left);
        Pair right = dfs(node.right);

        int include = node.data + left.exclude + right.exclude;
        int exclude = Math.max(left.include, left.exclude) + Math.max(right.include, right.exclude);

        return new Pair(include, exclude);
    }
}
