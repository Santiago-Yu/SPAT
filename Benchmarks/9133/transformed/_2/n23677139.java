class n23677139 {
	public static void BubbleSortLong1(long[] num) {
		boolean flag = true; // set flag to true to begin first pass
		long temp; // holding variable

		for (; flag;) {
			flag = false;
			for (int j = 0; j < num.length - 1; j++) {
				if (num[j] > num[j + 1]) {
					temp = num[j];
					num[j] = num[j + 1];
					num[j + 1] = temp;
					flag = true;
				}
			}
		}
	}

}