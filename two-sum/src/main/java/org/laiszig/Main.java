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
        int[] nums = {2, 11, 12, 7};
        int target = 9;
        boolean targetFound = false;

        for (int i = 0; i < nums.length; i++) {
            int sum;
            for (int j = i+1; j < nums.length; j++) {
                sum = nums[i] + nums[j];
                System.out.println(sum);

                if (sum == target) {
                    System.out.println(nums[i] + " " + nums[j]);
                    targetFound = true;
                    break;
                }
            }
            if (targetFound) {
                break;
            }
        }
    }

}
