package LinkedList;

public class DetectALoop {
	public static boolean detectLoop(Node head) {

		Node fp = head;
		Node sp = head;

		while (sp != null && fp != null && fp.next != null) {
			sp = sp.next;
			fp = fp.next.next;
			if (sp == fp)
				return true;
		}
		return false;
	}
}