package org.laiszig;

import java.util.Arrays;

// O(n × log(n))
public class TwoSumBinarySearch {
    static int binarySearch(int[] arr, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return arr[mid];
            }
            if (arr[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return Integer.MIN_VALUE;
    }

    public static int[] findTwoSum (int[] arr, int target){
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];

            int found = binarySearch(arr, i + 1, arr.length - 1, complement);
            if (found != Integer.MIN_VALUE) {
                return new int[]{arr[i], found};
            }
        }
        return new int[0];
    }

    static void main() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        System.out.println(Arrays.toString(findTwoSum(nums, target)));
    }
}
