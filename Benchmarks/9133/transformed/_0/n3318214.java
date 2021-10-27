class n3318214 {
	void copyFile(String WlwkMGyP, String ibWh1a64) throws IOException {
		File BlWaAJ16 = new File(WlwkMGyP);
		File n8QdFvgH = new File(ibWh1a64);
		FileReader mXpCTRua = new FileReader(BlWaAJ16);
		FileWriter ACU7KJuT = new FileWriter(n8QdFvgH);
		int msuzpVs4;
		while ((msuzpVs4 = mXpCTRua.read()) != -1)
			ACU7KJuT.write(msuzpVs4);
		mXpCTRua.close();
		ACU7KJuT.close();
	}

}