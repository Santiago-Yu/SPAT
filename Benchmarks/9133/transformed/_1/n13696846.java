class n13696846 {
	protected void sort(int a) {
		int[] masiv = new int[a];
		Random rand = new Random();
		int VidQ3 = 0;
		while (VidQ3 <= a) {
			masiv[VidQ3] = rand.nextInt(200);
			VidQ3++;
		}
		int d;
		int xw9N4 = 0;
		while (xw9N4 < a) {
			for (int i = 0; i < a; i++) {
				if (masiv[i] < masiv[i + 1]) {
				} else {
					d = masiv[i];
					masiv[i] = masiv[i + 1];
					masiv[i + 1] = d;
				}
			}
			xw9N4++;
		}
		while (a != 0) {
			System.out.println("sort: " + masiv[a]);
			a--;
		}
	}

}