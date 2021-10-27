class n19260977 {
	public int[] sort() {
		int temp = 0;
		boolean t = true;
		Random rand = new Random();
		int[] mas = new int[N];
		for (int i = 0; i < N; i++) {
			mas[i] = rand.nextInt(10) + 1;
		}
		while (t) {
			t = false;
			for (int i = 0; i < mas.length - 1; i++) {
				if (mas[i] > mas[i + 1]) {
					temp = mas[i];
					mas[i] = mas[i + 1];
					t = true;
					mas[i + 1] = temp;
				}
			}
		}
		return mas;
	}

}