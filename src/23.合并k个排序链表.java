import java.util.Comparator;
import java.util.PriorityQueue;


import Utils.ListNode;

/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个排序链表
 *
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/description/
 *
 * algorithms
 * Hard (48.50%)
 * Likes:    455
 * Dislikes: 0
 * Total Accepted:    67.2K
 * Total Submissions: 138.5K
 * Testcase Example:  '[[1,4,5],[1,3,4],[2,6]]'
 *
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode dummyNode = new ListNode(0);
        ListNode curr = dummyNode;
        Comparator<ListNode> comparator = new Comparator<ListNode>() {
            @Override public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        };
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(
            lists.length,
            comparator
        );
        for (int i = 0; i < lists.length; i++) {
            if(lists[i]!=null)queue.offer(lists[i]);
        }
        while (!queue.isEmpty()) {
            curr.next = queue.poll();
            curr = curr.next;
            if (curr.next != null) {
                queue.offer(curr.next);
            }
        }
        return dummyNode.next;
    }
}
// @lc code=end
