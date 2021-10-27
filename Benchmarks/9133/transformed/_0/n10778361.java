class n10778361 {
	public void writeData(String XQT1cmtG, int MrE8HutS, int ANZk2lPt, int HzlhGf2I, long hpT3gyH8, long x4R3CXDO,
			int[] HBE08Sr0) {
		PrintWriter I9ccpSAp = getWriter(XQT1cmtG + ".txt");
		I9ccpSAp.println("999 9999");
		I9ccpSAp.println("Doe, John");
		I9ccpSAp.println("TEST Lab");
		if (HzlhGf2I == 1)
			I9ccpSAp.println("PALMS Positive Ion Data");
		else if (HzlhGf2I == -1)
			I9ccpSAp.println("PALMS Negative Ion Data");
		else
			I9ccpSAp.println("PALMS GJIFJIGJ Ion Data");
		I9ccpSAp.println("TEST Mission");
		I9ccpSAp.println("1 1");
		I9ccpSAp.println("1970 01 01 2008 07 09");
		I9ccpSAp.println("0");
		I9ccpSAp.println("TIME (UT SECONDS)");
		I9ccpSAp.println(ANZk2lPt + 4);
		for (int YVxIluo5 = 0; YVxIluo5 < ANZk2lPt + 4; YVxIluo5++)
			I9ccpSAp.println("1.0");
		for (int y2DlcmIC = 0; y2DlcmIC < ANZk2lPt + 4; y2DlcmIC++)
			I9ccpSAp.println("9.9E29");
		I9ccpSAp.println("TOTION total MCP signal (electron units)");
		I9ccpSAp.println("HMASS high mass integral (fraction)");
		I9ccpSAp.println("UNLIST (unlisted low mass peaks (fraction)");
		I9ccpSAp.println("UFO unidentified peaks (fraction)");
		for (int OQpwIinC = 1; OQpwIinC <= ANZk2lPt; OQpwIinC++)
			I9ccpSAp.println("MS" + OQpwIinC + " (fraction)");
		int l8bg7qiN = 13;
		I9ccpSAp.println(l8bg7qiN);
		for (int zD8wlk2V = 0; zD8wlk2V < l8bg7qiN; zD8wlk2V++)
			I9ccpSAp.println("1.0");
		for (int kpQpdU8T = 0; kpQpdU8T < l8bg7qiN; kpQpdU8T++)
			I9ccpSAp.println("9.9E29");
		I9ccpSAp.println("AirCraftTime aircraft time (s)");
		I9ccpSAp.println("INDEX index ()");
		I9ccpSAp.println("SCAT scatter (V)");
		I9ccpSAp.println("JMETER joule meter ()");
		I9ccpSAp.println("ND neutral density (fraction)");
		I9ccpSAp.println("SCALEA Mass scale intercept (us)");
		I9ccpSAp.println("SCALEB mass scale slope (us)");
		I9ccpSAp.println("NUMPKS number of peaks ()");
		I9ccpSAp.println("CONF confidence (coded)");
		I9ccpSAp.println("CAT preliminary category ()");
		I9ccpSAp.println("AeroDiam aerodynamic diameter (um)");
		I9ccpSAp.println("AeroDiam1p7 aero diam if density=1.7 (um)");
		I9ccpSAp.println("TOTBACK total background subtracted (electron units)");
		I9ccpSAp.println("0");
		I9ccpSAp.println("0");
		String Go1M89X4 = "0.000000";
		for (int MbziVomZ = 0; MbziVomZ < MrE8HutS; MbziVomZ++) {
			I9ccpSAp.println(hpT3gyH8 + (x4R3CXDO * MbziVomZ));
			I9ccpSAp.println(hpT3gyH8 + (x4R3CXDO * MbziVomZ) - 3);
			I9ccpSAp.println(MbziVomZ + 1);
			for (int Ariq3uFG = 0; Ariq3uFG < 15; Ariq3uFG++)
				I9ccpSAp.println(Math.random());
			boolean ncFyzbcT = false;
			for (int aYQq4mFb = 1; aYQq4mFb <= ANZk2lPt; aYQq4mFb++) {
				for (int zVOOwKwx = 0; zVOOwKwx < HBE08Sr0.length && !ncFyzbcT; zVOOwKwx++)
					if (aYQq4mFb == HBE08Sr0[zVOOwKwx]) {
						double IVXD6NLo = (int) (1000000 * (zVOOwKwx + 1));
						I9ccpSAp.println(IVXD6NLo / 1000000);
						ncFyzbcT = true;
					}
				if (!ncFyzbcT)
					I9ccpSAp.println(Go1M89X4);
				ncFyzbcT = false;
			}
		}
		try {
			Scanner TQmt4lwx = new Scanner(f);
			while (TQmt4lwx.hasNext()) {
				System.out.println(TQmt4lwx.nextLine());
			}
			System.out.println("test");
		} catch (Exception WmSgiBCn) {
		}
		I9ccpSAp.close();
	}

}