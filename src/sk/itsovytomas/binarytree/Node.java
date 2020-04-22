package sk.itsovytomas.binarytree;

public class Node {

    private int key;
    private String value;

    private Node left;
    private Node right;

    public Node(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public  void  addChild( Node node) {
        if (this.key == node.key) {// key normal node and add node key compare
            this.value = node.value;

        } else if (this.key > node.key) {

            if (this.left == null) {  // if is left node empty add out node to the left position

                this.left = node;
            } else {

                this.left.addChild(node);
            }

        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.addChild(node);
            }
        }


    }

    public void inOrder() { //  write tree left and right control that we have  node

         // Left  Visit right
        if (this.left != null) {
            left.inOrder();

        }
        System.out.println("("+this.key+"): "+ this.value+" ");
        if (this.right != null) {

            right.inOrder();
        }
    }

    public void preOrder() {

        // Visit Left Right
        System.out.println("(" + this.key + "): " + this.value + " ");
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    public void postOrder() {

        //Left Right Visit
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println("(" + this.key + "): " + this.value + " ");
    }



    public boolean isLeaf() { // the last nodes
      ///  pri akej podmienke je je node posledny ked nema potomkov
        return (this.left == null) && (this.right == null);

    }


    //search the smallest value   in the right tree
    // najdi najmensiu hodnotu v pravom podstrome,, decku

    public Node getMinRightNode(){
        if(this.getRight()==null)  // when right child is empty return null
            return null;
        Node akt = this.getRight() ;   // when is no empty set akt to right node

        for(;;){  // cycle ending when nodes left child is null and we know this is the smallest node
            if(akt.getLeft()==null) // when left child is null
                return akt;
            akt=akt.getLeft(); // present node set to left node when is no empty
        }
    }

}
