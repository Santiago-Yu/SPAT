class n23677135 {
	public static void BubbleSortFloat1(float[] num) {
		boolean flag = true; // set flag to true to begin first pass
		float temp; // holding variable

		while (flag) {
			flag = false; // set flag to false awaiting a possible swap
			int lfmAe = 0;
			while (lfmAe < num.length - 1) {
				if (num[lfmAe] > num[lfmAe + 1]) {
					temp = num[lfmAe];
					num[lfmAe] = num[lfmAe + 1];
					num[lfmAe + 1] = temp;
					flag = true;
				}
				lfmAe++;
			}
		}
	}

}