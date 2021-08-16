package com.revature.solutions;

import java.util.*;

public class POWeek3 {

    public List<String> bucketize(String str, int size) {
        //turn the sentence into a queue of words
        Queue<String> queue = new ArrayDeque<>(Arrays.asList(str.split(" ")));

        //create a new array of the answer
        List<String> answer = new ArrayList<>();

        //create a variable here to keep track of the length of the current word
        int x = 0;

        //create a StringBuilder to append spaces to words
        StringBuilder sb = new StringBuilder();

        while(!queue.isEmpty()) {
            String word = queue.peek(); //peek next word

            if(word.length() >= size) { //prevent a potential infinite loop
                System.out.println("This won't work with words that are too big");
                return new ArrayList<>();
            }

            if(word.length() + x < size) {
                if(sb.length() > 0) { //if we can fit the next word inside the current string, do so
                    sb.append(" ").append(word);
                    x += word.length() + 1;
                } else {
                    sb.append(word);
                    x += word.length();
                }
                queue.poll(); //if we do fit a word in, remove it from the queue
            } else { //otherwise, add that word (or string of words) to the list
                answer.add(sb.toString());
                sb.delete(0, sb.length()); //flush the string builder
                x = 0; //set our counter back to 0
            }
        }
        answer.add(sb.toString()); //grab the last string from the loop
        return answer;
    }
}
