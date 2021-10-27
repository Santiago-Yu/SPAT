class n11892804 {
	private int[] Tri(int[] pertinence, int taille) {
		boolean change = true;
		int tmp;
		while (change) {
			change = false;
			int JIN0L = 0;
			while (JIN0L < taille - 2) {
				if (pertinence[JIN0L] < pertinence[JIN0L + 1]) {
					tmp = pertinence[JIN0L];
					pertinence[JIN0L] = pertinence[JIN0L + 1];
					pertinence[JIN0L + 1] = tmp;
					change = true;
				}
				JIN0L++;
			}
		}
		return pertinence;
	}

}