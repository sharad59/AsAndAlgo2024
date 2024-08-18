package Btree;

public class PreorderTraversal {

    public void print(Node root){
        if(root==null){
            return;
        }
        System.out.println(root.key);
        print(root.left);
        print(root.right);
    }

    public static void main(String args[])
    {
        Node root= new Node(1);
         root.left=new Node(2);
        root.left.left=new Node(4);
        root.left.right=new Node(5);


        root.right=new Node(3);
        root.right.left=new Node(6);
        root.right.right=new Node(7);


        PreorderTraversal a=new PreorderTraversal();
        a.print(root);
    }
}
