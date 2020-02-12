import java.util.Stack;

/*
 * @lc app=leetcode.cn id=316 lang=java
 *
 * [316] 去除重复字母
 *
 * https://leetcode-cn.com/problems/remove-duplicate-letters/description/
 *
 * algorithms
 * Hard (36.60%)
 * Likes:    101
 * Dislikes: 0
 * Total Accepted:    6.6K
 * Total Submissions: 17.7K
 * Testcase Example:  '"bcabc"'
 *
 * 给定一个仅包含小写字母的字符串，去除字符串中重复的字母，使得每个字母只出现一次。需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * 
 * 示例 1:
 * 
 * 输入: "bcabc"
 * 输出: "abc"
 * 
 * 
 * 示例 2:
 * 
 * 输入: "cbacdcbc"
 * 输出: "acdb"
 * 
 */

// @lc code=start
class Solution {
    public String removeDuplicateLetters(String s) {
        int[] charNum = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charNum[s.charAt(i)-'a']++;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            charNum[s.charAt(i)-'a']--;
            if(stack.contains(s.charAt(i))){
                continue;
            }
            while(!stack.empty() && stack.peek() > s.charAt(i) && charNum[stack.peek() - 'a']>0){
                stack.pop();
            }
            stack.push(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.empty()){
            sb.insert(0, stack.pop());
        }
        return String.valueOf(sb);
    }
}
// @lc code=end

