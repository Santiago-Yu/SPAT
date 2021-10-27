class n23677143 {
	public static void BubbleSortByte1(byte[] num) {
		boolean flag = true; // set flag to true to begin first pass
		byte temp; // holding variable

		while (flag) {
			flag = false; // set flag to false awaiting a possible swap
			for (int j = 0; j < num.length - 1; j++) {
				if (!(num[j] > num[j + 1]))
					;
				else {
					temp = num[j];
					num[j] = num[j + 1];
					num[j + 1] = temp;
					flag = true;
				}
			}
		}
	}

}