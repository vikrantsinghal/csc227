public class OrderedSet<E extends Comparable<E>> {
	private class TreeNode {
		private TreeNode left;
		private TreeNode right;
		private E data;

		public TreeNode(E el) {
			left = null;
			right = null;
			data = el;
		}

	}

	private TreeNode root;

	public OrderedSet() {
		root = null;
	}

	public boolean insert(E element) {
		if (root == null)
			root = new TreeNode(element);
		else {
			TreeNode curr = root;
			TreeNode prev = root;
			while (curr != null) {
				prev = curr;
				if (curr.data.equals(element))
					return false;
				else if (curr.data.compareTo(element) > 0)
					curr = curr.left;
				else
					curr = curr.right;
			}
			if (prev.data.compareTo(element) > 0)
				prev.left = new TreeNode(element);
			else
				prev.right = new TreeNode(element);
		}
		return true;
	}

	public int size() {
		return size(root);
	}

	private int size(TreeNode t) {
		if (t == null)
			return 0;
		else
			return 1 + size(t.left) + size(t.right);
	}

	public String toStringInorder() {
		return toStringInorder(root).trim();
	}

	private String toStringInorder(TreeNode t) {
		if (t == null)
			return "";
		else
			return toStringInorder(t.left) + t.data + " "
					+ toStringInorder(t.right);
	}

	public String toStringPreorder() {
		return toStringPreorder(root).trim();
	}

	private String toStringPreorder(TreeNode t) {
		if (t == null)
			return "";
		else
			return t.data + " " + toStringPreorder(t.left)
					+ toStringPreorder(t.right);
	}

	public String toStringPostorder() {
		return toStringPostorder(root).trim();
	}

	private String toStringPostorder(TreeNode t) {
		if (t == null)
			return "";
		else
			return toStringPostorder(t.left) + toStringPostorder(t.right)
					+ t.data + " ";
	}

	public boolean contains(E search) {
		TreeNode t = root;
		while (t != null) {
			if (t.data.equals(search))
				return true;
			else if (t.data.compareTo(search) > 0)
				t = t.left;
			else
				t = t.right;
		}
		return false;
	}

	public E max() {
		return max(root);
	}

	private E max(TreeNode t) {
		TreeNode curr = t;
		TreeNode prev = t;
		while (curr != null) {
			prev = curr;
			curr = curr.right;
		}
		if (prev != null)
			return prev.data;
		return null;
	}

	public int nodesAtLevel(int level) {
		if (level > height(root) || level < 0)
			return 0;
		return nodesAtLevel(level, 0, root);
	}

	private int height(TreeNode t) {
		if (t == null)
			return -1;
		else
			return 1 + Math.max(height(t.left), height(t.right));
	}

	private int nodesAtLevel(int level, int index, TreeNode t) {
		if (t == null)
			return 0;
		else if (index >= level)
			return 1;
		else
			return nodesAtLevel(level, index + 1, t.left)
					+ nodesAtLevel(level, index + 1, t.right);
	}

	public OrderedSet<E> intersection(OrderedSet<E> other) {
		OrderedSet<E> result = new OrderedSet<E>();
		traverseAndAdd(result, other, root);
		return result;
	}

	private void traverseAndAdd(OrderedSet<E> result, OrderedSet<E> other,
			TreeNode t) {
		if (t == null)
			return;
		if (other.contains(t.data))
			result.insert(t.data);
		traverseAndAdd(result, other, t.left);
		traverseAndAdd(result, other, t.right);
	}

	public boolean sameStructure(OrderedSet<E> other) {
		if (other.size() != this.size())
			return false;
		return sameStructure(root, other.root);
	}

	private boolean sameStructure(TreeNode nodeThis, TreeNode nodeOther) {
		if (nodeThis == null && nodeOther == null)
			return true;
		else if (nodeThis == null && nodeOther != null)
			return false;
		else if (nodeThis != null && nodeOther == null)
			return false;
		else
			return sameStructure(nodeThis.left, nodeOther.left)
					&& sameStructure(nodeThis.right, nodeOther.right);
	}
	
	public OrderedSet<E> subSet(E inclusive, E exclusive) {
		OrderedSet<E> subSet = new OrderedSet<E>();
		createSubSet(root, subSet, inclusive, exclusive);
		return subSet;
	}

	private void createSubSet(TreeNode t, OrderedSet<E> subSet, E inclusive, E exclusive) {
		if (t == null)
			return;
		if (t.data.compareTo(inclusive) >= 0 && t.data.compareTo(exclusive) < 0)
			subSet.insert(t.data);
		createSubSet(t.left, subSet, inclusive, exclusive);
		createSubSet(t.right, subSet, inclusive, exclusive);
	}
	
	public boolean remove(E element) {
		if (root != null && root.data.equals(element) && root.left == null) {
			root = root.right;
			return true;
		}
		TreeNode curr = root;
		TreeNode prev = root;
		while (curr != null && !curr.data.equals(element)) {
			prev = curr;
			if (curr.data.compareTo(element) > 0)
				curr = curr.left;
			else
				curr = curr.right;
		}
		if (curr != null && curr.left == null) {
			if (curr == prev.left)
				prev.left = curr.right;
			else
				prev.right = curr.right;
			return true;
		}
		if (curr != null && curr.left != null) {
			TreeNode prevOfMax = curr.left;
			TreeNode max = curr.left;
			while (max.right != null) {
				prevOfMax = max;
				max = max.right;
			}
			curr.data = max.data;
			if (curr.left == max) {
				curr.left = max.left;
			}
			else
				prevOfMax.right = max.left;
			return true;
		}
		return false;
	}
}
