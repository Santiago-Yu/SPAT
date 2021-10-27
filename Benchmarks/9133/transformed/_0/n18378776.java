class n18378776 {
	public int[] getRandMas(int mPeFwlpw) {
		boolean pOPPkjDG = true;
		int KiL8pgJ1 = 0;
		int[] WvHW6LZf = new int[mPeFwlpw];
		Random OoCvqQ2N = new Random();
		for (int ntKibp3l = 0; ntKibp3l < mPeFwlpw; ntKibp3l++) {
			WvHW6LZf[ntKibp3l] = OoCvqQ2N.nextInt(10) + 1;
		}
		while (pOPPkjDG) {
			pOPPkjDG = false;
			for (int F2g4fswL = 0; F2g4fswL < WvHW6LZf.length - 1; F2g4fswL++) {
				if (WvHW6LZf[F2g4fswL] > WvHW6LZf[F2g4fswL + 1]) {
					KiL8pgJ1 = WvHW6LZf[F2g4fswL];
					WvHW6LZf[F2g4fswL] = WvHW6LZf[F2g4fswL + 1];
					WvHW6LZf[F2g4fswL + 1] = KiL8pgJ1;
					pOPPkjDG = true;
				}
			}
		}
		return WvHW6LZf;
	}

}