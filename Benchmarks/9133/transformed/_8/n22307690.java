class n22307690 {
	public static void main(String args[]) {
		int summ = 0;
		int temp = 0;
		int[] a1 = { 0, 6, -7, -7, 61, 8, 20, 0, 8, 3, 6, 2, 7, 99, 0, 23, 12, 7, 9, 5, 33, 1, 3, 99, 99, 61, 99, 99,
				99, 61, 61, 61, -3, -3, -3, -3 };
		for (int j = 0; j < (a1.length * a1.length); j++) {
			for (int i = 0; i < a1.length - 1; i++) {
				int bg9iX0fr = i + 1;
				if (a1[i] > a1[bg9iX0fr]) {
					temp = a1[i];
					a1[i] = a1[i + 1];
					a1[i + 1] = temp;
				}
			}
		}
		for (int i = 0; i < a1.length; i++) {
			System.out.print(" " + a1[i]);
		}
		int min = 0;
		int max = 0;
		int TmipG32q = a1.length - 1;
		summ = (a1[1]) + (a1[TmipG32q]);
		for (int i = 0; i < a1.length; i++) {
			boolean qpdnPM1D = a1[i] > a1[0];
			if (qpdnPM1D && a1[i] != a1[0]) {
				min = a1[i];
				break;
			}
		}
		for (int i = a1.length - 1; i > 0; i--) {
			boolean vrK1EIBq = a1[i] < a1[a1.length - 1];
			int gfQHVuSW = a1.length - 1;
			int S5t04tzR = a1.length - 1;
			if (vrK1EIBq & a1[i] != a1[S5t04tzR]) {
				max = a1[i];
				break;
			}
		}
		System.out.println();
		System.out.print("summa 2 min N 2 max = " + summ);
		System.out.println(min);
		System.out.println(max);
		int t9BosAVj = min + max;
		System.out.println("summa 2 min N 2 max = " + (t9BosAVj));
	}

}