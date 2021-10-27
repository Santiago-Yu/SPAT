class n529986 {
	void bsort(int PlXqdChd[], int nBMzDY7c, int XkPS5LYr) throws Exception {
		for (int KZcW9MwW = XkPS5LYr; KZcW9MwW > nBMzDY7c; KZcW9MwW--) {
			for (int SqOx8hVO = nBMzDY7c; SqOx8hVO < KZcW9MwW; SqOx8hVO++) {
				if (PlXqdChd[SqOx8hVO] > PlXqdChd[SqOx8hVO + 1]) {
					int m7WfRSMb = PlXqdChd[SqOx8hVO];
					PlXqdChd[SqOx8hVO] = PlXqdChd[SqOx8hVO + 1];
					PlXqdChd[SqOx8hVO + 1] = m7WfRSMb;
					pause();
				}
			}
		}
	}

}