public class ArrayPriorityList<E> {
	private Object[] data;
	private int n;

	// Increases the capacity of the array by 10 elements.
	private void growArray() {
		Object[] temp = new Object[n + 10];

		for (int i = 0; i < n; i++)
			temp[i] = data[i];

		data = temp;
	}

	// Create an empty list with zero elements
	public ArrayPriorityList() {
		data = new Object[20];
		n = 0;
	}

	/**
	 * Return the number of elements currently in this PriorityList
	 * 
	 * @return The number of elements in this PriorityList
	 */
	public int size() {
		return n;
	}

	/**
	 * Return true if there are zero elements in this PriorityList
	 * 
	 * @return true if size() == 0 or false if size() > 0
	 */
	public boolean isEmpty() {
		if (size() == 0)
			return true;
		return false;
	}

	/**
	 * If possible, insert the element at the given index. If index is out of
	 * the valid range of 0..size(), throw new IllegalArgumentException(); When
	 * size is 3, the only possible values for index are 0, 1, 2, AND 3 because
	 * you can add an element as the new last.
	 * 
	 * @param index
	 *            The index of the element to move.
	 * @param el
	 *            The element to insert
	 * @throws IllegalArgumentException
	 */
	public void insertElementAt(int index, E el)
			throws IllegalArgumentException {
		if (index < 0 || index > size())
			throw new IllegalArgumentException();

		if (size() == data.length)
			growArray();

		for (int i = size(); i > index; i--)
			data[i] = data[i - 1];

		data[index] = el;
		n++;
	}

	/**
	 * If possible, return a reference to the element at the given index. If
	 * index is out of the valid range of 0..size()-1, throw new
	 * IllegalArgumentException(); When size is 3, the only possible values for
	 * index are 0, 1, and 2.
	 * 
	 * @param index
	 *            The index of the element to move.
	 * @return A reference to the element at index index.
	 * @throws IllegalArgumentException
	 */
	@SuppressWarnings("unchecked")
	public E getElementAt(int index) throws IllegalArgumentException {
		if (index < 0 || index >= size())
			throw new IllegalArgumentException();

		return (E) data[index];
	}

	/**
	 * If possible, remove the element at the given index. If index is out of
	 * the valid range of 0..size()-1, throw new IllegalArgumentException();
	 * When size is 3, the only possible values for index are 0, 1, and 2.
	 * 
	 * @param index
	 *            The index of the element to move.
	 * @throws IllegalArgumentException
	 */
	public void removeElementAt(int index) throws IllegalArgumentException {
		if (index < 0 || index > size() - 1)
			throw new IllegalArgumentException();

		data[index] = null;
		for (int i = index; i < n - 1; i++)
			data[i] = data[i + 1];

		data[n - 1] = null;
		n--;
	}

	/**
	 * If possible, swap the element located at index with the element at index
	 * + 1. An attempt to lower the priority of the element at index size()-1
	 * has no effect. If index is out of the valid range of 0..size()-1, throw
	 * new IllegalArgumentException(); When size is 3, the only possible values
	 * for index are 0, 1, and 2.
	 * 
	 * @param index
	 *            The index of the element to move
	 * @throws IllegalArgumentException
	 */
	public void lowerPriorityOf(int index) throws IllegalArgumentException {
		if (index < 0 || index > size() - 1)
			throw new IllegalArgumentException();

		if (index >= 0 && index < size() - 1) {
			Object temp = new Object();
			temp = data[index + 1];
			data[index + 1] = data[index];
			data[index] = temp;
		}
	}

	/**
	 * If possible, swap the element located at index with the element at
	 * index-1. An attempt to raise the priority at index 0 has no effect. If
	 * index is out of the valid range of 0..size()-1, throw new
	 * IllegalArgumentException(); When size is 3, the only possible values for
	 * index are 0, 1, and 2.
	 * 
	 * @param index
	 *            The index of the element to move
	 * @throws IllegalArgumentException
	 */
	public void raisePriorityOf(int index) throws IllegalArgumentException {
		if (index < 0 || index > size() - 1)
			throw new IllegalArgumentException();

		if (index > 0 && index <= size() - 1) {
			Object temp = new Object();
			temp = data[index - 1];
			data[index - 1] = data[index];
			data[index] = temp;
		}
	}

	/**
	 * Return a copy of all elements as an array of Objects that is the size of
	 * this PriorityList and in the same order. If there are no elements in this
	 * list, return new Object[0]; A change to the return value must not affect
	 * this PriorityList object.
	 * 
	 * @return An array of Objects where capacity == size()
	 */
	public Object[] toArray() {
		Object[] result = new Object[size()];

		for (int i = 0; i < size(); i++) {
			Object temp = data[i];
			result[i] = temp;
		}

		return result;
	}

	/**
	 * If possible, move the element at the given index to the end of this list.
	 * An attempt to move the last element to the last has no effect. If the
	 * index is out of the valid range 0..size()-1 throw new
	 * IllegalArgumentException(); When size is 3, the only possible values for
	 * index are 0, 1, and 2.
	 * 
	 * @param index
	 *            The index of the element to move.
	 * @throws IllegalArgumentException
	 */
	public void moveToLast(int index) throws IllegalArgumentException {
		if (index < 0 || index > size() - 1)
			throw new IllegalArgumentException();

		if (index < size() - 1) {
			Object temp = data[index];

			for (int i = index; i < size() - 1; i++)
				data[i] = data[i + 1];

			data[size() - 1] = temp;
		}
	}

	/**
	 * If possible, move the element at the given index to the front of this
	 * list An attempt to move the top element to the top has no effect. If the
	 * index is out of the valid range of 0..size()-1, throw new
	 * IllegalArgumentException(); When size is 3, the only possible values for
	 * index are 0, 1, and 2.
	 * 
	 * @param index
	 *            The index of the element to move.
	 * @throws IllegalArgumentException
	 */
	public void moveToTop(int index) throws IllegalArgumentException {
		if (index < 0 || index > size() - 1)
			throw new IllegalArgumentException();

		if (index > 0) {
			Object temp = data[index];

			for (int i = index; i > 0; i--)
				data[i] = data[i - 1];

			data[0] = temp;
		}
	}
}
