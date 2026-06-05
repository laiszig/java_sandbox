package org.laiszig;

import java.util.Arrays;

public class VisiblePersonCountNaive {
    static void main() {

        int[] arr = {11,19,12,15,14,18,7,1,8,9};
        // Output: [1,3,1,2,1,3,2,1,1,0]
        int[] result = canSeePersonCount(arr);
        System.out.println(Arrays.toString(result));
    }

    private static int[] canSeePersonCount(int[] arr) {
        int[] seeCount = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int lastSeen = 0;
            for (int j = i + 1; j < arr.length; j++) {
                if (lastSeen < arr[j]) {
                    seeCount[i] = seeCount[i] + 1;
                }
                if (arr[j] > arr[i]) {
                    break;
                }
                if (lastSeen < arr[j]) {
                    lastSeen = arr[j];
                }
            }
        }
        return seeCount;
    }
}
