package Easy;

import org.testng.annotations.Test;
import org.testng.internal.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveDuplicates {

    public static void main(String[] args) {
        /* You're given the head of Singly Linked List whose nodes are in sorted order with respect to their values.
         *  Write a function that returns modified version of the Linked List that doesn't contain any nodes with
         *  duplicate values. The Linked List should be modified in place (i.e., you shouldn't create a brand-new list),
         *  and the modified Linked List should still have its nodes sorted with respect to their values.
         *
         * Each LinkedList node has an integer value as well as a next node pointing to the next node in the list or to
         * None / null if it's the tail of the list.
         *
         * Sample input
         * linkedList = 1 -> 1 -> 3 -> 4 -> 4 -> 4 -> 5 -> 6 -> 6 ... the head node with value 1
         *
         * Sample Output
         * 1 -> 3 -> 4 -> 5 -> 6 */

        LinkedList input = new LinkedList(1);
        addMany(input, new ArrayList<Integer>(Arrays.asList(1, 3, 4, 4, 4, 5, 6, 6)));
        List<Integer> expectedNodes = new ArrayList<Integer>(Arrays.asList(1, 3, 4, 5, 6));

        System.out.println(input.next.next.value);
        System.out.println(input.next.next.next.value);

        LinkedList result = removeDuplicatesFromLinkedList(input);

        // Loop to iterate through nodes and check result.
        while(result != null){
            System.out.println(result.value);
            result = result.next;
        }
    }

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {

        LinkedList currentNode = linkedList;
        while(currentNode != null){
            LinkedList nextDistinctNode = currentNode.next;
            while(nextDistinctNode != null && nextDistinctNode.value == currentNode.value){
                nextDistinctNode = nextDistinctNode.next;
            }
            currentNode.next = nextDistinctNode;
            currentNode = nextDistinctNode;
        }

        return linkedList;
    }


    // a helper method that allows to add many nodes to the list
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
