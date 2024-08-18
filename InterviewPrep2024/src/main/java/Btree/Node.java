package Btree;

public class Node {
    public Node left;
	public Node right;
    public int key;

Node(int item){
    key=item;
    left=null;
    right=null;
}
}
