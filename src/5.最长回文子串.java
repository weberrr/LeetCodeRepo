/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 *
 * https://leetcode-cn.com/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (28.10%)
 * Likes:    1858
 * Dislikes: 0
 * Total Accepted:    205K
 * Total Submissions: 709.1K
 * Testcase Example:  '"babad"'
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 
 * 示例 1：
 * 
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 
 * 
 * 示例 2：
 * 
 * 输入: "cbbd"
 * 输出: "bb"
 * 
 * 
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        if(s==null || s.length()<=1) return s;
        int maxLen = 0;
        String maxPal = "";
        boolean [][] dp = new boolean[s.length()][s.length()];
        for (int len = 1; len <= s.length(); len++) {
            for (int i = 0; i < s.length(); i++) {
                int j = i + len - 1;
                if (j >= s.length()) {
                    break;
                }
                dp[i][j] = (len==1 || (len==2&&s.charAt(i)==s.charAt(j)) || (dp[i+1][j-1] && s.charAt(i)==s.charAt(j)));
                if(dp[i][j] && len> maxLen){
                    maxLen  = len;
                    maxPal = s.substring(i,j+1);
                }
            }
        }
        return maxPal;
    }
}
// @lc code=end

