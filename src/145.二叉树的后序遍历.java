import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import Utils.TreeNode;
/*
 * @lc app=leetcode.cn id=145 lang=java
 *
 * [145] 二叉树的后序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/description/
 *
 * algorithms
 * Hard (69.55%)
 * Likes:    223
 * Dislikes: 0
 * Total Accepted:    49.5K
 * Total Submissions: 70.7K
 * Testcase Example:  '[1,null,2,3]'
 *
 * 给定一个二叉树，返回它的 后序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  3
 *
 * 输出: [3,2,1]
 *
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
            LinkedList<Integer> list = new LinkedList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode curr = root;
            while (curr != null || !stack.empty()) {
                if (curr != null) {
                    stack.push(curr);
                    list.addFirst(curr.val);
                    curr = curr.right;
                } else {
                    curr = stack.pop().left;
                }
            }
            return list;
        }
}
// @lc code=end