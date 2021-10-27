class n11318551 {
	public static int best(int UO1PK6Cm, int Ie1bofem, int rAWZuhp7) {
		if ((Ie1bofem <= 0) || (UO1PK6Cm < 0) || (UO1PK6Cm > Ie1bofem) || (rAWZuhp7 < 0))
			return 0;
		int[] KHf0qzbi = new int[Ie1bofem];
		for (int WJr1JmQv = 0; WJr1JmQv < Ie1bofem; WJr1JmQv++)
			KHf0qzbi[WJr1JmQv] = d(rAWZuhp7);
		boolean l5kqMW17;
		do {
			l5kqMW17 = false;
			for (int mc6ioKNH = 0; mc6ioKNH < Ie1bofem - 1; mc6ioKNH++) {
				if (KHf0qzbi[mc6ioKNH] < KHf0qzbi[mc6ioKNH + 1]) {
					int zJ6dxkAX = KHf0qzbi[mc6ioKNH];
					KHf0qzbi[mc6ioKNH] = KHf0qzbi[mc6ioKNH + 1];
					KHf0qzbi[mc6ioKNH + 1] = zJ6dxkAX;
					l5kqMW17 = true;
				}
			}
		} while (l5kqMW17);
		int slDCRngv = 0;
		for (int STTXAFwp = 0; STTXAFwp < UO1PK6Cm; STTXAFwp++)
			slDCRngv += KHf0qzbi[STTXAFwp];
		return slDCRngv;
	}

}