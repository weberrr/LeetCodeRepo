import java.util.Arrays;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=85 lang=java
 *
 * [85] 最大矩形
 *
 * https://leetcode-cn.com/problems/maximal-rectangle/description/
 *
 * algorithms
 * Hard (43.61%)
 * Likes:    293
 * Dislikes: 0
 * Total Accepted:    16.5K
 * Total Submissions: 37.4K
 * Testcase Example:  '[["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]'
 *
 * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * 
 * 示例:
 * 
 * 输入:
 * [
 * ⁠ ["1","0","1","0","0"],
 * ⁠ ["1","0","1","1","1"],
 * ⁠ ["1","1","1","1","1"],
 * ⁠ ["1","0","0","1","0"]
 * ]
 * 输出: 6
 * 
 */

// @lc code=start
class Solution {

    // 法1：dp
    
    // 法2：stack
    public int maximalRectangle(char[][] matrix) {
        if(matrix==null||matrix.length==0) return 0;
        int area = 0;
        int[] dp = new int [matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j]=='1'){
                    dp[j]+=1;
                }else{
                    dp[j]=0;
                }
            }
            area = Math.max(area,largestRectangleArea(dp));
        }
        return area;
    }

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

