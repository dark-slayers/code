package person.liuxx.learn.code.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，<br>
 * 请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。<br>
 * 你可以按任意顺序返回答案。 <br>
 * 示例 1：<br>
 * 输入：nums = [2,7,11,15], target = 9 <br>
 * 输出：[0,1] <br>
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。 <br>
 * 示例 2：<br>
 * 输入：nums = [3,2,4], target = 6 <br>
 * 输出：[1,2] <br>
 * 示例 3：<br>
 * 输入：nums = [3,3], target = 6 <br>
 * 输出：[0,1] <br>
 * 提示： 2 <= nums.length <= 10的4次方<br>
 * -10的9次方 <= nums[i] <= 10的9次方 <br>
 * -10的9次方 <= target <= 10的9次方 只会存在一个有效答案
 * 
 * @author
 * 
 * @version 1.0.0<br>
 *          创建时间：2022年3月14日 上午10:21:53
 * 
 * @since 1.0.0
 */
public class Problem1 {
    /**
     * @author
     * 
     * @version 1.0.0<br>
     *          创建时间：2022年3月14日 上午10:21:53
     * 
     * @since 1.0.0
     * 
     * @param args
     */
    public static void main(String[] args) {
        int[] result = twoSum(new int[] { 3, 2, 4 }, 6);
        System.out.println(Arrays.toString(result));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0, max = nums.length; i < max; i++) {
            int key = target - nums[i];
            if (map.containsKey(key)) {
                return new int[] { i, map.get(key) };
            }
            map.put(nums[i], i);
        }
        return result;
    }
}
