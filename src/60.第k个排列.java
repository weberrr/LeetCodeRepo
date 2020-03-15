/*
 * @lc app=leetcode.cn id=60 lang=java
 *
 * [60] 第k个排列
 *
 * https://leetcode-cn.com/problems/permutation-sequence/description/
 *
 * algorithms
 * Medium (47.94%)
 * Likes:    189
 * Dislikes: 0
 * Total Accepted:    25.7K
 * Total Submissions: 53.1K
 * Testcase Example:  '3\n3'
 *
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * 
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * 
 * 
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 
 * 
 * 给定 n 和 k，返回第 k 个排列。
 * 
 * 说明：
 * 
 * 
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 
 * 
 * 示例 1:
 * 
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 
 * 
 * 示例 2:
 * 
 * 输入: n = 4, k = 9
 * 输出: "2314"
 * 
 * 
 */

// @lc code=start
class Solution {
    public String getPermutation(int n, int k) {
        boolean[] used = new boolean[n];
        int factor = factorial(n - 1);
        k = k - 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int index = k / factor;  // 获取当前位的数字index
            k = k % factor;
            for (int j = 0; j < n; j++) {
                if (!used[j]) {
                    if (index > 0) {
                        index--;
                    } else {
                        used[j] = true;
                        sb.append((char) ('0' + j + 1));
                        break;
                    }
                }
            }
            if (i < n - 1) {
                factor = factor / (n - i - 1);
            }
        }
        return sb.toString();
    }

    private int factorial(int n) {
        int s = 1;
        for (int i = 1; i <= n; i++) {
            s *= i;
        }
        return s;
    }

}
// @lc code=end

