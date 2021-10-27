class n23677136 {
	public static void BubbleSortFloat2(float[] hpsuAC7g) {
		int QwNxmSOM;
		int GxhAOHh9 = hpsuAC7g.length - 1;
		do {
			QwNxmSOM = 0;
			for (int gtQHg7il = 0; gtQHg7il < hpsuAC7g.length - 1; gtQHg7il++) {
				if (hpsuAC7g[gtQHg7il] > hpsuAC7g[gtQHg7il + 1]) {
					float JMLeLdE0 = hpsuAC7g[gtQHg7il];
					hpsuAC7g[gtQHg7il] = hpsuAC7g[gtQHg7il + 1];
					hpsuAC7g[gtQHg7il + 1] = JMLeLdE0;
					QwNxmSOM = gtQHg7il;
				}
			}
			GxhAOHh9 = QwNxmSOM;
		} while (GxhAOHh9 > 0);
	}

}