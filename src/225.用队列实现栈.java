import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;


/*
 * @lc app=leetcode.cn id=225 lang=java
 *
 * [225] 用队列实现栈
 *
 * https://leetcode-cn.com/problems/implement-stack-using-queues/description/
 *
 * algorithms
 * Easy (61.79%)
 * Likes:    114
 * Dislikes: 0
 * Total Accepted:    29.4K
 * Total Submissions: 47.1K
 * Testcase Example:  '["MyStack","push","push","top","pop","empty"]\n[[],[1],[2],[],[],[]]'
 *
 * 使用队列实现栈的下列操作：
 * 
 * 
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 * 
 * 
 * 注意:
 * 
 * 
 * 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty
 * 这些操作是合法的。
 * 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 * 
 * 
 */

// @lc code=start
class MyStack {

    private Deque<Integer> inQueue;
    private Deque<Integer> outQueue;

    /** Initialize your data structure here. */
    public MyStack() {
        inQueue = new LinkedBlockingDeque<Integer>();
        outQueue =  new LinkedBlockingDeque<Integer>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        inQueue.add(x);
        while(!outQueue.isEmpty()){
            inQueue.offer(outQueue.poll());
        }
        while(!inQueue.isEmpty()){
            outQueue.offer(inQueue.poll());
        }
    }

    // 如果只用outQueue 单队列
    public void push2(int x) {
        int count = outQueue.size();
        outQueue.add(x);
        while(count>0){
            outQueue.add(outQueue.poll());
            count--;
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
      return outQueue.poll();
    }
    
    /** Get the top element. */
    public int top() {
        return outQueue.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return outQueue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

