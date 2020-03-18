/*
 * @lc app=leetcode.cn id=264 lang=java
 *
 * [264] 丑数 II
 *
 * https://leetcode-cn.com/problems/ugly-number-ii/description/
 *
 * algorithms
 * Medium (48.76%)
 * Likes:    237
 * Dislikes: 0
 * Total Accepted:    19.5K
 * Total Submissions: 38.6K
 * Testcase Example:  '10'
 *
 * 编写一个程序，找出第 n 个丑数。
 * 
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 * 
 * 示例:
 * 
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 
 * 说明:  
 * 
 * 
 * 1 是丑数。
 * n 不超过1690。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int nthUglyNumber(int n) {
        int[] nums= new int[n];
        nums[0] = 1;
        int i2=0,i3=0,i5=0;
        for (int i = 1; i < n; i++) {
            int temp = Math.min(Math.min(nums[i2]*2, nums[i3]*3),nums[i5]*5);
            nums[i] = temp;
            i2 += temp == nums[i2]*2? 1:0;
            i3 += temp == nums[i3]*3? 1:0;
            i5 += temp == nums[i5]*5? 1:0;
        }
        return nums[n-1];
    }
}
// @lc code=end

