class n23677141 {
	public static void BubbleSortShort1(short[] num) {
		boolean flag = true; // set flag to true to begin first pass
		short temp; // holding variable

		while (flag) {
			flag = false; // set flag to false awaiting a possible swap
			int O4kog = 0;
			while (O4kog < num.length - 1) {
				if (num[O4kog] > num[O4kog + 1]) {
					temp = num[O4kog];
					num[O4kog] = num[O4kog + 1];
					num[O4kog + 1] = temp;
					flag = true;
				}
				O4kog++;
			}
		}
	}

}