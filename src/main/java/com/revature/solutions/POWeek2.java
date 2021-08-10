package com.revature.solutions;

import java.util.ArrayDeque;

public class POWeek2 {

    /*
        Logical reasoning:

        My answer is b) the data in II. alone is sufficient to answer the question.

        If we know that the 17th was a Saturday, then we simply go back three days, and
        arrive at Wednesday which is the 14th.

        The data in statement I is not enough to answer the question as we don't know which month it is,
        so we don't know how many days are in that month.
     */

    public void printLevels(Node root) {
        // if I only have to print the level order, I don't have to write a recursive function for this. I can use
        // a queue instead.

        // declare our queue to schedule the next nodes to explore
        final ArrayDeque<Node> queue = new ArrayDeque<>();

        //declare our list of numbers (I also could just print out the queue nodes as I find them
        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        queue.add(root);

        //for every iteration, print the value of the node, then add the left and right nodes to the queue in order to be printed.
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            numbers.add(node.val);
            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
        }
        numbers.forEach(System.out::println);
    }

    //Classic node implementation. A value, a left node and a right node.
    public static class Node {
        public Node left;
        public Node right;
        public int val;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}