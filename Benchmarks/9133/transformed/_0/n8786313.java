class n8786313 {
	@DeclarePerfMonTimer("SortingTest.bubbleSort")
	private void bubbleSort(int qfVSmTIi[]) {
		int RkH86T3b = qfVSmTIi.length - 1;
		for (int j1x1nqT0 = 0; j1x1nqT0 < RkH86T3b; j1x1nqT0++) {
			for (int ON1zNmHZ = 0; ON1zNmHZ < RkH86T3b - j1x1nqT0; ON1zNmHZ++) {
				if (qfVSmTIi[ON1zNmHZ] > qfVSmTIi[ON1zNmHZ + 1]) {
					int FZle9bCB = qfVSmTIi[ON1zNmHZ];
					qfVSmTIi[ON1zNmHZ] = qfVSmTIi[ON1zNmHZ + 1];
					qfVSmTIi[ON1zNmHZ + 1] = FZle9bCB;
				}
			}
		}
	}

}