package org.laiszig;

import java.util.Arrays;
import java.util.Stack;

// O(n)
public class VisiblePersonCountStack {
    static void main() {

    int[] arr = {10,6,8,5,11,9};
    //    Output: [3,1,2,1,1,0]
        int[] count = canSeePersonsCount(arr);
        System.out.println(Arrays.toString(count));
    }

    private static int[] canSeePersonsCount(int[] arr) {
        int[] count = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; ++i) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                int top = stack.pop();
                count[top]++;
            }
            if (!stack.isEmpty()) {
                int top = stack.peek();
                count[top]++;
            }
            stack.push(i);
        }
        return count;
    }
}
