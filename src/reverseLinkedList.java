class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}
class Solution {
	public static ListNode reverseList(ListNode head) {
		if(null==head|| null==head.next) return head;
		ListNode p = head;
		ListNode q = head.next;
		head.next = null;
		while(q != null)
		{  
			ListNode r = q.next;
			q.next = p;
			p = q;
			q = r;
		}  
		head = p;
		return head;  
	}
}
public class reverseLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode aListNode = new ListNode(1);
		for(int i = 2;i<10;i++) {
			ListNode temp = aListNode;
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = new ListNode(i);
		}
		aListNode = Solution.reverseList(aListNode);
		ListNode temp = aListNode;
		while (temp != null) {
			System.out.println(temp.val);
			temp = temp.next;
		}
	}

}
