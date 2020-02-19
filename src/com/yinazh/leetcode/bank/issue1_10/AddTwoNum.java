package com.yinazh.leetcode.bank.issue1_10;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * yinazh答案：https://leetcode-cn.com/problems/add-two-numbers/
 * */
public class AddTwoNum {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode headL1 = l1;
        ListNode headL2 = l2;
        ListNode result = null;
        ListNode resultIndex = null;
        int jumpD = 0;
        while(headL1 != null && headL2 != null){

            int temp = headL1.val + headL2.val + jumpD;
            jumpD = temp/10;

            ListNode resultNext = new ListNode(temp%10);
            if(result == null){
                result = resultNext;
                resultIndex = result;
            }else{
                resultIndex.next = resultNext;
                resultIndex = resultIndex.next;
            }

            headL1 = headL1.next;
            headL2 = headL2.next;
        }

        if(headL1 == null && headL2 != null){
            resultIndex.next = headL2;
        }else if(headL1 != null && headL2 == null){
            resultIndex.next = headL1;
        }else{
            if(jumpD != 0){
                resultIndex.next = new ListNode(0);
            }
        }

        resultIndex = resultIndex.next;

        if(jumpD != 0){
            while(resultIndex != null){
                if((resultIndex.val + jumpD)/10 > 0){
                    int yushu = (resultIndex.val + jumpD)%10;
                    int momo = (resultIndex.val + jumpD)/10;
                    jumpD = momo;
                    resultIndex.val = yushu;
                    if(resultIndex.next == null){
                        resultIndex.next = new ListNode(jumpD);
                    }else{
                        resultIndex.next.val += jumpD;
                    }

                }else{
                    resultIndex.val = (resultIndex.val + jumpD)%10;
                }
                jumpD = 0;
                resultIndex = resultIndex.next;
            }
        }

        return result;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
