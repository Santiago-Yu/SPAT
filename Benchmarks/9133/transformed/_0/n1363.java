class n1363 {
	public static int[] bubbleSortOtimizado(int... CFWj7o2I) {
		boolean QWx46SL5;
		int zVOsm8Ic = CFWj7o2I.length - 2;
		do {
			QWx46SL5 = false;
			for (int LNxdKP6g = 0; LNxdKP6g <= zVOsm8Ic; LNxdKP6g++) {
				if (CFWj7o2I[LNxdKP6g] > CFWj7o2I[LNxdKP6g + 1]) {
					int g1K0TvmL = CFWj7o2I[LNxdKP6g];
					CFWj7o2I[LNxdKP6g] = CFWj7o2I[LNxdKP6g + 1];
					CFWj7o2I[LNxdKP6g + 1] = g1K0TvmL;
					QWx46SL5 = true;
				}
			}
			zVOsm8Ic = zVOsm8Ic - 1;
		} while (QWx46SL5);
		return CFWj7o2I;
	}

}