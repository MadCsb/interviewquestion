package com.fhsrmb.interviewquestion.leetcode;

/**
 * @title 两数相加
 * Created by cheng on 2018/9/10.
 * 给定两个非空链表来表示两个非负整数。
 * 位数按照逆序方式存储，它们的每个节点只存储单个数字。
 * 将两数相加返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * 示例
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class Two {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);
        ListNode point = result;
        int in = 0;
        for(;l1!=null || l2!=null;)
        {
            int tmp = (l1!=null?l1.val:0) + (l2!=null?l2.val:0) + in ;
            in = tmp/10;
            point = point.next = new ListNode(tmp%10);
            if(l1!=null){
                l1 = l1.next;
            }
            if (l2!=null)
            {
                l2 = l2.next;
            }
        }
        if (in>0)
        {
            point.next = new ListNode(in);
        }
        return result.next;
    }

    public static void main(String[] args)
    {

//        [2,4,3]
//        [5,6,4]
//        [7,0,8]

//        [9,4,3,8]
//          [7,6,4]
//      [6,1,8,8]
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(8);

        ListNode l2 = new ListNode(7);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = new Two().addTwoNumbers(l1,l2);
        while (result != null)
        {
            System.out.print(result.val+",");
            result = result.next;
        }
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}