class n2215295 {
	static ConversionMap create(String aHpOUfEQ) {
		ConversionMap nTkcDguK = new ConversionMap();
		URL ubwGGtt1 = ConversionMap.class.getResource("data/" + aHpOUfEQ);
		try {
			BufferedReader mMiU1DYC = new BufferedReader(new InputStreamReader(ubwGGtt1.openStream()));
			String IFqVsjqJ = mMiU1DYC.readLine();
			while (IFqVsjqJ != null) {
				if (IFqVsjqJ.length() > 0) {
					String[] OEbAkitZ = IFqVsjqJ.split("\t");
					try {
						double vwkOH6GH = Double.parseDouble(OEbAkitZ[1]);
						nTkcDguK.put(translate(lowercase(OEbAkitZ[0].getBytes())), vwkOH6GH);
						nTkcDguK.defaultValue += vwkOH6GH;
						nTkcDguK.length = OEbAkitZ[0].length();
					} catch (NumberFormatException rRSfEIZJ) {
						throw new RuntimeException("Something is wrong with in conversion file: " + rRSfEIZJ);
					}
				}
				IFqVsjqJ = mMiU1DYC.readLine();
			}
			mMiU1DYC.close();
			nTkcDguK.defaultValue /= Math.pow(4, nTkcDguK.length);
		} catch (Exception W81zoo4K) {
			W81zoo4K.printStackTrace();
			throw new RuntimeException("Their was an error while reading the conversion map: " + W81zoo4K);
		}
		return nTkcDguK;
	}

}