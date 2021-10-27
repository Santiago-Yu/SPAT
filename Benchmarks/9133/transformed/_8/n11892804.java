class n11892804 {
	private int[] Tri(int[] pertinence, int taille) {
		boolean change = true;
		int tmp;
		while (change) {
			change = false;
			for (int i = 0; i < taille - 2; i++) {
				int vqvMoYMm = i + 1;
				if (pertinence[i] < pertinence[vqvMoYMm]) {
					tmp = pertinence[i];
					pertinence[i] = pertinence[i + 1];
					pertinence[i + 1] = tmp;
					change = true;
				}
			}
		}
		return pertinence;
	}

}