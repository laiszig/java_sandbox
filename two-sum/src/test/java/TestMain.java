import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.laiszig.Main;

public class TestMain {

    @Test
    void shouldReturn_True() {

        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] twoSum = {2, 7};

        int[] result = Main.findTwoSum(nums, target);
        assertArrayEquals(result, twoSum);

    }

    @Test
    void middleNum_shouldReturn_True() {

        int[] nums = {3, 2, 4};
        int target = 6;
        int[] twoSum = {2, 4};

        int[] result = Main.findTwoSum(nums, target);
        assertArrayEquals(result, twoSum);

    }

    @Test
    void sameNumbers_shouldReturn_True() {
        int[] nums = {3, 3};
        int target = 6;
        int[] twoSum = {3, 3};

        int[] result = Main.findTwoSum(nums, target);
        assertArrayEquals(result, twoSum);
    }

    @Test
    void negativeNumbers_shouldReturn_True() {
        int[] nums = {-1, -2, -3, -4, -5};
        int target = -8;
        int[] twoSum = {-3, -5};

        int[] result = Main.findTwoSum(nums, target);
        assertArrayEquals(result, twoSum);
    }

    @Test
    void mixedPositiveNegative_shouldReturn_True() {
        int[] nums = {1, -3, 5, 0};
        int target = -2;
        int[] twoSum = {1, -3};

        int[] result = Main.findTwoSum(nums, target);
        assertArrayEquals(result, twoSum);
    }








}
