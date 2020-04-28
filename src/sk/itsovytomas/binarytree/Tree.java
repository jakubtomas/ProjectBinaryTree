package sk.itsovytomas.binarytree;

import java.util.ArrayList;
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


    public Node getParent(Node node) {
        if (node == root) {
            return null;
        }

        Node akt = root;
        while (akt != null) {
            if (akt.getLeft() == node)
                return akt;
            if (akt.getRight() == node)
                return akt;
            if (akt.getKey() > node.getKey())
                akt = akt.getLeft();
            else
                akt = akt.getRight();

        }
        return null;
    }


    public void remove(Node node) {
        // 1 moznost , node je list:
        if (node.isLeaf()) {
            Node parent = getParent((node));
            if (parent == null)
                return;
            if (parent.getLeft() == node)
                parent.setLeft(null); // left null
            else
                parent.setRight(null); // right null
            return;
        }

        // node ma jedneho potomka - praveho
        if (node.getLeft() == null && node.getRight() != null) {
            Node parent = getParent(node);
            if (parent == null)
                return;

            if (parent.getLeft() == node) { // is node left child my parent
                parent.setLeft(node.getRight()); // true set left parent to node right child

            } else // node is right child our parent , set parent right child to node right child
                parent.setRight(node.getRight());
        }

        // node ma jedneho potomka - lavy


        if (node.getLeft() != null && node.getRight() == null) {
            Node parent = getParent(node);
            if (parent == null)
                return;

            if (parent.getLeft() == node) {
                parent.setLeft(node.getLeft());

            } else
                parent.setRight(node.getLeft());
        }


        // node ma dvoch potomkov laveho a praveho
        if ((node.getLeft() != null) && (node.getRight() != null)) {


            // when node is root ROOT TRUE
            if (node == root) {
                //
                Node minRightNode = node.getMinRightNode();
                minRightNode.setLeft(node.getLeft());   // set left
                minRightNode.setRight(node.getRight()); // set right


                // when mingrighnode have the right child we have to change parent set left
                if (minRightNode.getRight() != null) {
                    // search minrighnode parent and set left
                    Node parentMinR = getParent(minRightNode);

                    parentMinR.setLeft(minRightNode.getRight());

                }

                node.setLeft(null);
                node.setRight(null);

            } else { // node isnt ROOT

                // question Where is node which I would like to delete,  is on the left side or right side

                // left side
                if (node == getParent(node).getLeft()) {
                    //minRight is right child node which we delete

                    Node minRightNode = node.getMinRightNode();
                    Node parentNode = getParent(node);

                    if (node.getRight() == minRightNode) {

                        parentNode.setLeft(minRightNode);

                        minRightNode.setLeft(node.getLeft());

                    } else if (node.getRight() != minRightNode) {

                        if (minRightNode.getRight() != null) {
                            getParent(minRightNode).setLeft(minRightNode.getRight());
                        }


                        parentNode.setLeft(minRightNode);

                        minRightNode.setLeft(node.getLeft());

                        minRightNode.setRight(node.getRight());


                    }
                    node.setLeft(null);
                    node.setRight(null);


                } else if (node == getParent(node).getRight()) {
                    Node minRightNode = node.getMinRightNode();
                    Node parentNode = getParent(node);

                    if (minRightNode == node.getRight()) {
                        parentNode.setRight(minRightNode);
                        minRightNode.setLeft(node.getLeft());


                    } else if (minRightNode != node.getRight()) {
                        parentNode.setRight(minRightNode);

                        if (minRightNode.getRight() != null) {
                            getParent(minRightNode).setLeft(minRightNode.getRight());

                        }

                        minRightNode.setLeft(node.getLeft());
                        minRightNode.setRight(node.getRight());

                    }

                    node.setLeft(null);
                    node.setRight(null);
                }
            }


        }


    }


    public List<Node> getListOfLeafs() {

     /*   if (root != null) {
            root.inOrder();
        }*/
        // use the function in order and every node check that have min 1 child
        // left or right if no push into List and


        List<Node> list = new ArrayList<>();
        getListOfLeafsRec(root, list);
        return list;


    }

    private void getListOfLeafsRec(Node node, List<Node> list) {
        if (node.isLeaf())
            list.add(node);
        else {
            if (node.getLeft() != null)
                getListOfLeafsRec(node.getLeft(), list);
            if (node.getRight() != null)
                getListOfLeafsRec(node.getRight(), list);
        }
    }


    public int getHeight() {
        // kolko krat sa my opakuje cyklus podla toho
        // nezabudni nulovat pomocnu hodnotu

        //


        if (root == null)
            return -1;

        if (root.isLeaf())
            return 0;

        int max = 0;
        max = getHeightRec(-1, max, root);
        return max;

    }


    private int getHeightRec(int i, int max, Node node) {
        i++;
        if (node.isLeaf()) {
            if (i > max)
                max = i;
            return max;
        }
        if (node.getLeft() != null)
            max = getHeightRec(i, max, node.getLeft());
        if (node.getRight() != null)
            max = getHeightRec(i, max, node.getRight());
        return max;
    }


}
