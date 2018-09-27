package com.fhsrmb.interviewquestion.leetcode;

/**
 * @title 无重复字符的最长子串
 *
 * Created by cheng on 2018/9/10.
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。
 *
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 无重复字符的最长子串是 "abc"，其长度为 3。
 *
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 无重复字符的最长子串是 "b"，其长度为 1。
 *
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 无重复字符的最长子串是 "wke"，其长度为 3。
 * 请注意，答案必须是一个子串，"pwke" 是一个子序列 而不是子串。
 *
 */
public class Three {
    public int lengthOfLongestSubstring(String s) {
        int maxLength=s.length()>0?1:0;
        for(int i=0;i<s.length();i++)
        {
            boolean isInterrupt = false;
            int j=i;
            for (;j<s.length();j++)
            {
                for(int k=i;k<j;k++)
                {
                    if(s.charAt(j) == s.charAt(k))
                    {
                        isInterrupt = true;
                        break;
                    }
                }
                if (isInterrupt) break;
            }
            if(maxLength<(j-i+(isInterrupt?0:1)))
            {
                maxLength = j-i;
            }
        }
        return maxLength;
    }
    public static void main(String[] args)
    {
        String s = "abcabcbb";
        System.out.print(new Three().lengthOfLongestSubstring(s));
    }
}
