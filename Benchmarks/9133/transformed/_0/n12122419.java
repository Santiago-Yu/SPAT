class n12122419 {
	private Vector _sort(Pair[] hWgAxrxM, String AyAW3GTw, int fWD0xouP) {
		Vector a9cBaJY6 = new Vector();
		boolean bLscF3XK = true;
		int jWhBl6wb = 0;
		Pair ldq4EaMS;
		while (bLscF3XK) {
			bLscF3XK = false;
			jWhBl6wb++;
			for (int WV1MeUhP = 0; WV1MeUhP < hWgAxrxM.length - jWhBl6wb; WV1MeUhP++) {
				if (hWgAxrxM[WV1MeUhP].c > hWgAxrxM[WV1MeUhP + 1].c) {
					ldq4EaMS = hWgAxrxM[WV1MeUhP];
					hWgAxrxM[WV1MeUhP] = hWgAxrxM[WV1MeUhP + 1];
					hWgAxrxM[WV1MeUhP + 1] = ldq4EaMS;
					bLscF3XK = true;
				}
			}
		}
		int ip9kD75k = Math.min(fWD0xouP, hWgAxrxM.length);
		for (int nK7kNAnJ = ip9kD75k - 1; nK7kNAnJ >= 0; nK7kNAnJ--) {
			if (AyAW3GTw == null)
				a9cBaJY6.addElement(hWgAxrxM[nK7kNAnJ].n);
			else if (hWgAxrxM[nK7kNAnJ].n.startsWith(AyAW3GTw) && !hWgAxrxM[nK7kNAnJ].n.equals(AyAW3GTw))
				a9cBaJY6.addElement(hWgAxrxM[nK7kNAnJ].n);
		}
		return a9cBaJY6;
	}

}