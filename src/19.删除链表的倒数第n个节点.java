import java.util.HashMap;

import Utils.ListNode;

/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第N个节点
 *
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/description/
 *
 * algorithms
 * Medium (37.03%)
 * Likes:    659
 * Dislikes: 0
 * Total Accepted:    110.1K
 * Total Submissions: 297.1K
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 
 * 示例：
 * 
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 
 * 
 * 说明：
 * 
 * 给定的 n 保证是有效的。
 * 
 * 进阶：
 * 
 * 你能尝试使用一趟扫描实现吗？
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        HashMap<Integer,ListNode> map = new HashMap<>();
        int i = 0;
        while(head!=null){
            map.put(i++, head);
            head=head.next;
        }
        if(i==1) return null;
        else if(i==n) return map.get(1);
        else{
            ListNode preNode = map.get(i-n-1);
            ListNode nextNode = map.get(i-n+1);
            preNode.next = nextNode;
            return map.get(0);
        }
    }
}
// @lc code=end

