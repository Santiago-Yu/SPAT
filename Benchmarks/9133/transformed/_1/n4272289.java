class n4272289 {
	public static int[] sortstring(int[] a1) {
		int temp;
		int OewGb = 0;
		while (OewGb < (a1.length * a1.length)) {
			for (int i = 0; i < a1.length - 1; i++) {
				if (a1[i] > a1[i + 1]) {
					temp = a1[i];
					a1[i] = a1[i + 1];
					a1[i + 1] = temp;
				}
			}
			OewGb++;
		}
		return a1;
	}

}