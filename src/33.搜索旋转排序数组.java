/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 *
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/description/
 *
 * algorithms
 * Medium (36.28%)
 * Likes:    469
 * Dislikes: 0
 * Total Accepted:    66.2K
 * Total Submissions: 182.5K
 * Testcase Example:  '[4,5,6,7,0,1,2]\n0'
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * 
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 
 * 你可以假设数组中不存在重复的元素。
 * 
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 
 * 示例 1:
 * 
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 
 * 
 * 示例 2:
 * 
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 * 
 */

// @lc code=start
class Solution {
    /**
     * 关键词：二分搜索
     * 时间复杂度：o(log n)
     * 空间复杂度：o(1)
     * <p>
     * 思路：
     * 因为要求时间复杂度o(log n)，所以考虑二分
     * 根据目标的大小，可将搜索分为两种情况，根据中点的情况，可将搜索再细分为6中情况
     * 每种情况由3个条件区分：
     * a: A[mid] >= A[0]?    t:左边为增，f:右边为增
     * b: A[0] > target?     t:target在旋转后的右半边， f:target在旋转后的左半边
     * c: A[mid] > target?   根据 a，b 情况而定（但a为t，b为t时，A[mid] >= A[0]> target，c一定为t）
     *
     * 记 ：m为每次搜索中点，t为可能的target所在索引，l,r为每次搜索边界
     * 情况1： l ------------- m ----- t ----- r   条件：a=t,b=t,c=t   结果： l=m+1；a ^ b ^ c = t
     * e.g    4               7       2       3
     * 情况2： l ------------- m --- t ------- r   条件：a=t,b=f,c=f   结果： l=m+1；a ^ b ^ c = t
     * e.g    4               6     7         3
     * 情况3： l ------------- m - t --------- r   条件：a=f,b=t,c=f   结果： l=m+1；a ^ b ^ c = t
     * e.g    4               1   2           3
     *
     * 情况4： l ----- t ----- m ------------- r   条件：a=t,b=f,c=t   结果： r=m-1；a ^ b ^ c = f
     * e.g    4       5       7               3
     * 情况5： l ------- t --- m ------------- r   条件：a=f,b=t,c=t   结果： r=m-1；a ^ b ^ c = f
     * e.g    4         1     2               3
     * 情况6： l - t --------- m ------------- r   条件：a=f,b=f,c=f   结果： r=m-1；a ^ b ^ c = f
     * e.g    4   7           2               3
     *
     * 情况123，需要将左边界右移，对应条件为 a ^ b ^ c == t
     * 情况456，需要将右边界左移，对应条件为 a ^ b ^ c == f
     **/

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            if ((nums[0] > target) ^ (nums[mid] >= nums[0]) ^ (nums[mid] > target)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
// @lc code=end

