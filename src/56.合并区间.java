import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 *
 * https://leetcode-cn.com/problems/merge-intervals/description/
 *
 * algorithms
 * Medium (39.81%)
 * Likes:    287
 * Dislikes: 0
 * Total Accepted:    53.3K
 * Total Submissions: 132.1K
 * Testcase Example:  '[[1,3],[2,6],[8,10],[15,18]]'
 *
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 *
 * 示例 2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) 
                    return a[1] - b[1];
                else 
                    return a[0] - b[0];
                }
            };
        Arrays.sort(intervals, comparator);
        int i=0;
        while(i<intervals.length){
            int left = intervals[i][0];
            int right = intervals[i][1];
            while(i<intervals.length-1 && right >= intervals[i+1][0]){
                i++;
                right = Math.max(right, intervals[i][1]);
            }
            res.add(new int[]{left,right});
            i++;
        }
        return res.toArray(new int[0][]);
    }

}
// @lc code=end