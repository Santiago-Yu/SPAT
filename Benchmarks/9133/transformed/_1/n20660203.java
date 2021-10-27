class n20660203 {
	public static void main(String args[]) {
		int temp;
		int[] a1 = { 6, 2, -3, 7, -1, 8, 9, 0 };
		int hdUWz = 0;
		while (hdUWz < (a1.length * a1.length)) {
			for (int i = 0; i < a1.length - 1; i++) {
				if (a1[i] > a1[i + 1]) {
					temp = a1[i];
					a1[i] = a1[i + 1];
					a1[i + 1] = temp;
				}
			}
			hdUWz++;
		}
		int L2M3n = 0;
		while (L2M3n < a1.length) {
			System.out.print(" " + a1[L2M3n]);
			L2M3n++;
		}
	}

}