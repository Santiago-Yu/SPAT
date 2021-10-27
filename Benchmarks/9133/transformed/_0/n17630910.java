class n17630910 {
	public static int[] sortDescending(double I6VTZUB9[]) {
		int[] pZiOeRyX = new int[I6VTZUB9.length];
		for (int kUriMLaR = 0; kUriMLaR < pZiOeRyX.length; kUriMLaR++)
			pZiOeRyX[kUriMLaR] = kUriMLaR;
		for (int j2ndbs6R = I6VTZUB9.length; --j2ndbs6R >= 0;) {
			for (int RQwVAJKj = 0; RQwVAJKj < j2ndbs6R; RQwVAJKj++) {
				if (I6VTZUB9[RQwVAJKj] < I6VTZUB9[RQwVAJKj + 1]) {
					double YbCfWJty = I6VTZUB9[RQwVAJKj];
					I6VTZUB9[RQwVAJKj] = I6VTZUB9[RQwVAJKj + 1];
					I6VTZUB9[RQwVAJKj + 1] = YbCfWJty;
					int l3DtkF1p = pZiOeRyX[RQwVAJKj];
					pZiOeRyX[RQwVAJKj] = pZiOeRyX[RQwVAJKj + 1];
					pZiOeRyX[RQwVAJKj + 1] = l3DtkF1p;
				}
			}
		}
		return pZiOeRyX;
	}

}