import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=164 lang=java
 *
 * [164] 最大间距
 *
 * https://leetcode-cn.com/problems/maximum-gap/description/
 *
 * algorithms
 * Hard (52.83%)
 * Likes:    118
 * Dislikes: 0
 * Total Accepted:    11.5K
 * Total Submissions: 21.1K
 * Testcase Example:  '[3,6,9,1]'
 *
 * 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
 *
 * 如果数组元素个数小于 2，则返回 0。
 *
 * 示例 1:
 *
 * 输入: [3,6,9,1]
 * 输出: 3
 * 解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
 *
 * 示例 2:
 *
 * 输入: [10]
 * 输出: 0
 * 解释: 数组元素个数小于 2，因此返回 0。
 *
 * 说明:
 *
 *
 * 你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。
 * 请尝试在线性时间复杂度和空间复杂度的条件下解决此问题。
 *
 *
 */

// @lc code=start
class Solution {

    public int maximumGap(int[] nums) {

        if (nums.length <= 1) 
            return 0;
        int min = nums[0];
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        if (max - min == 0) 
            return 0;
        int interval = (int)Math.ceil((double)(max - min) / (nums.length - 1));
        int[] bucketMin = new int[nums.length - 1];
        int[] bucketMax = new int[nums.length - 1];
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, -1);

        for (int i = 0; i < nums.length; i++) {
            int idx = (nums[i] - min) / interval;
            if (nums[i] == min || nums[i] == max) {
                continue;
            }
            bucketMin[idx] = Math.min(bucketMin[idx], nums[i]);
            bucketMax[idx] = Math.max(bucketMax[idx], nums[i]);
        }

        int gap = 0;
        int previousMax = min;

        for (int i = 0; i < bucketMin.length - 1; i++) {
            if (bucketMax[i] == -1) {
                continue;
            }
            gap = Math.max(gap, bucketMin[i] - previousMax);
            previousMax = bucketMax[i];
        }
        gap = Math.max(gap, max - previousMax);
        return gap;
    }
}
// @lc code=end