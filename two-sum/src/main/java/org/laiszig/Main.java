package org.laiszig;

/*
Two sum
Exemplo Prático
Entrada: nums = [2, 7, 11, 15] e target = 9
Saída esperada: [2, 7]
Explicação: Como nums[0] + nums[1] é igual a 2 + 7 = 9, retornamos os números 2 e 7.
 */
public class Main {
    static void main() {
//        int[] nums = {11, 2, 12, 7};
        int[] nums = {3, 5, 7, 1, 32, 11, 97, 100};
        int target = 9;
        int sum = 0;
        int last = nums.length-1;

        for (int num : nums) {
            sum = nums[last] + num;
            if (sum == target) {
                break;
            }
            sum = 0;
        }
        System.out.println("Sum: " + sum);

    }
}
