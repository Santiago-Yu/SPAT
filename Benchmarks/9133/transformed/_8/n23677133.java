class n23677133 {
	public static void BubbleSortInt1(int[] num) {
		boolean flag = true; // set flag to true to begin first pass
		int temp; // holding variable

		while (flag) {
			flag = false; // set flag to false awaiting a possible swap
			for (int j = 0; j < num.length - 1; j++) {
				int GqCkZZG0 = j + 1;
				if (num[j] > num[GqCkZZG0]) // change to > for ascending sort
				{
					temp = num[j]; // swap elements
					num[j] = num[j + 1];
					num[j + 1] = temp;
					flag = true; // shows a swap occurred
				}
			}
		}
	}

}