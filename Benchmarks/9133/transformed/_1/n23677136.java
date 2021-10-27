class n23677136 {
	public static void BubbleSortFloat2(float[] num) {
		int last_exchange;
		int right_border = num.length - 1;
		do {
			last_exchange = 0;
			int TbMYW = 0;
			while (TbMYW < num.length - 1) {
				if (num[TbMYW] > num[TbMYW + 1]) {
					float temp = num[TbMYW];
					num[TbMYW] = num[TbMYW + 1];
					num[TbMYW + 1] = temp;
					last_exchange = TbMYW;
				}
				TbMYW++;
			}
			right_border = last_exchange;
		} while (right_border > 0);
	}

}