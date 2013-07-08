/**
 * Here is one solution to the three methods from Section.
 * 
 * For this project, complete method duplicateAll(E).
 */
public class LinkedList<E extends Comparable<E>> {

	private class Node {
		private E data;
		private Node next;

		public Node(E element) {
			data = element;
			next = null;
		}

		public Node(E element, Node nextRef) {
			data = element;
			next = nextRef;
		}
	}

	private Node first;
	private int n;

	public LinkedList() {
		first = null;
		n = 0;
	}

	public void addLast(E element) {
		if (first == null) { // A special case, could be in the helper
			first = new Node(element);
			n++;
		} else
			addLast(first, element);
	}

	private void addLast(Node ref, E element) {
		if (ref.next == null) { // Base case: We reach the end, add it here
			ref.next = new Node(element);
			n++;
		} else
			addLast(ref.next, element); // keep looking for the last element
	}

	public String toString() {
		return toString(first).trim();
	}

	private String toString(Node ref) {
		if (ref == null)
			return "";
		else
			return ref.data + " " + toString(ref.next);
	}

	// Precondition: The list is not Empty
	public E max() {
		return max(first, first.data);
	}

	private E max(Node ref, E maxSoFar) {
		if (ref == null)
			return maxSoFar;
		if (ref.data.compareTo(maxSoFar) > 0)
			maxSoFar = ref.data;
		return max(ref.next, maxSoFar);
	}

	// Rick's solution (could be better I suppose
	public void reverse() {
		if (first != null)
			reverse(first, first.next);
	}

	private void reverse(Node prev, Node curr) {
		if (curr != null) {
			reverse(curr, curr.next);
			curr.next = prev;
		} else
			first = prev;

		// This is to mark the old first node as the new last node
		prev.next = null;
	}

	public int size() {
		return n;
	}

	/**
	 * This public method will call a private helper method
	 * 
	 * @param elementToDuplicate
	 *            . You complete both
	 */
	public void duplicateAll(E elementToDuplicate) {
		duplicateAll(elementToDuplicate, first);
	}

	private void duplicateAll(E elementToDuplicate, Node ref) {
		if (ref == null)
			return;
		if (ref.data.equals(elementToDuplicate)) {
			ref.next = new Node(elementToDuplicate, ref.next);
			n++;
			duplicateAll(elementToDuplicate, ref.next.next);
		}
		else
			duplicateAll(elementToDuplicate, ref.next);
	}

}