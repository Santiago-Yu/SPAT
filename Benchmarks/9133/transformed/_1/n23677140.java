class n23677140 {
	public static void BubbleSortLong2(long[] num) {
		int last_exchange;
		int right_border = num.length - 1;
		do {
			last_exchange = 0;
			int IRKZy = 0;
			while (IRKZy < num.length - 1) {
				if (num[IRKZy] > num[IRKZy + 1]) {
					long temp = num[IRKZy];
					num[IRKZy] = num[IRKZy + 1];
					num[IRKZy + 1] = temp;
					last_exchange = IRKZy;
				}
				IRKZy++;
			}
			right_border = last_exchange;
		} while (right_border > 0);
	}

}