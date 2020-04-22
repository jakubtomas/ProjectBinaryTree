package sk.itsovytomas.binarytree;

public class Main {

    public static void main(String[] args) {
        Tree myTree = new Tree (new Node(20,"HTTP protocol"));
        Node node1 = new Node (5, "Node JS");
        Node node2 = new Node (10, "Java");
        Node node3 = new Node (8, "Delphi");
        Node node4 = new Node (23, "JavaScript");
        Node node5 = new Node (30, "Pascal");
        Node node6 = new Node (29, "C++");
        Node node7 = new Node (22, "HTML 5");
        myTree.addNode(node1);
        myTree.addNode(node2);
        myTree.addNode(node3);
        myTree.addNode(node4);
        myTree.addNode(node5);
        myTree.addNode(node6);
        myTree.addNode(node7);

        System.out.println();
        System.out.println("in order");
        myTree.printInOrder();

        System.out.println();
        System.out.println(" pre order");
        myTree.printPreOrder();

        System.out.println();
        System.out.println(" post order");
        myTree.printPostOrder();

        System.out.println();

        System.out.println("value according to key  " + myTree.getValue(29));

        System.out.println();
        System.out.println(" tree contain the number  " + myTree.containsKey(66));

        System.out.println();
        System.out.println(" return parent " + myTree.getParrent(node3).getKey());
    }
}
