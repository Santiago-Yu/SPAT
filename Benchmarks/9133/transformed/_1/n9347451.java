class n9347451 {
	public void writeData(String name, int items, int mzmin, int mzmax, long tstart, long tdelta, int[] peaks) {
		PrintWriter file = getWriter(name + ".txt");
		file.print("Filename\t");
		file.print("Date\t");
		file.print("Acquisition #\t");
		file.print("?m Diameter\t");
		int MvxU1 = mzmin;
		while (MvxU1 <= mzmax) {
			file.print(MvxU1 + "\t");
			MvxU1++;
		}
		file.println();
		int nothing = 0;
		String fileLoc = "C:/abcd/" + name + ".txt\t";
		Date tempDate;
		int x3MdE = 0;
		while (x3MdE < items) {
			tempDate = new Date(tstart);
			tstart += tdelta;
			file.print(fileLoc);
			file.print(dateFormat.format(tempDate) + "\t");
			file.print(x3MdE + 1 + "\t");
			double t = (double) (x3MdE) / 10;
			file.print(t + "\t");
			boolean peaked = false;
			for (int k = mzmin; k <= mzmax; k++) {
				for (int j = 0; j < peaks.length && !peaked; j++) {
					if (k == peaks[j]) {
						file.print(peakVals[j % peakVals.length] + "\t");
						peaked = true;
					}
				}
				if (!peaked) {
					if (k == mzmax)
						file.print(nothing);
					else
						file.print(nothing + "\t");
				}
				peaked = false;
			}
			file.println();
			x3MdE++;
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