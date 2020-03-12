/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 *
 * https://leetcode-cn.com/problems/maximum-subarray/description/
 *
 * algorithms
 * Easy (48.67%)
 * Likes:    1506
 * Dislikes: 0
 * Total Accepted:    144.6K
 * Total Submissions: 297.2K
 * Testcase Example:  '[-2,1,-3,4,-1,2,1,-5,4]'
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 
 * 示例:
 * 
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 
 * 
 * 进阶:
 * 
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * 
 */

// @lc code=start
class Solution {
    private int helper(int[] nums, int l,int r){
        if(l == r) return nums[l];
        int p = (l +r) /2;
        int maxL = helper(nums, l, p);
        int maxR = helper(nums, p+1, r);
        int maxMid = crossSum(nums,l,r,p);
        return Math.max(Math.max(maxR, maxMid), maxL);
    }

    private int crossSum(int[] nums,int l, int r, int mid){
        int maxLeftSum = Integer.MIN_VALUE;
        int currSum = 0;
        for (int i = mid; i > l-1; i--) {
            currSum += nums[i];
            maxLeftSum = Math.max(maxLeftSum, currSum);
        }
        int maxRightSum =0;
        currSum = 0;
        for (int i = mid+1; i < r+1; i++) {
            currSum += nums[i];
            maxRightSum = Math.max(maxRightSum, currSum);
        }
        return maxLeftSum + maxRightSum;
    }

    public int maxSubArray(int[] nums) {
    
      return helper(nums, 0, nums.length-1);
    }
}
// @lc code=end

