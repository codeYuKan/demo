package com.yukan.demo.leetcode.ⅡSUM;

import java.util.Objects;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int midVal = l1.val + l2.val;
        int carry = midVal / 10;
        midVal = midVal % 10;
        ListNode result = new ListNode(midVal);
        ListNode l1Next = l1.next;
        ListNode l2Next = l2.next;

        ListNode handleNode = result;
        while(true) {
            if (Objects.nonNull(l1Next)) {
                if (Objects.nonNull(l2Next)) {
                    midVal = l1Next.val + l2Next.val + carry;
                    l2Next = l2Next.next;
                } else {
                    midVal = l1Next.val + carry;
                }
                l1Next = l1Next.next;
            } else {
                if  (Objects.nonNull(l2Next)) {
                    midVal = l2Next.val + carry;
                    l2Next = l2Next.next;
                } else {
                    if (carry > 0) {
                        handleNode.next = new ListNode(carry);
                    }
                    break;
                }
            }
            carry = midVal / 10;
            midVal = midVal % 10;
            handleNode.next = new ListNode(midVal);
            handleNode = handleNode.next;
        }

        return result;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(9);
        ListNode a2 = new ListNode(8);
        a1.next = a2;
        //a2.next = new ListNode(3);
        //a2.next.next = new ListNode(1);

        ListNode b1 = new ListNode(1);
        //ListNode b2 = new ListNode(6);
        //b1.next = b2;
        //b2.next = new ListNode(4);

        ListNode result = addTwoNumbers(a1, b1);
        while (Objects.nonNull(result)) {
            System.out.println(result.val);
            result = result.next;
        }
    }

}