package leetcode.problem.medium.binarytree;

/**
 * @author : yuanqi
 * @since : 2021/1/22
 */
public class Connect {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        connect(root.left, root.right);
        return root;
    }

    public void connect(Node nodeLeft, Node nodeRight) {
        if (nodeLeft == null && nodeRight == null) {
            return;
        }
        nodeLeft.next = nodeRight;
        connect(nodeLeft.left, nodeLeft.right);
        connect(nodeRight.left, nodeRight.right);
        connect(nodeLeft.right, nodeRight.left);
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}

