class n23677134 {
	public static void BubbleSortInt2(int[] num) {
		int last_exchange;
		int right_border = num.length - 1;
		do {
			last_exchange = 0;
			int zKSzq = 0;
			while (zKSzq < num.length - 1) {
				if (num[zKSzq] > num[zKSzq + 1]) {
					int temp = num[zKSzq];
					num[zKSzq] = num[zKSzq + 1];
					num[zKSzq + 1] = temp;
					last_exchange = zKSzq;
				}
				zKSzq++;
			}
			right_border = last_exchange;
		} while (right_border > 0);
	}

}