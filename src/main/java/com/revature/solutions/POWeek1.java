package com.revature.solutions;

import java.util.ArrayList;
import java.util.List;

public class POWeek1 {


    /*
        Logic problem:

        I immediately broke down the letters into their own corresponding codes.
        PROCESSOR becomes
        P = D4
        R = F3
        O = C5
        C = C1
        E = E1
        S = S1
        S = S1
        O = E3
        R = C6

        My immediate thought is that there is no such thing as S in hex
        so these aren't hex codes. Also, duplicate letters have different numbers with
        the exception to S which are both S1.

        I then notice that P is the sixteenth letter of the alphabet, while D is the 4th. If I multiply D * 4, I get 16 which is P

        Same with R. F is the 6th letter of the alphabet, multiplied by 3 I get 18, which is the position of R

        Putting this all together, I can represent QUADRANT as:
        Q: Q1
        R: C6
        A: A1
        D: B2
        R: I2
        A: A1
        N: G2
        T: T1
        or Q1C6A1B2I2A1G2E4
     */

    public int missingNumber(int[] arr) {
        //this assumes that there is only one missing number, can easily add multiple results to a list.
        for(int i = 0; i < arr.length - 1; i++) {
            if(arr[i + 1] - arr[i] > 1) {
                return arr[i] + 1;
            }
        }
        return -1; //indicating no missing numbers.
    }


    public void minAndMax(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i: arr) {
            min = Math.min(i, min);
            max = Math.max(i, max);
        }

        System.out.println(max);
        System.out.println(min);
    }

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
