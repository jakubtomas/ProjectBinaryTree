package sk.itsovytomas.binarytree;

import static org.junit.jupiter.api.Assertions.*;

class TreeTest {

    private Tree myTree = new Tree(new Node(20, "HTTP protocol"));

    private Node node1 = new Node(5, "Node JS");
    private Node node2 = new Node(10, "Java");
    private Node node3 = new Node(8, "Delphi");
    private Node node4 = new Node(23, "JavaScript");
    private Node node5 = new Node(30, "Pascal");
    private Node node6 = new Node(29, "C++");
    private Node node7 = new Node(22, "HTML 5");
    private Node node8 = new Node(4, "PHP");
    private Node node11 = new Node(-5555, "");

    @org.junit.jupiter.api.BeforeEach
    void setUp() {


        myTree.addNode(node1);
        myTree.addNode(node2);
        myTree.addNode(node3);
        myTree.addNode(node4);
        myTree.addNode(node5);
        myTree.addNode(node6);
        myTree.addNode(node7);
        myTree.addNode(node8);
        myTree.addNode(node11);

        System.out.println();
        System.out.println("in order");
        myTree.printInOrder();

    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void addNode() {
        Node node9 = new Node(88, "osemdesat osem");
        Node node10 = new Node(99, "devet devet ");
        Node node11 = new Node(-5555, "");

        //add new 2 node
        myTree.addNode(node9);
        myTree.addNode(node10);
        myTree.addNode(node11);
        myTree.printInOrder();

        // check that we  the tree have this node
        assertTrue(myTree.containsKey(88));
        assertTrue(myTree.containsKey(99));
        assertTrue(myTree.containsKey(-5555));
        assertFalse(myTree.containsKey(5555));


        assertFalse(myTree.containsKey(68));
        assertFalse(myTree.containsKey(159));
        assertFalse(myTree.containsKey(-159));
        assertFalse(myTree.containsKey(55));


        // remove node and check this node and also other nodes
        myTree.remove(node9);
        assertFalse(myTree.containsKey(88));
        assertTrue(myTree.containsKey(99));

        //remove node 10 and check this node and also other nodes we have
        myTree.remove(node10);
        assertFalse(myTree.containsKey(99));
        assertTrue(myTree.containsKey(5));
        assertTrue(myTree.containsKey(10));
        assertTrue(myTree.containsKey(8));
        assertTrue(myTree.containsKey(23));

        assertFalse(myTree.containsKey(0));
        assertFalse(myTree.containsKey(999999999));
        assertFalse(myTree.containsKey(-1000000));
        assertFalse(myTree.containsKey(-1000000999));
        // what  is result when is input null or empty or no int ???
        // set root left and right node to null


    }

    @org.junit.jupiter.api.Test
    void getValue() {
        assertEquals("PHP", myTree.getValue(4));
        assertEquals("C++", myTree.getValue(29));
        assertEquals("HTTP protocol", myTree.getValue(20));
        assertEquals("Java", myTree.getValue(10));
        assertEquals("Delphi", myTree.getValue(8));
        assertEquals("JavaScript", myTree.getValue(23));
        assertEquals("Pascal", myTree.getValue(30));
        assertEquals("HTML 5", myTree.getValue(22));

        assertEquals("", myTree.getValue(-5555));

        node1.setValue("Cube");
        assertEquals("Cube", myTree.getValue(5));

        myTree.remove(node5);

        assertNull(myTree.getValue(30));
        assertNull(myTree.getValue(556565));
        assertNull(myTree.getValue(-10556565));

    }
    /*    Node node1 = new Node (5, "Node JS");
        Node node2 = new Node (10, "Java");
        Node node3 = new Node (8, "Delphi");
        Node node4 = new Node (23, "JavaScript");
        Node node5 = new Node (30, "Pascal");
        Node node6 = new Node (29, "C++");
        Node node7 = new Node (22, "HTML 5");
        Node node8 = new Node (4, "PHP");*/

    @org.junit.jupiter.api.Test
    void containsKey() {

        assertTrue(myTree.containsKey(30));
        assertTrue(myTree.containsKey(5));
        assertTrue(myTree.containsKey(10));
        assertTrue(myTree.containsKey(8));
        assertTrue(myTree.containsKey(23));
        assertTrue(myTree.containsKey(29));
        assertTrue(myTree.containsKey(22));
        assertTrue(myTree.containsKey(4));

        assertFalse(myTree.containsKey(55555));
        assertFalse(myTree.containsKey(0));
        assertFalse(myTree.containsKey(-5959));

        myTree.remove(node2);// 10 string java
        myTree.remove(node3);// 8 string javaScript
        myTree.remove(node4);// 23 string Pascal
        assertFalse(myTree.containsKey(10));
        assertFalse(myTree.containsKey(8));
        //  assertFalse(myTree.containsKey(23));

        Node node99 = new Node(10, "Java");
        myTree.addNode(node99);
        assertTrue(myTree.containsKey(10));


    }

    @org.junit.jupiter.api.Test
    void getParent() {
        assertEquals(20, myTree.getParent(node1).getKey());
        assertEquals(20, myTree.getParent(node4).getKey());
        assertEquals(5, myTree.getParent(node2).getKey());
        assertEquals(5, myTree.getParent(node8).getKey());
        assertEquals(10, myTree.getParent(node3).getKey());
        assertEquals(23, myTree.getParent(node7).getKey());
        assertEquals(23, myTree.getParent(node5).getKey());
        assertEquals(30, myTree.getParent(node6).getKey());

        myTree.remove(node5);// delete 30
        assertEquals(23, myTree.getParent(node6).getKey());

        myTree.remove(node6);
        myTree.remove(node4);
        assertEquals(20, myTree.getParent(node7).getKey());

        myTree.remove(node2);
        assertEquals(5, myTree.getParent(node3).getKey());

        myTree.remove(node8);
        assertEquals(5, myTree.getParent(node11).getKey());

        myTree.remove(node11);
        myTree.remove(node1);
        assertEquals(20, myTree.getParent(node3).getKey());


    }

    @org.junit.jupiter.api.Test
    void remove() {

        myTree.remove(node6);// delete 29
        assertNull(myTree.getValue(29));
        assertNull(node5.getLeft());
        assertNull(node5.getRight());

        assertEquals(22, node4.getLeft().getKey());

        myTree.remove(node7);
        assertNull(node4.getLeft());

        assertEquals(10, node1.getRight().getKey());
        assertEquals(4, node1.getLeft().getKey());

        assertEquals(10, myTree.getParent(node3).getKey());
        myTree.remove(node2);
        assertEquals(5, myTree.getParent(node3).getKey());

        assertEquals(8, node1.getRight().getKey());
        assertEquals(4, node1.getLeft().getKey());


        assertEquals(5, myTree.getParent(node8).getKey());
        myTree.remove(node8);
        assertNull(myTree.getParent(node8));
        assertEquals(5, myTree.getParent(node11).getKey());
        assertEquals(-5555, node1.getLeft().getKey());



        ////////////////////////////////////////////////////////////////////


        // first test delete node which is on the left side parent and
        // minnode dosnt have right child and isnt right child deleted node


        /*  myTree.remove(node1);

        assertEquals(10,node3.getRight().getKey());
        assertEquals(4,node3.getLeft().getKey());
        assertEquals(20,myTree.getParent(node3).getKey());

        assertNull(node1.getLeft());
        assertNull(node1.getRight());
      */


        //////////////////////////////////////////////////////////////////////





        // min right is right child  delete node  without right child

      /*      myTree.remove(node3);
            myTree.remove(node1);

        assertNull(node2.getRight());
        assertEquals(4,node2.getLeft().getKey());
        assertEquals(20,myTree.getParent(node2).getKey());

        assertNull(node1.getLeft());
        assertNull(node1.getRight());

        assertNull(node3.getLeft());
        assertNull(node3.getRight());
*/




        //////////////////////////////////////////////////////////

       // min right is right child  delete node  with right child

       /* Node node12 = new Node(11, "jedenast");

        myTree.addNode(node12);
        myTree.remove(node3);
        myTree.remove(node1);

        assertEquals(11,node2.getRight().getKey());
        assertEquals(4,node2.getLeft().getKey());
        assertEquals(20,myTree.getParent(node2).getKey());

        assertNull(node1.getLeft());
        assertNull(node1.getRight());

        assertNull(node3.getLeft());
        assertNull(node3.getRight());*/

        /////////////////////////////////////////////////////////////////

        // remove node which is right child parent and minright isnt
        //right child deleted node and dosnt have the right child


      /*  myTree.remove(node4);

        assertEquals(22, node6.getLeft().getKey());
        assertEquals(30, node6.getRight().getKey());
        assertEquals(20, myTree.getParent(node6).getKey());

        assertNull(node4.getRight());
        assertNull(node4.getLeft());
*/

    }

    @org.junit.jupiter.api.Test
    void getListOfLeafs() {
        System.out.println("list  " + myTree.getListOfLeafs().get(0).getKey());

        assertEquals(-5555, myTree.getListOfLeafs().get(0).getKey());
        assertEquals(8, myTree.getListOfLeafs().get(1).getKey());
        assertEquals(22, myTree.getListOfLeafs().get(2).getKey());
        assertEquals(29, myTree.getListOfLeafs().get(3).getKey());

        myTree.remove(node6);
        assertEquals(30, myTree.getListOfLeafs().get(3).getKey());

        myTree.remove(node3);
        assertEquals(10, myTree.getListOfLeafs().get(1).getKey());


    }

    @org.junit.jupiter.api.Test
    void getHeight() {

        assertEquals(3, myTree.getHeight());
        Node node12 = new Node(28, "node12");
        myTree.addNode(node12);

        assertEquals(4, myTree.getHeight());

        Node node13 = new Node(27, "node13");
        myTree.addNode(node13);
        assertEquals(5, myTree.getHeight());


        myTree.remove(node13);
        myTree.remove(node12);
        myTree.remove(node6);

        assertEquals(3, myTree.getHeight());


        myTree.remove(node11);
        myTree.remove(node3);
        assertEquals(2, myTree.getHeight());

        myTree.remove(node8);
        myTree.remove(node2);
        myTree.remove(node7);
        myTree.remove(node5);
        assertEquals(1, myTree.getHeight());

        myTree.remove(node1);
        assertEquals(1, myTree.getHeight());

        myTree.remove(node4);
        assertEquals(0, myTree.getHeight());

        myTree.addNode(node12);
        assertEquals(1, myTree.getHeight());
    }
}