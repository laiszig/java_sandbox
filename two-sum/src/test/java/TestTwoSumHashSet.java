import org.junit.jupiter.api.Test;
import org.laiszig.TwoSumHashSet;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TestTwoSumHashSet {

    @Test
    void shouldReturn_True() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] twoSum = {7, 2};

        int[] result = TwoSumHashSet.findTwoSum(nums, target);
        assertArrayEquals(result, twoSum);
    }

    @Test
    void middleNum_shouldReturn_True() {
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] twoSum = {4, 2};

        int[] result = TwoSumHashSet.findTwoSum(nums, target);
        assertArrayEquals(result, twoSum);
    }

    @Test
    void sameNumbers_shouldReturn_True() {
        int[] nums = {3, 3};
        int target = 6;
        int[] twoSum = {3, 3};

        int[] result = TwoSumHashSet.findTwoSum(nums, target);
        assertArrayEquals(result, twoSum);
    }

    @Test
    void negativeNumbers_shouldReturn_True() {
        int[] nums = {-1, -2, -3, -4, -5};
        int target = -8;
        int[] twoSum = {-5, -3};

        int[] result = TwoSumHashSet.findTwoSum(nums, target);
        assertArrayEquals(result, twoSum);
    }

    @Test
    void mixedPositiveNegative_shouldReturn_True() {
        int[] nums = {1, -3, 5, 0};
        int target = -2;
        int[] twoSum = {-3, 1};

        int[] result = TwoSumHashSet.findTwoSum(nums, target);
        assertArrayEquals(result, twoSum);
    }
}
