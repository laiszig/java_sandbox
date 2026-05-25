package org.laiszig;

import java.util.Arrays;

/*
Two sum
Exemplo Prático
Entrada: nums = [2, 7, 11, 15] e target = 9
Saída esperada: [2, 7]
Explicação: Como nums[0] + nums[1] é igual a 2 + 7 = 9, retornamos os números 2 e 7.
 */
// O(n^2)
public class TwoSumNaive {
    static void main() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        findTwoSum(nums, target);
    }

    public static int[] findTwoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int[] result = new int[2];
            int sum;
            for (int j = i + 1; j < nums.length; j++) {
                sum = nums[i] + nums[j];
                System.out.println(sum);
                if (sum == target) {
                    result[0] = nums[i];
                    result[1] = nums[j];
                    System.out.println(Arrays.toString(result));
                    return result;
                }
            }
        }
        System.out.println("Two sum target not found.");
        return null;
    }

}
