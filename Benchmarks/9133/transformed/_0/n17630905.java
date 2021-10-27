class n17630905 {
	public static int[] sortAscending(int vTecADbw[]) {
		int[] mql3OTzG = new int[vTecADbw.length];
		for (int cJbGz2lo = 0; cJbGz2lo < mql3OTzG.length; cJbGz2lo++)
			mql3OTzG[cJbGz2lo] = cJbGz2lo;
		for (int ED1PNZJn = vTecADbw.length; --ED1PNZJn >= 0;) {
			for (int DDdfwW3H = 0; DDdfwW3H < ED1PNZJn; DDdfwW3H++) {
				if (vTecADbw[DDdfwW3H] > vTecADbw[DDdfwW3H + 1]) {
					int KAbJiAJE = vTecADbw[DDdfwW3H];
					vTecADbw[DDdfwW3H] = vTecADbw[DDdfwW3H + 1];
					vTecADbw[DDdfwW3H + 1] = KAbJiAJE;
					int I7nNcntl = mql3OTzG[DDdfwW3H];
					mql3OTzG[DDdfwW3H] = mql3OTzG[DDdfwW3H + 1];
					mql3OTzG[DDdfwW3H + 1] = I7nNcntl;
				}
			}
		}
		return mql3OTzG;
	}

}