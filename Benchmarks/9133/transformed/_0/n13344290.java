class n13344290 {
	public static int best(int uXk6qf0N, int bZT9sHtF, int Alv74whc) {
		if ((bZT9sHtF <= 0) || (uXk6qf0N < 0) || (uXk6qf0N > bZT9sHtF) || (Alv74whc < 0))
			return 0;
		int[] BZuW8fYq = new int[bZT9sHtF];
		for (int FQJbCIy2 = 0; FQJbCIy2 < bZT9sHtF; FQJbCIy2++)
			BZuW8fYq[FQJbCIy2] = d(Alv74whc);
		boolean g0NCrAOT;
		do {
			g0NCrAOT = false;
			for (int fBmJk9Wd = 0; fBmJk9Wd < bZT9sHtF - 1; fBmJk9Wd++) {
				if (BZuW8fYq[fBmJk9Wd] < BZuW8fYq[fBmJk9Wd + 1]) {
					int pFd4vAfF = BZuW8fYq[fBmJk9Wd];
					BZuW8fYq[fBmJk9Wd] = BZuW8fYq[fBmJk9Wd + 1];
					BZuW8fYq[fBmJk9Wd + 1] = pFd4vAfF;
					g0NCrAOT = true;
				}
			}
		} while (g0NCrAOT);
		int dBWUlo75 = 0;
		for (int cftktSNU = 0; cftktSNU < uXk6qf0N; cftktSNU++)
			dBWUlo75 += BZuW8fYq[cftktSNU];
		return dBWUlo75;
	}

}