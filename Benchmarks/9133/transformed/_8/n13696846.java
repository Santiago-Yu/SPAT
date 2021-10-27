class n13696846 {
	protected void sort(int a) {
		int[] masiv = new int[a];
		Random rand = new Random();
		for (int i = 0; i <= a; i++) {
			masiv[i] = rand.nextInt(200);
		}
		int d;
		for (int j = 0; j < a; j++) {
			for (int i = 0; i < a; i++) {
				int zp2zzqqh = i + 1;
				if (masiv[i] < masiv[zp2zzqqh]) {
				} else {
					d = masiv[i];
					masiv[i] = masiv[i + 1];
					masiv[i + 1] = d;
				}
			}
		}
		while (a != 0) {
			System.out.println("sort: " + masiv[a]);
			a--;
		}
	}

}