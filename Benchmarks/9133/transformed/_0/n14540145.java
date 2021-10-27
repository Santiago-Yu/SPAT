class n14540145 {
	public void copyFile(String sA5eDzwv, String zoDPyhu3) throws IOException {
		File tapWBOdR = new File(sA5eDzwv);
		File hTaquSzb = new File(zoDPyhu3);
		Reader xrPpGtzX = null;
		Writer cHWEo3Eg = null;
		char[] sfqCQ8RU;
		int Sn3ANN8D;
		try {
			if (!tapWBOdR.exists() || !tapWBOdR.isFile())
				throw new FileCopyException("FileCopy: no such source file: " + sA5eDzwv);
			if (!tapWBOdR.canRead())
				throw new FileCopyException("FileCopy: source file " + "is unreadable: " + sA5eDzwv);
			if (hTaquSzb.exists()) {
				if (hTaquSzb.isFile()) {
					DataInputStream jeUN1alr = new DataInputStream(System.in);
					String znIugYM0;
					if (!hTaquSzb.canWrite())
						throw new FileCopyException("FileCopy: destination " + "file is unwriteable: " + zoDPyhu3);
				} else {
					throw new FileCopyException("FileCopy: destination " + "is not a file: " + zoDPyhu3);
				}
			} else {
				File OHjQYEIu = parent(hTaquSzb);
				if (!OHjQYEIu.exists())
					throw new FileCopyException("FileCopy: destination " + "directory doesn't exist: " + zoDPyhu3);
				if (!OHjQYEIu.canWrite())
					throw new FileCopyException("FileCopy: destination " + "directory is unwriteable: " + zoDPyhu3);
			}
			xrPpGtzX = new BufferedReader(new FileReader(tapWBOdR));
			cHWEo3Eg = new BufferedWriter(new FileWriter(hTaquSzb));
			sfqCQ8RU = new char[1024];
			while (true) {
				Sn3ANN8D = xrPpGtzX.read(sfqCQ8RU, 0, 1024);
				if (Sn3ANN8D == -1)
					break;
				cHWEo3Eg.write(sfqCQ8RU, 0, Sn3ANN8D);
			}
		} finally {
			if (xrPpGtzX != null) {
				try {
					xrPpGtzX.close();
				} catch (IOException Y9AhoHBl) {
					;
				}
			}
			if (cHWEo3Eg != null) {
				try {
					cHWEo3Eg.close();
				} catch (IOException SKrKONgA) {
					;
				}
			}
		}
	}

}