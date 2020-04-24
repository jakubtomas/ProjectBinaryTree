package sk.itsovytomas.binarytree;

import java.util.List;

public class Tree {

    private Node root;

    public Tree(Node root) {
        this.root = root;
    }


    public void addNode(Node node) {
        if (node == null) { // check  if is null do nothing
            return;
        }
        root.addChild(node);
    }

    public void printInOrder() {
        if (root != null) {
            root.inOrder();
        }
    }

    public void printPreOrder() {
        if (root != null) {
            root.preOrder();
        }
    }

    public void printPostOrder() {
        if (root != null) {
            root.postOrder();
        }
    }

    public String getValue(int key) {

        Node akt = root; // help value

        while (akt != null) {

            // when current key equal key from root  return value from root
            if (akt.getKey() == key) {
                return akt.getValue();
            }

            // compare key values and go left or right
            if (akt.getKey() > key) {
                akt = akt.getLeft();
            } else {
                akt = akt.getRight();
            }

        }
        return null;
    }

    public boolean containsKey(int key) {
         // check  that we have node with input int key
        // When we have  return true when no return false

        Node akt = root; // help value

        while (akt != null) {

            // when current key equal key from root  return  true
            if (akt.getKey() == key) {
                return true;
            }

            // compare key values and go left or right
            if (akt.getKey() > key) {
                akt = akt.getLeft();
            } else {
                akt = akt.getRight();
            }

        }

        return false;
    }



    public Node getParent(Node node){
        if(node==root){
            return null;
        }

        Node akt = root;
        while(akt!=null){
            if(akt.getLeft() ==node)
                return akt;
            if(akt.getRight() ==node)
                return akt;
            if(akt.getKey()>node.getKey())
                akt=akt.getLeft();
            else
                akt=akt.getRight();

        }
        return null;
    }


    public void remove (Node node){
        // 1 moznost , node je list:
        if(node.isLeaf()){
            Node parent = getParent((node));
            if(parent == null)
                return ;
            if(parent.getLeft()==node)
                parent.setLeft(null); // left null
            else
                parent.setRight(null); // right null
            return;
        }

        // node ma jedneho potomka - praveho
        if(node.getLeft()==null && node.getRight()!=null){
            Node parent = getParent(node);
            if(parent==null)
                return;

            if(parent.getLeft()==node){ // is node left child my parent
                parent.setLeft(node.getRight()); // true set left parent to node right child

            }
            else // node is right child our parent , set parent right child to node right child
                parent.setRight(node.getRight());
        }

        // node ma jedneho potomka - lavy


        if(node.getLeft()!=null && node.getRight()==null){
            Node parent = getParent(node);
            if(parent==null)
                return;

            if(parent.getLeft()==node){
                parent.setLeft(node.getLeft());

            }
            else
                parent.setRight(node.getLeft());
        }


        // node ma dvoch potomkov laveho a praveho
        if ((node.getLeft() != null) && (node.getRight() != null)) {
            Node parent = getParent(node);

            if (parent == null) {
                return; /// ked je parent null aj tak by sa mal spravit bez
                // použitia parentu
            }


        }

    }


    public List<Node> getListOfLeafs() {

     /*   if (root != null) {
            root.inOrder();
        }*/
    // use the function in order and every node check that have min 1 child
        // left or right if no push into List and
        return null;

    }
    public int getHeight(){
        // kolko krat sa my opakuje cyklus podla toho
        // nezabudni nulovat pomocnu hodnotu

        //
        return -1;
    }








}
