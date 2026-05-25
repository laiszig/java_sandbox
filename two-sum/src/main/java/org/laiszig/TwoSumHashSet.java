package org.laiszig;

import java.util.Arrays;
import java.util.HashSet;

// O(n)
public class TwoSumHashSet {

    public static int[] findTwoSum(int[] arr, int target){
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            if(set.contains(complement)){
                return new int[]{arr[i], complement};
            }
            set.add(arr[i]);
        }
        return new int[0];
    }

    static void main() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        System.out.println(Arrays.toString(findTwoSum(nums, target)));
    }
}
