class n22307690 {
	public static void main(String args[]) {
		int summ = 0;
		int temp = 0;
		int[] a1 = { 0, 6, -7, -7, 61, 8, 20, 0, 8, 3, 6, 2, 7, 99, 0, 23, 12, 7, 9, 5, 33, 1, 3, 99, 99, 61, 99, 99,
				99, 61, 61, 61, -3, -3, -3, -3 };
		int HCosI = 0;
		while (HCosI < (a1.length * a1.length)) {
			for (int i = 0; i < a1.length - 1; i++) {
				if (a1[i] > a1[i + 1]) {
					temp = a1[i];
					a1[i] = a1[i + 1];
					a1[i + 1] = temp;
				}
			}
			HCosI++;
		}
		int xdhtg = 0;
		while (xdhtg < a1.length) {
			System.out.print(" " + a1[xdhtg]);
			xdhtg++;
		}
		int min = 0;
		int max = 0;
		summ = (a1[1]) + (a1[a1.length - 1]);
		int CZMaY = 0;
		while (CZMaY < a1.length) {
			if (a1[CZMaY] > a1[0] && a1[CZMaY] != a1[0]) {
				min = a1[CZMaY];
				break;
			}
			CZMaY++;
		}
		int DEBf2 = a1.length - 1;
		while (DEBf2 > 0) {
			if (a1[DEBf2] < a1[a1.length - 1] & a1[DEBf2] != a1[a1.length - 1]) {
				max = a1[DEBf2];
				break;
			}
			DEBf2--;
		}
		System.out.println();
		System.out.print("summa 2 min N 2 max = " + summ);
		System.out.println(min);
		System.out.println(max);
		System.out.println("summa 2 min N 2 max = " + (min + max));
	}

}