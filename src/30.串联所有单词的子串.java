import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode.cn id=30 lang=java
 *
 * [30] 串联所有单词的子串
 *
 * https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words/description/
 *
 * algorithms
 * Hard (28.63%)
 * Likes:    223
 * Dislikes: 0
 * Total Accepted:    23.9K
 * Total Submissions: 81.5K
 * Testcase Example:  '"barfoothefoobarman"\n["foo","bar"]'
 *
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 *
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 *
 *
 *
 * 示例 1：
 *
 * 输入：
 * ⁠ s = "barfoothefoobarman",
 * ⁠ words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 *
 *
 * 示例 2：
 *
 * 输入：
 * ⁠ s = "wordgoodgoodgoodbestword",
 * ⁠ words = ["word","good","best","word"]
 * 输出：[]
 *
 *
 */

// @lc code=start
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        if(s==null || s.equals("")|| words==null || words.length==0) return res;
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        int sLen = s.length(), wLen = words[0].length(), wsLen = words.length;
        if (sLen < wLen * wsLen) return res;
        
        for (int i = 0; i < wLen; i++) {
            int l = i, r = i, windowLen = 0;
            while (r + (wsLen - windowLen) * wLen <= sLen && r + wLen <= sLen) {
                String subStr = s.substring(r, r + wLen);
                if (map.containsKey(subStr)) {
                    int val = map.get(subStr);
                    if (val > 0) {
                        map.put(subStr, val - 1);
                        windowLen++;
                    } else { // map 当前字符的计数为0 说明出现了重复字符
                        // 去 s 的左边移除重复字符串
                        String removeStr = s.substring(l, l + wLen);
                        while (!removeStr.equals(subStr)) {
                            if (map.containsKey(removeStr)) {
                                map.put(removeStr, map.get(removeStr) + 1);
                                windowLen--;
                            }
                            l = l + wLen;
                            removeStr = s.substring(l, l + wLen);
                        }
                        l = l + wLen;
                    }
                    if (windowLen == wsLen) {
                        res.add(l);
                    }
                } else {
                    windowLen = 0;
                    while (l < r) {
                        String removeStr = s.substring(l, l + wLen);
                        if (map.containsKey(removeStr)) {
                            map.put(removeStr, map.get(removeStr) + 1);
                        }
                        l = l + wLen;
                    }
                    l = l + wLen;
                }
                r = r + wLen;
            }
            // 恢复map
            while(l < r){
                String removeStr = s.substring(l, l + wLen);
                if (map.containsKey(removeStr)) {
                    map.put(removeStr, map.get(removeStr) + 1);
                }
                l = l + wLen;
            }
        }
        return res;
    }
}

// @lc code=end