class n13696846 {
	protected void sort(int LYXUgYyK) {
		int[] g85EYNKb = new int[LYXUgYyK];
		Random LSoZykOY = new Random();
		for (int wT5rMr8F = 0; wT5rMr8F <= LYXUgYyK; wT5rMr8F++) {
			g85EYNKb[wT5rMr8F] = LSoZykOY.nextInt(200);
		}
		int tOsrpgpF;
		for (int hsjxO8sE = 0; hsjxO8sE < LYXUgYyK; hsjxO8sE++) {
			for (int Y61sapPM = 0; Y61sapPM < LYXUgYyK; Y61sapPM++) {
				if (g85EYNKb[Y61sapPM] < g85EYNKb[Y61sapPM + 1]) {
				} else {
					tOsrpgpF = g85EYNKb[Y61sapPM];
					g85EYNKb[Y61sapPM] = g85EYNKb[Y61sapPM + 1];
					g85EYNKb[Y61sapPM + 1] = tOsrpgpF;
				}
			}
		}
		while (LYXUgYyK != 0) {
			System.out.println("sort: " + g85EYNKb[LYXUgYyK]);
			LYXUgYyK--;
		}
	}

}