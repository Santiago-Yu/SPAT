class n23677144 {
	public static void BubbleSortByte2(byte[] num) {
		int last_exchange;
		int right_border = num.length - 1;
		do {
			last_exchange = 0;
			int TqUqT = 0;
			while (TqUqT < num.length - 1) {
				if (num[TqUqT] > num[TqUqT + 1]) {
					byte temp = num[TqUqT];
					num[TqUqT] = num[TqUqT + 1];
					num[TqUqT + 1] = temp;
					last_exchange = TqUqT;
				}
				TqUqT++;
			}
			right_border = last_exchange;
		} while (right_border > 0);
	}

}