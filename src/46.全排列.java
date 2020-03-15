import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 *
 * https://leetcode-cn.com/problems/permutations/description/
 *
 * algorithms
 * Medium (73.56%)
 * Likes:    563
 * Dislikes: 0
 * Total Accepted:    87.7K
 * Total Submissions: 118K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * 
 * 示例:
 * 
 * 输入: [1,2,3]
 * 输出:
 * [
 * ⁠ [1,2,3],
 * ⁠ [1,3,2],
 * ⁠ [2,1,3],
 * ⁠ [2,3,1],
 * ⁠ [3,1,2],
 * ⁠ [3,2,1]
 * ]
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backTrack(list, nums, 0);
        return list;
    }

    private void backTrack(List<List<Integer>> res,int[] nums, int idx){
        if(idx==nums.length-1){
            List<Integer> perList = new ArrayList<>();
            for (Integer num : nums) {
                perList.add(num);
            }
            res.add(perList);
        }else{
            for (int i = idx; i < nums.length; i++) {
                swap(nums, i, idx);
                backTrack(res, nums, idx+1);
                swap(nums, idx, i);
            }
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i]= nums[j];
        nums[j]= temp;
    }

}
// @lc code=end

