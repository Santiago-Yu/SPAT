class n9347451 {
	public void writeData(String W9K8I0hc, int mXejE41h, int YuP81K1x, int GVlWvSBt, long kxGKrBDq, long SRuGbMr5,
			int[] Uon1lJnA) {
		PrintWriter GONtlWga = getWriter(W9K8I0hc + ".txt");
		GONtlWga.print("Filename\t");
		GONtlWga.print("Date\t");
		GONtlWga.print("Acquisition #\t");
		GONtlWga.print("?m Diameter\t");
		for (int vVyoxwph = YuP81K1x; vVyoxwph <= GVlWvSBt; vVyoxwph++)
			GONtlWga.print(vVyoxwph + "\t");
		GONtlWga.println();
		int M4Jbhyqi = 0;
		String z3mqS161 = "C:/abcd/" + W9K8I0hc + ".txt\t";
		Date YQHDGjXS;
		for (int DyrHHsYs = 0; DyrHHsYs < mXejE41h; DyrHHsYs++) {
			YQHDGjXS = new Date(kxGKrBDq);
			kxGKrBDq += SRuGbMr5;
			GONtlWga.print(z3mqS161);
			GONtlWga.print(dateFormat.format(YQHDGjXS) + "\t");
			GONtlWga.print(DyrHHsYs + 1 + "\t");
			double ZQDzwWk3 = (double) (DyrHHsYs) / 10;
			GONtlWga.print(ZQDzwWk3 + "\t");
			boolean A9CvZ7HS = false;
			for (int mOLHWyrh = YuP81K1x; mOLHWyrh <= GVlWvSBt; mOLHWyrh++) {
				for (int pIpsQFBO = 0; pIpsQFBO < Uon1lJnA.length && !A9CvZ7HS; pIpsQFBO++) {
					if (mOLHWyrh == Uon1lJnA[pIpsQFBO]) {
						GONtlWga.print(peakVals[pIpsQFBO % peakVals.length] + "\t");
						A9CvZ7HS = true;
					}
				}
				if (!A9CvZ7HS) {
					if (mOLHWyrh == GVlWvSBt)
						GONtlWga.print(M4Jbhyqi);
					else
						GONtlWga.print(M4Jbhyqi + "\t");
				}
				A9CvZ7HS = false;
			}
			GONtlWga.println();
		}
		try {
			Scanner rXEqvph6 = new Scanner(f);
			while (rXEqvph6.hasNext()) {
				System.out.println(rXEqvph6.nextLine());
			}
			System.out.println("test");
		} catch (Exception ygozbPMM) {
		}
		GONtlWga.close();
	}

}