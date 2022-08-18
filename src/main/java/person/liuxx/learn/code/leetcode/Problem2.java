package person.liuxx.learn.code.leetcode;

import java.util.Objects;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。<br>
 * 它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。<br>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。 <br>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例 1：<br>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]<br>
 * 输出：[7,0,8]<br>
 * 解释：342 + 465 = 807.
 * <p>
 * 示例 2：<br>
 * 输入：l1 = [0], l2 = [0]<br>
 * 输出：[0]
 * <p>
 * 示例 3：<br>
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]<br>
 * 输出：[8,9,9,9,0,0,0,1]
 * <p>
 * 提示：<br>
 * 每个链表中的节点数在范围 [1, 100] 内<br>
 * 0 <= Node.val <= 9<br>
 * 题目数据保证列表表示的数字不含前导零<br>
 * 
 * @author
 * 
 * @version 1.0.0<br>
 *          创建时间：2022年3月14日 下午1:53:51
 * 
 * @since 1.0.0
 */
public class Problem2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int x = 0;
        ListNode head = null;
        ListNode last = null;
        for (;;) {
            if (Objects.isNull(l1) && Objects.isNull(l2)) {
                break;
            }
            int sum = (Objects.nonNull(l1) ? l1.val : 0) + (Objects.nonNull(l2) ? l2.val : 0) + x;
            x = sum / 10;
            if (Objects.isNull(head)) {
                last = new ListNode(sum % 10);
                head = last;
            } else {
                last.next = new ListNode(sum % 10);
                last = last.next;
            }
            if (Objects.nonNull(l1)) {
                l1 = l1.next;
            }
            if (Objects.nonNull(l2)) {
                l2 = l2.next;
            }
        }
        if (x == 1) {
            last.next = new ListNode(1);
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}