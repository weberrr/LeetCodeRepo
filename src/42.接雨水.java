import java.util.Stack;

/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 *
 * https://leetcode-cn.com/problems/trapping-rain-water/description/
 *
 * algorithms
 * Hard (47.94%)
 * Likes:    783
 * Dislikes: 0
 * Total Accepted:    47K
 * Total Submissions: 98K
 * Testcase Example:  '[0,1,0,2,1,0,1,3,2,1,2,1]'
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 
 * 
 * 
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢
 * Marcos 贡献此图。
 * 
 * 示例:
 * 
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * 
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
      int area= 0;
      Stack<Integer> stack = new Stack<>();
      int current = 0;
      while(current < height.length){
          while(!stack.empty() && height[stack.peek()]<height[current]){
            int h = height[stack.peek()];
            stack.pop();
            if(stack.empty()){
                break;
            }
            int distance = current - stack.peek() - 1;
            int minH = Math.min(height[stack.peek()], height[current]);
            area += distance * (minH - h);
          }
          stack.push(current++);
      }
      return area;
    }
    
    public int trap2(int[] height) {
      if (height.length < 3) return 0;
      int ml = height[0]; // 左边最高
      int mr = height[height.length - 1]; //右边最高
      int l = 1;
      int r = height.length - 2;
      int res = 0;
      while (l <= r) {
          if (ml < mr) {
              if (height[l] < ml) {
                  res += ml - height[l];
              } else {
                  ml = height[l];
              }
              l++;
          } else {
              if (height[r] < mr) {
                  res += mr - height[r];
              } else {
                  mr = height[r];
              }
              r--;
          }
      }
      return res;
  }
}
// @lc code=end

