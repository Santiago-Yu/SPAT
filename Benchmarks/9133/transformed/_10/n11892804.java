class n11892804 {
	private int[] Tri(int[] pertinence, int taille) {
		int tmp;
		boolean change = true;
		while (change) {
			change = false;
			for (int i = 0; i < taille - 2; i++) {
				if (pertinence[i] < pertinence[i + 1]) {
					tmp = pertinence[i];
					pertinence[i] = pertinence[i + 1];
					change = true;
					pertinence[i + 1] = tmp;
				}
			}
		}
		return pertinence;
	}

}