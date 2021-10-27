class n20680657 {
	protected void sort(int a) {
		int[] masiv = new int[a + 1];
		Random fff = new Random();
		int KuIjS = 0;
		while (KuIjS <= a) {
			masiv[KuIjS] = fff.nextInt(9);
			KuIjS++;
		}
		int d;
		int rMGUQ = 0;
		while (rMGUQ < a) {
			for (int i = 0; i < a; i++) {
				if (masiv[i] < masiv[i + 1]) {
				} else {
					d = masiv[i];
					masiv[i] = masiv[i + 1];
					masiv[i + 1] = d;
				}
			}
			rMGUQ++;
		}
		while (a != 0) {
			System.out.println("sort: " + masiv[a]);
			a--;
		}
	}

}