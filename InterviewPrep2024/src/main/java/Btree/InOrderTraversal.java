package Btree;

public class InOrderTraversal {

   void print(Node node){
       if(node==null){
           return;
       }
       print(node.left);
       System.out.print(node.key+" ");
       print(node.right);
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


        InOrderTraversal a=new InOrderTraversal();
        a.print(root);
    }
}
