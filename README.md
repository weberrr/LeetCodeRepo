
# 1. 数组
## 1.1 数组特性
>数组是一种线性表结构，它用一组**连续的内存空间**，来存储**相同类型**的数据。

Java中数组的定义：

(1) `int[] list = new int[10];` # 固定大小

(2) `List<Integer> list = new ArrayList<>();` # 支持动态扩容

![list](./media/List.png)

List类常用的方法：
1. .add(num) & .addAll( {num1,num2} )  //添加元素
2. .remove(num) & .removeAll( {num1,num2} )  //移除元素
3. .contains(num) & .containsll( {num1,num2} )  //包含元素
4. .size()  //大小
5. .toArray() //转数组

## 1.2 相关LC题目
- 数组+双指针：
  - [11.盛最多水的容器](https://leetcode-cn.com/problems/container-with-most-water) 
  - [15.三数之和](https://leetcode-cn.com/problems/3sum) 
- 数组+原地删改：
  - [26.删除排序数组中的重复项](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array) ：快慢双指针
  - [27.移除元素](https://leetcode-cn.com/problems/remove-element) ：快慢双指针
  - [31.下一个排列](https://leetcode-cn.com/problems/next-permutation) ：临界条件
- 数组+二分查找：
  - [33.搜索旋转排序数组](https://leetcode-cn.com/problems/search-in-rotated-sorted-array/)：三条件组合判断
  - [34.在排序数组中查找元素的第一个和最后一个位置](https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/)：二分+遍历

# 2. 链表
## 2.1 链表特性
>常用的链表有：单链表、双向链表、循环链表

Java中链表的定义：

(1) 自己定义：
```java
class ListNode{
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
```

(2) `LinkedList<Integer> linkedList = new LinkedList<>();` # 双向链表

![list](./media/List.png)

## 2.2 相关LC题目
- 删除操作
  - [19.删除链表的倒数第N个节点](https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/) ：链表+哈希表
  - [82.删除排序链表中的重复元素 II](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/)：链表+递归

- 交换操作
  - [24.两两交换链表中的节点](https://leetcode-cn.com/problems/swap-nodes-in-pairs/description/)：链表+递归
  - [25.K个一组翻转链表](https://leetcode-cn.com/problems/reverse-nodes-in-k-group/description/)：链表+递归+反转
  - [61.旋转链表(右旋n步)](https://leetcode-cn.com/problems/rotate-list/description/)
  - [92.反转链表(m->n)](https://leetcode-cn.com/problems/reverse-linked-list-ii/description/])：链表+多指针

- 链表排序
    - [143.重排链表](https://leetcode-cn.com/problems/reorder-list/description/)：拆分+反转+合并
    - [147.对链表进行插入排序](https://leetcode-cn.com/problems/insertion-sort-list/description/)：依次插入
    - [148.排序链表](https://leetcode-cn.com/problems/sort-list/description/)：快慢双指针+归并排序

# 3. 栈
## 3.1 Java中的Stack类

如图所示，Stack来自于Vector，那么显然Stack的底层实现是数组。

![stack](./media/Stack.png)

属于stack自己的方法包括：
 1. .push(num) //入栈
 2. .pop() //栈顶元素出栈
 3. .isEmpty() //判定栈是否为空
 4. .peek() //获取栈顶元素
 5. .search(num) //判端元素num是否在栈中

## 3.2 相关LC题目
- 面积问题
    - [42.接雨水](https://leetcode-cn.com/problems/trapping-rain-water/description/)：常规做法-双指针；栈做法-墙入栈
    - [84.柱状图中的最大矩形](https://leetcode-cn.com/problems/largest-rectangle-in-histogram/description/)：栈头预压入-1，栈中存放升序列
    - [85.最大矩形](https://leetcode-cn.com/problems/maximal-rectangle/description/)：84题的矩阵形式
- 字符串问题
    - [20.有效的括号](https://leetcode-cn.com/problems/valid-parentheses/description/)：栈基础问题
    - [71.简化路径](https://leetcode-cn.com/problems/simplify-path/description/)：路径的情况分析 + 栈存结果
    - [316.去除重复字母](https://leetcode-cn.com/problems/remove-duplicate-letters/description/)：使用26字母的计数表来判断后面是否还有该字母 + 栈存储结果
- 二叉树遍历
    - [94.二叉树的中序遍历](https://leetcode-cn.com/problems/binary-tree-inorder-traversal/description/)：判断右节点来出栈
    - [144.二叉树的前序遍历](https://leetcode-cn.com/problems/binary-tree-preorder-traversal/description/)：栈存右节点
    - [145.二叉树的后序遍历](https://leetcode-cn.com/problems/binary-tree-postorder-traversal/description/)：通过linkedlist从上往右一边入栈，一边往list中addFirst加值；为空时再往左

# 4. 队列
## 4.1 Java中的Queue类
常用的有双端队列 Deque, 优先队列 PriporityQueue, 双向链表 LinkedList, 阻塞队列 BlockingQueue:

![Queue](./media/Queue.png)

Queue的方法有：
1. .add(num) = .offer(num)  //添加元素
2. .poll() = .remove()  //移除并返回头部
3. .peek() = .element() // 返回队列头部的元素
4. .put()  //阻塞队列添加元素，如果队列满，则阻塞
5. .take() //阻塞队列移除元素并返回头部，如果队列为空，则阻塞

## 4.2 相关LC题目
- 栈和队列的转换
   - [225.用队列实现栈](https://leetcode-cn.com/problems/implement-stack-using-queues/description/)：进出双队列实现 or 单队列
   - [232.用栈实现队列](https://leetcode-cn.com/problems/implement-queue-using-stacks/description/)
- 利用优先队列进行排序
   - [23.合并K个排序链表](https://leetcode-cn.com/problems/merge-k-sorted-lists/description/)：建立链表结点的优先队列
   - [56.合并区间](https://leetcode-cn.com/problems/merge-intervals/description/)：利用comparator来排序
   - [435.无重叠区间](https://leetcode-cn.com/problems/non-overlapping-intervals/description/)：判断每个区间的尾部
   - [692.前k个高频词](https://leetcode-cn.com/problems/top-k-frequent-words/description/)：哈希表+优先队列


# 5. 哈希表
## 5.1 Java中的Map类

![map](./media/Map.png)

Map 类没有继承Collection接口，提供key-value键值对映射。

**常用子类**
- HashMap：内部结构为哈希表+红黑树，异步处理（线程不安全），K和V都允许为null；
- Hashtable：内部结构为哈希表，同步（性能低），K和V都不允许为null；
- TreeMap：基于红黑树，异步处理，K不允许为null，K有序；

**常用方法**

- .containsKey(x)：是否含有key - O(1)
- .containsValue(x)：是否含有value - O(n)
- .get(key)： 获取key对应的值
- .put(key, value)：放入k-v
- .remove(key)：删除k-v
- .clear()：清空
- .keySet()：获取key的Set集合
- .values()：获取value的Collection集合
- Entry<K,V>：一个k-v对
- .entrySet()：k-v对的Set集合

## 5.2 相关LC题目
- 空间换时间
  - [1. 两数之和](https://leetcode-cn.com/problems/two-sum/description/)：哈希表 + 单次循环
  - [274. H指数](https://leetcode-cn.com/problems/h-index/description/)

- 哈希表记录下标
  - [3. 无重复字符的最长子串](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/description/)：哈希表 + 滑动窗口
  - [202. 快乐数](https://leetcode-cn.com/problems/happy-number/description/)

- 哈希表记录频次
  - [30. 串联所有单词的子串](https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words/description/)：哈希表统计单词表次数 + 滑动双指针
  - [187. 重复的DNA序列](https://leetcode-cn.com/problems/repeated-dna-sequences/description/)



# 6. 排序与查找
## 6.1 总结
排序：
|排序算法|时间复杂度|空间复杂度|是否稳定排序|是否原地排序|
|:---:|:---:|:---:|:---:|:---:|
|冒泡排序|O(n^2)|O(1)|✅|✅|
|插入排序|O(n^2)|O(1)|✅|✅|
|选择排序|O(n^2)|O(1)|❌|✅|
|归并排序|O(nlogn)|O(n)|✅|❌|
|快速排序|O(nlogn)|O(logn) ：递归栈|❌|✅|
|桶排序|O(n)|O(k)|✅|❌|
|计数排序|O(n+k)|O(k)|✅|❌|
|基数排序|O(dn)|O(k)|✅|❌|

查找：

有序数组的二分查找以及其变型
## 6.2 排序LC题目
- 排序
  - [75. 颜色分类](https://leetcode-cn.com/problems/sort-colors/description/) ：计数排序 / 荷兰旗三指针
  - [148. 排序链表](https://leetcode-cn.com/problems/sort-list/description/)：快慢双指针切分 + 归并排序
  - [164. 最大间距](https://leetcode-cn.com/problems/maximum-gap/description/)：桶排序
- 二分查找
  - [4. 寻找两个有序数组的中位数](https://leetcode-cn.com/problems/median-of-two-sorted-arrays/description/)：分堆 + 二分
  - [50. Pow(x,n)](https://leetcode-cn.com/problems/powx-n/description/)：幂的二分
  - [153. 寻找旋转排序数组中的最小值](https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/description/)：中值与右值判断

# 7. 贪心算法
贪心算法解题步骤：
1. 定义贪心问题：针对一组数据，定义了限制值和期望值，希望从中选几个数据，在满足限制值情况下，期望值最大。
2. 尝试贪心算法：每次选择对限制值相等贡献量情况下，期望值最大的数据。
3. 举例查看是否最优。

## 7.1 相关LC题目
- [45. 跳跃游戏 II](https://leetcode-cn.com/problems/jump-game-ii/description/)
- [135. 分发糖果](https://leetcode-cn.com/problems/candy/description/)
- [316. 去除重复字母](https://leetcode-cn.com/problems/remove-duplicate-letters/description/)

# 8. 分治算法
分治算法解题步骤：
1. 分解：将原问题分解为一系列子问题
2. 解决：递归的求解各个子问题
3. 合并：将子问题合并为原问题

## 8.1 相关LC题目
- [53. 最大子序和](https://leetcode-cn.com/problems/maximum-subarray/description/)
- [215. 数组中的第k个最大元素](https://leetcode-cn.com/problems/kth-largest-element-in-an-array/description/)
- [240. 搜索二维矩阵2](https://leetcode-cn.com/problems/search-a-2d-matrix-ii/description/)

# 9. 回溯算法
回溯算法解题步骤： ORT原则

以 [22. 括号生成]() 来说明：
1. 选择(Options)：每次回溯有 `(`,`)` 两种选择；
2. 限制(Restraints))：如果`left_num < right_num`,表明左括号用得多，可以加右括号也可以加左括号；如果`left_num = right_num`,表明左右用的一样多，只可以加左括号。
3. 结束(Termination)：
   如果 `left_num` 和 `right_num` 都为0，则括号用完。

## 9.1 相关LC题目
- [10. 正则表达式匹配](https://leetcode-cn.com/problems/regular-expression-matching/description/)：以p的长度作为切分条件
- [46. 全排列]()：使用交换来节省空间
- [47. 全排列2]()：使用标记位来过滤重复
- [60. 第k个排列]()：使用循环，一位一位的确定

# 10. 动态规划算法
动态规划解题步骤：状态方程法
1. 找到最优子结构
2. 写状态转移方程

## 10.1 相关LC题目
- [5. 最长回文子串]()
- [72. 编辑距离]()
- [85. 最大矩形]()
