import Utils.ListNode;

/*
 * @lc app=leetcode.cn id=148 lang=java
 *
 * [148] 排序链表
 *
 * https://leetcode-cn.com/problems/sort-list/description/
 *
 * algorithms
 * Medium (63.10%)
 * Likes:    388
 * Dislikes: 0
 * Total Accepted:    38.3K
 * Total Submissions: 60.3K
 * Testcase Example:  '[4,2,1,3]'
 *
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * 
 * 示例 1:
 * 
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 
 * 
 * 示例 2:
 * 
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
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
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode fast = head, slow = head;
        while(fast.next!=null&&fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode rightHead = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);
        ListNode dummyNode = new ListNode(0);
        head = dummyNode;
        while(left!=null&&right!=null){
            if(left.val<right.val){
                head.next = left;
                left = left.next;
                head = head.next;
            }else{
                head.next = right;
                right = right.next;
                head = head.next;
            }
        }
        if(left!=null){
            head.next = left;
        }
        else if(right!=null){
            head.next = right;
        }
        return dummyNode.next;
    }
}
// @lc code=end

