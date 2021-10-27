class n15757836 {
	private int[] sort(int n) {
		Random rand = new Random();
		int[] mas = new int[n];
		boolean t = true;
		for (int i = 0; i < n; i++) {
			mas[i] = rand.nextInt(10) + 1;
		}
		int tmp = 0;
		while (t) {
			t = false;
			for (int i = 0; i < mas.length - 1; i++) {
				if (mas[i] > mas[i + 1]) {
					tmp = mas[i];
					mas[i] = mas[i + 1];
					t = true;
					mas[i + 1] = tmp;
				}
			}
		}
		return mas;
	}

}