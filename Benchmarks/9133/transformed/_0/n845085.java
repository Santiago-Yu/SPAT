class n845085 {
	static void sort(int[] F8fZNIKo) {
		int AsKjjM78 = 0;
		while (AsKjjM78 < F8fZNIKo.length - 1) {
			int EWDBzSKZ = 0;
			while (EWDBzSKZ < (F8fZNIKo.length - AsKjjM78) - 1) {
				if (F8fZNIKo[EWDBzSKZ] > F8fZNIKo[EWDBzSKZ + 1]) {
					int AYwUF6KF = F8fZNIKo[EWDBzSKZ];
					F8fZNIKo[EWDBzSKZ] = F8fZNIKo[EWDBzSKZ + 1];
					F8fZNIKo[EWDBzSKZ + 1] = AYwUF6KF;
				}
				EWDBzSKZ = EWDBzSKZ + 1;
			}
			AsKjjM78 = AsKjjM78 + 1;
		}
	}

}