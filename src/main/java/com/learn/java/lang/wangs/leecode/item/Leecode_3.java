package com.learn.java.lang.wangs.leecode.item;

public class Leecode_3 {

    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     *
     * 示例 1:
     *
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     *
     * 输入: s = "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     *
     * 输入: s = "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     * 示例 4:
     *
     * 输入: s = ""
     * 输出: 0
     *  
     *
     * 提示：
     *
     * 0 <= s.length <= 5 * 104
     * s 由英文字母、数字、符号和空格组成
     *
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
     */

    /**
     * 难点是，当前的串，与前面的串比较，快速出结果
     *
     * 想起来了，我创建一个数组，连续的[][][][][][][][],当有数字的时候，就填坑进入，这样只需要
     *
     *
     * 想法
     * 难点是进行比较的方式131（2？）
     * 0001
     *    与
     * 0011
     * ----
     * 0011
     *
     * 如果新数字对比
     * 0011
     * 0011
     *
     * abcdefabc这种，判断是否有重复的，将其转换为二进制，位图呢？
     * 只要里面的位置占用了，就是最长的串
     *
     */
    public int lengthOfLongestSubstring(String s) {

        boolean b[] = new boolean[128];
        byte[] chars = s.getBytes();

        int max = 0;
        int gap = 0;
        for (int i = 0; i < s.length(); i++) {
            byte aChar = chars[i];
            if(!b[aChar]){
                b[aChar] = true;
                gap++;
            }else{
                // 重复的数字
                // 清空
                b = new boolean[128];
                if(gap > max){
                    max = gap;
                }
                b[aChar] = true;
                gap = 1;
            }
        }
        if(gap > max){
            max = gap;
        }
        return max;
    }


    // 这个想法是正确的，非常的对。
    public int lengthOfLongestSubstring2(String s) {
        // 记录字符上一次出现的位置
        int[] last = new int[128];
        for(int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int res = 0;
        // 窗口开始位置
        int start = 0;
        for(int i = 0; i < n; i++) {
            int index = s.charAt(i);
            // last[index] 保存上次的位置，并从上次的位置取出来，新的不重复的位置就是last[index]+1的位置
            start = Math.max(start, last[index] + 1);
            // 计算从开始节点的位置到目前字符指针位置的距离，代表了不重复的长度。
            res   = Math.max(res, i - start + 1);
            // 存放的是字符串的位置，第几个字符串
            last[index] = i;
        }
        return res;
    }


    public static void main(String[] args) {
        Leecode_3 answer = new Leecode_3();

        //String s = "abcabcbb";
        //String s = "bbbbb";
        //String s = "pwwwkew";
        //String s = "";
        String s = "dvdf";
        //String s = "pww";
        //String s = "aab";
        //System.out.println( answer.lengthOfLongestSubstring(s));
        System.out.println( answer.lengthOfLongestSubstring2(s));
    }
}
