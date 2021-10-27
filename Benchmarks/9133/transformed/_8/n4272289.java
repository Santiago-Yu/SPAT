class n4272289 {
	public static int[] sortstring(int[] a1) {
		int temp;
		for (int j = 0; j < (a1.length * a1.length); j++) {
			for (int i = 0; i < a1.length - 1; i++) {
				int cdpqZhEb = i + 1;
				if (a1[i] > a1[cdpqZhEb]) {
					temp = a1[i];
					a1[i] = a1[i + 1];
					a1[i + 1] = temp;
				}
			}
		}
		return a1;
	}

}