import Utils.ListNode;

/*
 * @lc app=leetcode.cn id=143 lang=java
 *
 * [143] 重排链表
 *
 * https://leetcode-cn.com/problems/reorder-list/description/
 *
 * algorithms
 * Medium (54.02%)
 * Likes:    143
 * Dislikes: 0
 * Total Accepted:    14.9K
 * Total Submissions: 27.5K
 * Testcase Example:  '[1,2,3,4]'
 *
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 
 * 示例 1:
 * 
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 
 * 示例 2:
 * 
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head==null||head.next==null||head.next.next==null) return;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode secPart = reverseList(slow.next);
        slow.next = null;
        ListNode firPart = head;
        ListNode temp;
        while(secPart!=null){
            temp = secPart.next;
            secPart.next = firPart.next;
            firPart.next = secPart;
            firPart = secPart.next;
            secPart = temp;
        }
    }

    private ListNode reverseList(ListNode head){
        ListNode point = head;
        ListNode temp;
        while(point.next!=null){
            temp = point.next;
            point.next = temp.next;
            temp.next = head;
            head = temp;
        }
        return head;
    }
}
// @lc code=end
