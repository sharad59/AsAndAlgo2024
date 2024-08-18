package Btree;

import java.util.LinkedList;
import java.util.Queue;

public class HeightQueue {


    static Node newNode(int key)
    {
        Node temp = new Node(key);
        return temp;
    }

    public static int height(Node root)
    {

        int depth = 0;

        Queue<Node> q = new LinkedList<>();

        q.add(root);
        q.add(null);
        while (!q.isEmpty()) { 
            Node temp = q.poll();

            if (temp == null) {
                depth++;
            }

            if (temp != null) {
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
            else if (!q.isEmpty()) {
                q.add(null);
            }
        }
        return depth;
    }

    public static void main(String args[])
    {
        Node root = newNode(1);
        root.left = newNode(2);
        root.right = newNode(3);

        root.left.left = newNode(4);
        root.left.right = newNode(5);

        System.out.println("Height(Depth) of tree is: "
                + height(root));
    }
}

