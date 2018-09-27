package com.fhsrmb.interviewquestion.leetcode;

/**
 * @title 反转整数
 * Created by cheng on 2018/9/17.
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。
 *
 * 示例 1:
 * 输入: 123
 * 输出: 321
 *
 *  示例 2:
 *  输入: -123
 *  输出: -321
 *
 *  示例 3:
 *  输入: 120
 *  输出: 21
 *
 * 注意:
 *  假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0。
 */
public class Seven {
    public int reverse(int x) {
        StringBuffer result = new StringBuffer();
        boolean isZ = x>=0?true:false;
        do {
            int next = x/10;
            int tmp = x%10;
            if(next != 0)
            {
                if(!isZ && result.length() == 0 && tmp==0)
                {
                    result.append("-0");
                }else
                {
                    result.append(tmp);
                }
                x = next;
                if(next<0)
                {
                    x = 0-next;
                }
            }else {
                result.append(x);
                break;
            }
        }while (true);
        if (result.length()==(isZ?String.valueOf(Integer.MAX_VALUE).length():String.valueOf(Integer.MIN_VALUE).length())
                && result.toString().compareTo(isZ?String.valueOf(Integer.MAX_VALUE):String.valueOf(Integer.MIN_VALUE))>0)
        {
            result=new StringBuffer().append("0");
        }
        return Integer.valueOf(result.toString());
    }

    public static void main(String[] args)
    {
        int x = Integer.MAX_VALUE;
        System.out.println(new Seven().reverse(x));
    }
}
