class n4491957 {
	public void copyToCurrentDir(File god9XBp5, String HU2FY1XI) throws IOException {
		File pe56TrAA = new File(getCurrentPath() + File.separator + HU2FY1XI);
		FileReader K9foMznX;
		FileWriter DVyRxOrv;
		if (!pe56TrAA.exists()) {
			pe56TrAA.createNewFile();
		}
		K9foMznX = new FileReader(god9XBp5);
		DVyRxOrv = new FileWriter(pe56TrAA);
		int PwCZiI2K;
		while ((PwCZiI2K = K9foMznX.read()) != -1)
			DVyRxOrv.write(PwCZiI2K);
		K9foMznX.close();
		DVyRxOrv.close();
		reList();
	}

}