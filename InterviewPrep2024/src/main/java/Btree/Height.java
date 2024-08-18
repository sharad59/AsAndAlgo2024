package Btree;

public class Height {

   public int height(Node node){
        if(node ==null)return 0;

        int lh=height(node.left);
        int rh=height(node.right);

        return Math.max(lh,rh)+1;

    }

    public static void main(String[] args) {
        // Example usage:
        // Construct a binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        // Find and print the height of the binary tree
        int height1 = new Height().height(root);
        System.out.println("Height of the binary tree is: " + height1);
    }
}
