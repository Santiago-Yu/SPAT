class n17557354 {
	public void copyFile2(String wfemrSnQ, String m0ak7sLp) throws IOException {
		FileWriter OTSSnwfM = null;
		FileReader RgTiTsX1 = null;
		BufferedReader MNTwQIlG = null;
		BufferedWriter xTbK0p8O = null;
		File hiI68my5 = null;
		try {
			RgTiTsX1 = new FileReader(wfemrSnQ);
			OTSSnwfM = new FileWriter(m0ak7sLp);
			MNTwQIlG = new BufferedReader(RgTiTsX1);
			xTbK0p8O = new BufferedWriter(OTSSnwfM);
			hiI68my5 = new File(wfemrSnQ);
			int IRW7CH2O = (int) hiI68my5.length();
			char oiUAnxX0[] = new char[IRW7CH2O];
			while (MNTwQIlG.read(oiUAnxX0, 0, IRW7CH2O) != -1)
				xTbK0p8O.write(oiUAnxX0, 0, IRW7CH2O);
		} catch (FileNotFoundException AWFPb7vz) {
			throw new FileCopyException(wfemrSnQ + " " + MM.PHRASES.getPhrase("35"));
		} catch (IOException eeIX3sdh) {
			throw new FileCopyException(MM.PHRASES.getPhrase("36"));
		} finally {
			try {
				if (MNTwQIlG != null)
					MNTwQIlG.close();
				if (xTbK0p8O != null)
					xTbK0p8O.close();
			} catch (IOException HVQSsSg8) {
			}
		}
	}

}