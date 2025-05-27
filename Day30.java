// Print leaf nodes from preorder traversal of BST

class Solution {
    public ArrayList<Integer> leafNodes(int[] preorder) {
        ArrayList<Integer> leafNodes = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int n = preorder.length;

        for (int i = 0; i < n - 1; i++) {
            boolean found = false;

            if (preorder[i] > preorder[i + 1]) {
                // It's a left child, so push to stack
                stack.push(preorder[i]);
            } else {
                // It's a right child, find the ancestor
                while (!stack.isEmpty() && preorder[i + 1] > stack.peek()) {
                    stack.pop();
                    found = true;
                }
                if (found) {
                    leafNodes.add(preorder[i]);
                }
            }
        }

        // Last node is always a leaf
        leafNodes.add(preorder[n - 1]);

        return leafNodes;
    }
}