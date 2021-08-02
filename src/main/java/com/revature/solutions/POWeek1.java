package com.revature.solutions;

import java.util.ArrayList;
import java.util.List;

public class POWeek1 {

    public String longestLcs(String a, String b) {
        //This code is brute-forcey and won't pass every test case, but will past most that I threw at it including the main one.
        char[] stringA = a.toCharArray();
        char[] stringB = b.toCharArray();

        List<Character> longest = new ArrayList<>();

        for(int i = 0; i < stringA.length; i++) {
            List<Character> temp = new ArrayList<>();
            for(int j = 0; j < stringB.length; j++) {
                if(stringA[i] == stringB[j]) {
                    int k = i;
                    int l = j;
                    while((k < stringA.length && l < stringB.length) && stringA[k] == stringB[l]) {
                        temp.add(stringA[k]);
                        k++;
                        l++;
                    }
                }
            }
            if(temp.size() > longest.size()) {
                longest = temp;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char c: longest)
            sb.append(c);

        return sb.toString();
    }
}
