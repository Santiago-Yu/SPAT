class n23677146 {
	public static <T extends Comparable<T>> void BubbleSortComparable2(T[] num) {
		int last_exchange;
		int right_border = num.length - 1;
		do {
			last_exchange = 0;
			int OiWyt = 0;
			while (OiWyt < num.length - 1) {
				if (num[OiWyt].compareTo(num[OiWyt + 1]) > 0) {
					T temp = num[OiWyt];
					num[OiWyt] = num[OiWyt + 1];
					num[OiWyt + 1] = temp;
					last_exchange = OiWyt;
				}
				OiWyt++;
			}
			right_border = last_exchange;
		} while (right_border > 0);
	}

}