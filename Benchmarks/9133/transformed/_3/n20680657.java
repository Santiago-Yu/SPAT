class n20680657 {
	protected void sort(int a) {
		int[] masiv = new int[a + 1];
		Random fff = new Random();
		for (int i = 0; i <= a; i++) {
			masiv[i] = fff.nextInt(9);
		}
		int d;
		for (int j = 0; j < a; j++) {
			for (int i = 0; i < a; i++) {
				if (!(masiv[i] < masiv[i + 1])) {
					d = masiv[i];
					masiv[i] = masiv[i + 1];
					masiv[i + 1] = d;
				} else {
				}
			}
		}
		while (a != 0) {
			System.out.println("sort: " + masiv[a]);
			a--;
		}
	}

}