import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=187 lang=java
 *
 * [187] 重复的DNA序列
 *
 * https://leetcode-cn.com/problems/repeated-dna-sequences/description/
 *
 * algorithms
 * Medium (43.20%)
 * Likes:    70
 * Dislikes: 0
 * Total Accepted:    12.1K
 * Total Submissions: 27.6K
 * Testcase Example:  '"AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"'
 *
 * 所有 DNA 都由一系列缩写为 A，C，G 和 T 的核苷酸组成，例如：“ACGAATTCCG”。在研究 DNA 时，识别 DNA
 * 中的重复序列有时会对研究非常有帮助。
 * 
 * 编写一个函数来查找 DNA 分子中所有出现超过一次的 10 个字母长的序列（子串）。
 * 
 * 
 * 
 * 示例：
 * 
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC", "CCCCCAAAAA"]
 * 
 */

// @lc code=start
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res=new ArrayList<>();
        //s长度小于等于10当然不会有重复子串
        if(s.length()<=10)
            return res;
        //窗口大小
        int window=10;
        //记录出现过的子串
        Map<String,Integer> sMap=new HashMap<>();
            //左为0，右为窗口大小，开始滑动每轮while循环lr自增1
            int l=0;
            int r=window;
            while(r<=s.length()){
                //获取当前子串
                String temp=s.substring(l,r);
                //如果已经记录存在，返回对应value值，否则返回1
                int count=sMap.getOrDefault(temp,0);
                //value值加1，存入map
                sMap.put(temp,count+1);
                //第一次重复出现的时候加入list，之后再出现此单词不用加入list了，等于去重
                if(count==1){
                    res.add(temp);
                }
                l++;
                r++;
            }
        return res;
    }
}
// @lc code=end

