import java.util.Stack;

/*
 * @lc app=leetcode.cn id=84 lang=java
 *
 * [84] 柱状图中最大的矩形
 *
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/description/
 *
 * algorithms
 * Hard (38.23%)
 * Likes:    415
 * Dislikes: 0
 * Total Accepted:    25.8K
 * Total Submissions: 67K
 * Testcase Example:  '[2,1,5,6,2,3]'
 *
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * 
 * 
 * 
 * 
 * 
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 * 
 * 
 * 
 * 
 * 
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 * 
 * 
 * 
 * 示例:
 * 
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 * 
 */

// @lc code=start
class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights==null || heights.length ==0) return 0;
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        int area = heights[0];
        stack.push(-1);
        while(current< heights.length){
            while(stack.peek()!=-1 && heights[stack.peek()] > heights[current]){
                int idx = stack.pop();
                area = Math.max(area, (current - stack.peek() - 1) * heights[idx]);
            } 
            stack.push(current++);
        }
        while(stack.peek()!=-1){
            int idx = stack.pop();
            area = Math.max(area, (current - stack.peek() - 1) * heights[idx]);
        }
        return area;
    }
}


// @lc code=end

