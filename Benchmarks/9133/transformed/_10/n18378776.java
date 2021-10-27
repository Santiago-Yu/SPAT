class n18378776 {
	public int[] getRandMas(int n) {
		int interim = 0;
		boolean t = true;
		Random rand = new Random();
		int[] mas = new int[n];
		for (int i = 0; i < n; i++) {
			mas[i] = rand.nextInt(10) + 1;
		}
		while (t) {
			t = false;
			for (int i = 0; i < mas.length - 1; i++) {
				if (mas[i] > mas[i + 1]) {
					interim = mas[i];
					mas[i] = mas[i + 1];
					t = true;
					mas[i + 1] = interim;
				}
			}
		}
		return mas;
	}

}