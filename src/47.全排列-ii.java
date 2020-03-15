import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 *
 * https://leetcode-cn.com/problems/permutations-ii/description/
 *
 * algorithms
 * Medium (56.52%)
 * Likes:    240
 * Dislikes: 0
 * Total Accepted:    43.5K
 * Total Submissions: 75.8K
 * Testcase Example:  '[1,1,2]'
 *
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 * ⁠ [1,1,2],
 * ⁠ [1,2,1],
 * ⁠ [2,1,1]
 * ]
 *
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permuteUnique(final int[] nums) {
        final List<List<Integer>> res = new ArrayList<>();
        final boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        final List<Integer> perList = new ArrayList<>();
        backTrack(res, perList, nums, used);
        return res;
    }

    private void backTrack(
        final List<List<Integer>> res,
        final List<Integer> perList,
        final int[] nums,
        final boolean[] used
    ) {
        if (perList.size() == nums.length) {
            // 注意⚠️： 需要copy对象
            res.add(new ArrayList<Integer>(perList));
        } else {
            for (int i = 0; i < used.length; i++) {
                if (used[i]) 
                    continue;
                // 注意⚠️：如果当前值和前一个值相同，并且前一个值没被用，则说明重复了
                if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) 
                    continue;
                used[i] = true;
                perList.add(nums[i]);
                backTrack(res, perList, nums, used);
                used[i] = false;
                perList.remove(perList.size() - 1);
            }
        }
    }
}
// @lc code=end
