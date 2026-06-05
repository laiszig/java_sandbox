package org.laiszig;

import java.util.Arrays;

// O(n)
// A monotonic stack is a specialized stack data structure that maintains its elements in a specific sorted
// order—either strictly increasing or decreasing—as new data is processed
public class VisiblePersonCountStack2 {

    private static int[] canSeePersonsCount(int[] arr) {
        int n = arr.length;
        Stack stack = new Stack(n);
        int visiblePeople = 0;
        int[] output = new int[n];

        for (int i = n-1; i >= 0; i--) {
            visiblePeople = 0;

            // Count all shorter people we can see to our right
            while(!stack.isEmpty() && stack.peek() < arr[i]) {
                stack.pop();
                visiblePeople++;
            }

            // If stack isn't empty, we can see the next taller person who blocks our view
            if(!stack.isEmpty()) {
                visiblePeople++;
            }

            // Push current height onto the stack for the next people to the left
            stack.push(arr[i]);
            System.out.println(arr[i]);
            output[i] = visiblePeople;
        }
        return output;
    }
}
