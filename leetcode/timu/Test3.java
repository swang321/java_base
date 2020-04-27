/**
 * @Author whh  2019/12/20 15:53
 */
public class Test3 {

//    输入: head = [4,5,1,9], node = 5
//    输出: [4,1,9]
//    解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.


    public static void main(String[] args) {

    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

class ListNode {

    int val;

    ListNode next;

    ListNode(int x) {
        val = x;
    }

}
