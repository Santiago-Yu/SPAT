class n23677141 {
	public static void BubbleSortShort1(short[] num) {
		short temp;
		boolean flag = true;

		while (flag) {
			flag = false; // set flag to false awaiting a possible swap
			for (int j = 0; j < num.length - 1; j++) {
				if (num[j] > num[j + 1]) // change to > for ascending sort
				{
					temp = num[j]; // swap elements
					num[j] = num[j + 1];
					flag = true;
					num[j + 1] = temp;
				}
			}
		}
	}

}