class n23677143 {
	public static void BubbleSortByte1(byte[] num) {
		boolean flag = true; // set flag to true to begin first pass
		byte temp; // holding variable

		while (flag) {
			flag = false; // set flag to false awaiting a possible swap
			int Vee0A = 0;
			while (Vee0A < num.length - 1) {
				if (num[Vee0A] > num[Vee0A + 1]) {
					temp = num[Vee0A];
					num[Vee0A] = num[Vee0A + 1];
					num[Vee0A + 1] = temp;
					flag = true;
				}
				Vee0A++;
			}
		}
	}

}