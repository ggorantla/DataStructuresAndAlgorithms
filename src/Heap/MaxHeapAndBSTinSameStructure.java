package Heap;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by ggorantla on 10/25/2015.
 */
public class MaxHeapAndBSTinSameStructure {
    public static void main(String[] args) {
        List<Node> inputforfun = new ArrayList<>();
        for (int i =0; i < 10; i++){
            inputforfun.add(new Node((int) (30 * Math.random()), (int) (30* Math.random())   ));
        }

        //for (Node x: inputforfun){
        //    System.out.println(x);
        //}
        //System.out.print("Calling the function  :");
        Node result = MaxHeapAndBinarySearchTree(inputforfun);
        printNice(result);

    }

    private static Node MaxHeapAndBinarySearchTree(List<Node> inputforfunction){
        if (inputforfunction.size() ==0)
            return null;
        // Initialize the first element to head
        Node head = inputforfunction.get(0);
        // Iterate from 1 to N and get the max
        for (int i = 0; i < inputforfunction.size(); i++){
            if (head.heapvalue < inputforfunction.get(i).heapvalue)
                head = inputforfunction.get(i);
        }
        //System.out.println(head.heapvalue);
        // Head removed from the list
        inputforfunction.remove(head);
        // separate lefts and rights
        List<Node> leftside = new ArrayList<>();
        List<Node> rightside = new ArrayList<>();
        for (Node x : inputforfunction){
            if(x.treevalue <= head.treevalue ){
                leftside.add(x);
            }else{
                rightside.add(x);
            }
        }
        //System.out.print(leftside.size());
        //System.out.println("*********************");
        //System.out.print(rightside.size());
        head.leftNode = MaxHeapAndBinarySearchTree(leftside);
        head.rightNode = MaxHeapAndBinarySearchTree(rightside);
        return head;
    }

    public static void printNice(Node root)
    {
        if (root == null)
            return;
        else
        {
            System.out.print("(" + root.heapvalue + "," + root.treevalue + ")");
            if (root.leftNode != null)
            {
                System.out.print("L->[");
                printNice(root.leftNode);
                System.out.print("]");
            }
            if (root.rightNode != null)
            {
                System.out.print("R->[");
                printNice(root.rightNode);
                System.out.print("]");
            }
        }
    }
}
class Node{
    public int heapvalue;
    public int treevalue;
    public Node leftNode;
    public Node rightNode;
    public Node(int x, int y){
        heapvalue = x;
        treevalue = y;
    }
    public String toString(){
        return String.valueOf(this.heapvalue) +": :" + String.valueOf(this.treevalue);

    }
}
