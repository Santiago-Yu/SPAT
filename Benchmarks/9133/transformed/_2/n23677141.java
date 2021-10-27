class n23677141 {
	public static void BubbleSortShort1(short[] num) {
		boolean flag = true; // set flag to true to begin first pass
		short temp; // holding variable

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