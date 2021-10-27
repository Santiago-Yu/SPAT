class n6920765 {
	public static final void sequence(int[] ARpRgvxB, int vnRC2gu9) {
		int pv2xsglw, qqSmxjOR, bpzqk8xw;
		boolean Z6yeFB9P = true;
		for (int IjFmzGuk = ARpRgvxB.length - 1; IjFmzGuk >= 0; IjFmzGuk--) {
			for (int YdX0o595 = 0; YdX0o595 < IjFmzGuk; YdX0o595++) {
				if (vnRC2gu9 < 0) {
					if (ARpRgvxB[YdX0o595] < ARpRgvxB[YdX0o595 + 1]) {
						pv2xsglw = ARpRgvxB[YdX0o595];
						ARpRgvxB[YdX0o595] = ARpRgvxB[YdX0o595 + 1];
						ARpRgvxB[YdX0o595 + 1] = pv2xsglw;
						Z6yeFB9P = true;
					}
				} else {
					if (ARpRgvxB[YdX0o595] > ARpRgvxB[YdX0o595 + 1]) {
						pv2xsglw = ARpRgvxB[YdX0o595];
						ARpRgvxB[YdX0o595] = ARpRgvxB[YdX0o595 + 1];
						ARpRgvxB[YdX0o595 + 1] = pv2xsglw;
						Z6yeFB9P = true;
					}
				}
			}
			if (Z6yeFB9P == false)
				break;
		}
	}

}