public class RecursionFun {

	// Precondition: 0 <= k <= n
	public int combinations(int n, int k) {
		if (n == k)
			return 1;
		else if (k == 0)
			return 1;
		else
			return combinations(n - 1, k - 1) + combinations(n - 1, k);
	}

	public double addReciprocals(int n) {
		return addReciprocals(n, 1);
	}

	private double addReciprocals(int n, int index) {
		if (index == n)
			return (1.0 / n);
		else
			return (1.0 / index) + addReciprocals(n, index + 1);
	}

	// Precondition: m and n are not both 0 (but either or both may be negative)
	public int GCD(int m, int n) {
		m = Math.abs(m);
		n = Math.abs(n);
		if (n == 0)
			return m;
		else
			return GCD(n, m % n);
	}

	// Precondition: n >= 0
	public String intWithCommas(int n) {
		if (n < 1000)
			return "" + n;
		else {
			String str = "";
			if (n % 1000 < 10)
				str = "00";
			else if (n % 1000 < 100)
				str = "0";
			return intWithCommas(n / 1000) + "," + str + (n % 1000);
		}
	}

	// Preconditions: x.length >= 1, beginIndex < x.length,
	// endIndex < x.length
	public int sumArray(int[] x, int beginIndex, int endIndex) {
		if (beginIndex > endIndex)
			return 0;
		return x[beginIndex] + sumArray(x, beginIndex + 1, endIndex);
	}

	// Precondition: x.length > 0
	public void reverseArray(int[] x) {
		reverseArray(x, 0);
	}

	private void reverseArray(int[] nums, int index) {
		if (index == nums.length/2)
			return;
		int temp = nums[index];
		nums[index] = nums[nums.length - 1 - index];
		nums[nums.length - 1 - index] = temp;
		reverseArray(nums, index + 1);
	}

	// Precondition: a.length > 0
	public int arrayRange(int[] a) {
		return arrayRange(a, 1, a[0], a[0]);
	}
	

	private int arrayRange(int[] nums, int index, int min, int max) {
		if (index == nums.length)
			return max - min;
		if (nums[index] > max)
			max = nums[index];
		if (nums[index] < min)
			min = nums[index];
		return arrayRange(nums, index + 1, min, max);
	}

	// Precondition: lowIndex <= highIndex , highIndex < strings.length
	public int binarySearch(String searchValue, String[] strings) {
		return binarySearch(searchValue, strings, 0, strings.length - 1);
	}

	private int binarySearch(String searchValue, String[] strings, int first, int last) {
		if (strings.length == 0)
			return -1;
		else if (first > last)
			return -1;
		else {
			int mid = (first + last) / 2;
			if (strings[mid].equals(searchValue)){
				if (mid == 0)
					return mid;
				if (strings[mid - 1].equals(searchValue)) {
					return binarySearch(searchValue, strings, first, mid - 1);
				}
				return mid;
			}
			if (strings[mid].compareTo(searchValue) < 0)
				return binarySearch(searchValue, strings, mid + 1, last);
			else
				return binarySearch(searchValue, strings, first, mid - 1);
		}
	}
}