package com.fhsrmb.interviewquestion.leetcode;

/**
 * @title 最长回文子串
 *
 * Created by cheng on 2018/9/13.
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
 *
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba"也是一个有效答案。
 *
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 *
 *   1234567890
 *   1 2 3 4 5 6
 */
public class Five {
    public String longestPalindrome(String s) {
        String result = s.length()>0?s.substring(0,1):"";
        for(int i=0;i<(s.length()-1)*2;i++)
        {
            int maxLength = 0;

            for (; maxLength<=(i+1)/2 && maxLength<= ((s.length()-1)*2-i+1)/2 ; maxLength++)
            {
                if(i%2 == 0)
                {
                    if(s.charAt(i/2-maxLength) != s.charAt(i/2+maxLength))
                    {
                        break;
                    }
                }else
                {
                    if(maxLength>0 && s.charAt(i/2-(maxLength-1)) != s.charAt(i/2+maxLength))
                    {
                        break;
                    }
                }
            }
            maxLength--;
            if(i%2==0 && (maxLength*2+1)>result.length())
            {
                result = s.substring(i/2-maxLength,i/2+maxLength+1);
            }else if(i%2 == 1 && (maxLength*2)>result.length())
            {
                result = s.substring(i/2+1-maxLength,i/2+maxLength+1);
            }
        }
        return result;
    }
    public static void main(String[] args)
    {
        System.out.println(new Five().longestPalindrome("cbbd"));
    }
}
