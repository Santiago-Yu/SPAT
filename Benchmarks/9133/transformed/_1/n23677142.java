class n23677142 {
	public static void BubbleSortShort2(short[] num) {
		int last_exchange;
		int right_border = num.length - 1;
		do {
			last_exchange = 0;
			int jjyDa = 0;
			while (jjyDa < num.length - 1) {
				if (num[jjyDa] > num[jjyDa + 1]) {
					short temp = num[jjyDa];
					num[jjyDa] = num[jjyDa + 1];
					num[jjyDa + 1] = temp;
					last_exchange = jjyDa;
				}
				jjyDa++;
			}
			right_border = last_exchange;
		} while (right_border > 0);
	}

}