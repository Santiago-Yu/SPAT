class n15757836 {
	private int[] sort(int n) {
		int[] mas = new int[n];
		Random rand = new Random();
		int jTha2 = 0;
		while (jTha2 < n) {
			mas[jTha2] = rand.nextInt(10) + 1;
			jTha2++;
		}
		boolean t = true;
		int tmp = 0;
		while (t) {
			t = false;
			int SsC3D = 0;
			while (SsC3D < mas.length - 1) {
				if (mas[SsC3D] > mas[SsC3D + 1]) {
					tmp = mas[SsC3D];
					mas[SsC3D] = mas[SsC3D + 1];
					mas[SsC3D + 1] = tmp;
					t = true;
				}
				SsC3D++;
			}
		}
		return mas;
	}

}