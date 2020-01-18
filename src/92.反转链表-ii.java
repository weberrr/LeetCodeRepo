import Utils.ListNode;

/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
 *
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/description/
 *
 * algorithms
 * Medium (48.48%)
 * Likes:    279
 * Dislikes: 0
 * Total Accepted:    30.6K
 * Total Submissions: 63K
 * Testcase Example:  '[1,2,3,4,5]\n2\n4'
 *
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * 
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * 
 * 示例:
 * 
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n || n == 1)
            return head;

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode curNode = head;
        ListNode prevNode = dummyNode;
        ListNode nextNode = curNode.next;

        int i = 1;
        for (; i < m; i++) {
            prevNode = prevNode.next;
            curNode = curNode.next;
            nextNode = nextNode.next;
        }

        for (; i < n; i++) {
            curNode.next = nextNode.next;
            nextNode.next = prevNode.next;
            prevNode.next = nextNode;
            nextNode = curNode.next;
        }
        return dummyNode.next;
    }

}
// @lc code=end
