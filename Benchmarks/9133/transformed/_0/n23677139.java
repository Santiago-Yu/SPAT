class n23677139 {
	public static void BubbleSortLong1(long[] D42XIQRe) {
		boolean lBFI25ib = true; // set flag to true to begin first pass
		long iN7f0efM; // holding variable

		while (lBFI25ib) {
			lBFI25ib = false; // set flag to false awaiting a possible swap
			for (int IbwVPNGJ = 0; IbwVPNGJ < D42XIQRe.length - 1; IbwVPNGJ++) {
				if (D42XIQRe[IbwVPNGJ] > D42XIQRe[IbwVPNGJ + 1]) // change to > for ascending sort
				{
					iN7f0efM = D42XIQRe[IbwVPNGJ]; // swap elements
					D42XIQRe[IbwVPNGJ] = D42XIQRe[IbwVPNGJ + 1];
					D42XIQRe[IbwVPNGJ + 1] = iN7f0efM;
					lBFI25ib = true; // shows a swap occurred
				}
			}
		}
	}

}