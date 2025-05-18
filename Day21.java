// Level Order in spiral form

class Solution {
    public ArrayList<Integer> findSpiral(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = false;

        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> level = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                Node current = queue.poll();

                if (leftToRight) {
                    level.addLast(current.data);
                } else {
                    level.addFirst(current.data);
                }

                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }

            result.addAll(level);
            leftToRight = !leftToRight;
        }

        return result;
    }
}
