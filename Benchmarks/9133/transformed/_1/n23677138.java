class n23677138 {
	public static void BubbleSortDouble2(double[] num) {
		int last_exchange;
		int right_border = num.length - 1;
		do {
			last_exchange = 0;
			int mbJYn = 0;
			while (mbJYn < num.length - 1) {
				if (num[mbJYn] > num[mbJYn + 1]) {
					double temp = num[mbJYn];
					num[mbJYn] = num[mbJYn + 1];
					num[mbJYn + 1] = temp;
					last_exchange = mbJYn;
				}
				mbJYn++;
			}
			right_border = last_exchange;
		} while (right_border > 0);
	}

}