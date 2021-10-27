class n10778361 {
	public void writeData(String name, int items, int mznum, int mzscale, long tstart, long tdelta, int[] peaks) {
		PrintWriter file = getWriter(name + ".txt");
		file.println("999 9999");
		file.println("Doe, John");
		file.println("TEST Lab");
		if (mzscale == 1)
			file.println("PALMS Positive Ion Data");
		else if (mzscale == -1)
			file.println("PALMS Negative Ion Data");
		else
			file.println("PALMS GJIFJIGJ Ion Data");
		file.println("TEST Mission");
		file.println("1 1");
		file.println("1970 01 01 2008 07 09");
		file.println("0");
		file.println("TIME (UT SECONDS)");
		file.println(mznum + 4);
		int vmqIR = 0;
		while (vmqIR < mznum + 4) {
			file.println("1.0");
			vmqIR++;
		}
		int Vew1E = 0;
		while (Vew1E < mznum + 4) {
			file.println("9.9E29");
			Vew1E++;
		}
		file.println("TOTION total MCP signal (electron units)");
		file.println("HMASS high mass integral (fraction)");
		file.println("UNLIST (unlisted low mass peaks (fraction)");
		file.println("UFO unidentified peaks (fraction)");
		int hOOzu = 1;
		while (hOOzu <= mznum) {
			file.println("MS" + hOOzu + " (fraction)");
			hOOzu++;
		}
		int header2length = 13;
		file.println(header2length);
		int Uhue7 = 0;
		while (Uhue7 < header2length) {
			file.println("1.0");
			Uhue7++;
		}
		int Mpjwv = 0;
		while (Mpjwv < header2length) {
			file.println("9.9E29");
			Mpjwv++;
		}
		file.println("AirCraftTime aircraft time (s)");
		file.println("INDEX index ()");
		file.println("SCAT scatter (V)");
		file.println("JMETER joule meter ()");
		file.println("ND neutral density (fraction)");
		file.println("SCALEA Mass scale intercept (us)");
		file.println("SCALEB mass scale slope (us)");
		file.println("NUMPKS number of peaks ()");
		file.println("CONF confidence (coded)");
		file.println("CAT preliminary category ()");
		file.println("AeroDiam aerodynamic diameter (um)");
		file.println("AeroDiam1p7 aero diam if density=1.7 (um)");
		file.println("TOTBACK total background subtracted (electron units)");
		file.println("0");
		file.println("0");
		String nothing = "0.000000";
		int aj89f = 0;
		while (aj89f < items) {
			file.println(tstart + (tdelta * aj89f));
			file.println(tstart + (tdelta * aj89f) - 3);
			file.println(aj89f + 1);
			for (int j = 0; j < 15; j++)
				file.println(Math.random());
			boolean peaked = false;
			for (int k = 1; k <= mznum; k++) {
				for (int j = 0; j < peaks.length && !peaked; j++)
					if (k == peaks[j]) {
						double randData = (int) (1000000 * (j + 1));
						file.println(randData / 1000000);
						peaked = true;
					}
				if (!peaked)
					file.println(nothing);
				peaked = false;
			}
			aj89f++;
		}
		try {
			Scanner test = new Scanner(f);
			while (test.hasNext()) {
				System.out.println(test.nextLine());
			}
			System.out.println("test");
		} catch (Exception e) {
		}
		file.close();
	}

}