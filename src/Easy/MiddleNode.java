package Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MiddleNode {

    /* You are given a Linked List with at least one node. Write a function that returns the middle node of Linked List.
     * If there are two middle nodes ( i.e. an even length list), your function should return the second of these nodes.
     *
     * Each LinkedList node has an integer value as well as a next node pointing to the next node in the list or to
     * None / null if it's the tail of the list*/

    public static void main(String[] args) {
        LinkedList input = new LinkedList(1);
        addMany(input, new ArrayList<Integer>(Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10)));

        LinkedList result = middleNodeA(input);
        LinkedList result2 = middleNodeB(input);

        System.out.println("---- First Method: iteration  ----");
        System.out.println(result.value);
        System.out.println("---- Second Method: Pointers ----");
        System.out.println(result.value);
    }

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }
    // O(n) time -> iterating through the array once, even as there is another loop, it is not nested loop, and therefore it's not n^2
    // O(1) space -> space
    public static LinkedList middleNodeA(LinkedList linkedList) {
        int length = 0;

        // Saving the initial node
        LinkedList currentNode = linkedList;

        // iterating through all nodes to get the length of the list
        while(currentNode != null){
            length += 1;
            currentNode = currentNode.next;
        }

        // Creating the list that will hold the middle node
        LinkedList middleNode = linkedList;

        // knowing the length iterating through initial list to the middle of the list, saving desired node
        for(int i = 0; i < length / 2; i++){
            middleNode = middleNode.next;
        }
        return middleNode;
    }

    // Second solution using slow and fast nodes, or pointers
    // O(n) time | O(1) space - where n is the number of nodes in linked list
    public static LinkedList middleNodeB(LinkedList linkedList) {
        LinkedList slowNode = linkedList;
        LinkedList fastNode = linkedList;

        // fast node updates its value to the node two jumps away, it will reach end when
        // slow node is exactly in the middle, then we return the slow node
        while(fastNode != null && fastNode.next != null){
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }

        return null;
    }

    // Helper function to quickly add more nodes
    public static LinkedList addMany(LinkedList ll, List<Integer> values) {
        LinkedList current = ll;
        while (current.next != null) {
            current = current.next;
        }
        for (int value : values) {
            current.next = new LinkedList(value);
            current = current.next;
        }
        return ll;
    }
}
