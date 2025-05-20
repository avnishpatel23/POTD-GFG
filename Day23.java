// Burning Tree

class Solution {
    private static void mapParents(Node root, Map<Node, Node> parentMap, Map<Integer, Node> nodeMap) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        nodeMap.put(root.data, root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.left != null) {
                parentMap.put(current.left, current);
                nodeMap.put(current.left.data, current.left);
                queue.add(current.left);
            }

            if (current.right != null) {
                parentMap.put(current.right, current);
                nodeMap.put(current.right.data, current.right);
                queue.add(current.right);
            }
        }
    }

    public static int minTime(Node root, int target) {
        if (root == null) return 0;

        Map<Node, Node> parentMap = new HashMap<>();
        Map<Integer, Node> nodeMap = new HashMap<>();

        mapParents(root, parentMap, nodeMap);

        Node targetNode = nodeMap.get(target);
        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();

        queue.add(targetNode);
        visited.add(targetNode);

        int time = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean spread = false;

            for (int i = 0; i < size; i++) {
                Node current = queue.poll();

                if (current.left != null && !visited.contains(current.left)) {
                    visited.add(current.left);
                    queue.add(current.left);
                    spread = true;
                }

                if (current.right != null && !visited.contains(current.right)) {
                    visited.add(current.right);
                    queue.add(current.right);
                    spread = true;
                }

                Node parent = parentMap.get(current);
                if (parent != null && !visited.contains(parent)) {
                    visited.add(parent);
                    queue.add(parent);
                    spread = true;
                }
            }

            if (spread) {
                time++;
            }
        }

        return time;
    }
}
