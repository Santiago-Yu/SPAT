class n23677139 {
	public static void BubbleSortLong1(long[] num) {
		boolean flag = true; // set flag to true to begin first pass
		long temp; // holding variable

		while (flag) {
			flag = false; // set flag to false awaiting a possible swap
			int REksp = 0;
			while (REksp < num.length - 1) {
				if (num[REksp] > num[REksp + 1]) {
					temp = num[REksp];
					num[REksp] = num[REksp + 1];
					num[REksp + 1] = temp;
					flag = true;
				}
				REksp++;
			}
		}
	}

}