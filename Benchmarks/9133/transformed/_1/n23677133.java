class n23677133 {
	public static void BubbleSortInt1(int[] num) {
		boolean flag = true; // set flag to true to begin first pass
		int temp; // holding variable

		while (flag) {
			flag = false; // set flag to false awaiting a possible swap
			int nvHec = 0;
			while (nvHec < num.length - 1) {
				if (num[nvHec] > num[nvHec + 1]) {
					temp = num[nvHec];
					num[nvHec] = num[nvHec + 1];
					num[nvHec + 1] = temp;
					flag = true;
				}
				nvHec++;
			}
		}
	}

}