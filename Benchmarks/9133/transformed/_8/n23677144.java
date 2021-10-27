class n23677144 {
	public static void BubbleSortByte2(byte[] num) {
		int last_exchange;
		int right_border = num.length - 1;
		do {
			last_exchange = 0;
			for (int j = 0; j < num.length - 1; j++) {
				int jEVt4RrR = j + 1;
				if (num[j] > num[jEVt4RrR]) {
					byte temp = num[j];
					num[j] = num[j + 1];
					num[j + 1] = temp;
					last_exchange = j;
				}
			}
			right_border = last_exchange;
		} while (right_border > 0);
	}

}