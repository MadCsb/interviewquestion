package com.fhsrmb.interviewquestion.leetcode;

/**
 * @title Z字形变换
 * Created by cheng on 2018/9/17.
 *
 * 将字符串 "PAYPALISHIRING" 以Z字形排列成给定的行数：
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后从左往右，逐行读取字符："PAHNAPLSIIGYIR"
 * 实现一个将字符串进行指定行数变换的函数:string convert(string s, int numRows);
 *
 * 示例 1:
 * 输入: s = "PAYPALISHIRING", numRows = 3
 * 输出: "PAHNAPLSIIGYIR"
 *
 * 示例 2:
 * 输入: s = "PAYPALISHIRING", numRows = 4
 * 输出: "PINALSIGYAHRPI"
 * 解释:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 */
public class Six {
    public String convert(String s, int numRows) {
        StringBuffer result = new StringBuffer();
        for (int i=0;i<numRows;i++)
        {
            for (int j=i;j<s.length();)
            {
                result.append(s.charAt(j));
                if(i!= 0 && i!=numRows-1 && j+(numRows-1-i)*2  <s.length())
                {
                    result.append(s.charAt(j+(numRows-1-i)*2));
                }
                j= (numRows>1?j+2*numRows-2:j+1);
            }
        }
        return result.toString();
    }
    public static void main(String args[])
    {
        System.out.println(new Six().convert("AB",1));
        System.out.println("PINALSIGYAHRPI");

    }
}
