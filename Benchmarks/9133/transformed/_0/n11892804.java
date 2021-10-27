class n11892804 {
	private int[] Tri(int[] eg4RbR0a, int YX5meJUH) {
		boolean yoR4n0tH = true;
		int pPvizsc5;
		while (yoR4n0tH) {
			yoR4n0tH = false;
			for (int GRHICJKQ = 0; GRHICJKQ < YX5meJUH - 2; GRHICJKQ++) {
				if (eg4RbR0a[GRHICJKQ] < eg4RbR0a[GRHICJKQ + 1]) {
					pPvizsc5 = eg4RbR0a[GRHICJKQ];
					eg4RbR0a[GRHICJKQ] = eg4RbR0a[GRHICJKQ + 1];
					eg4RbR0a[GRHICJKQ + 1] = pPvizsc5;
					yoR4n0tH = true;
				}
			}
		}
		return eg4RbR0a;
	}

}