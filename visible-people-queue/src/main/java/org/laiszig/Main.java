package org.laiszig;

import java.util.Arrays;

public class Main {
    static void main() {

        int[] arr = {10, 6, 8, 5, 11, 9};
        // Output: [3,1,2,1,1,0]
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
                    System.out.println(arr[j]);
                }
                if (arr[j] > arr[i]) {
                    break;
                }
                lastSeen = arr[j];
            }
        }
        return seeCount;
    }
}
