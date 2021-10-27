class n709510 {
	static void sort(int[] HXNVawo2) {
		int SiLRue3b = 0;
		while (SiLRue3b < HXNVawo2.length - 1) {
			int pwZqZiQm = 0;
			while (pwZqZiQm < (HXNVawo2.length - SiLRue3b) - 1) {
				if (HXNVawo2[pwZqZiQm] > HXNVawo2[pwZqZiQm + 1]) {
					int TfdsAShf = HXNVawo2[pwZqZiQm];
					HXNVawo2[pwZqZiQm] = HXNVawo2[pwZqZiQm + 1];
					HXNVawo2[pwZqZiQm + 1] = TfdsAShf;
				}
				pwZqZiQm = pwZqZiQm + 1;
			}
			SiLRue3b = SiLRue3b + 1;
		}
	}

}