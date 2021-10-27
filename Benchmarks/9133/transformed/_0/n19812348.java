class n19812348 {
	static ConversionMap create(String wWpFWAqx) {
		ConversionMap x0Q3brXU = new ConversionMap();
		URL OySQmShO = ConversionMap.class.getResource(wWpFWAqx);
		try {
			BufferedReader WIA9KYnc = new BufferedReader(new InputStreamReader(OySQmShO.openStream()));
			String znT0L0hi = WIA9KYnc.readLine();
			while (znT0L0hi != null) {
				if (znT0L0hi.length() > 0) {
					String[] Q8XbPqBX = znT0L0hi.split("\t");
					try {
						double HKFFelHF = Double.parseDouble(Q8XbPqBX[1]);
						x0Q3brXU.put(translate(lowercase(Q8XbPqBX[0].getBytes())), HKFFelHF);
						x0Q3brXU.defaultValue += HKFFelHF;
						x0Q3brXU.length = Q8XbPqBX[0].length();
					} catch (NumberFormatException uFNxsM17) {
						throw new RuntimeException("Something is wrong with in conversion file: " + uFNxsM17);
					}
				}
				znT0L0hi = WIA9KYnc.readLine();
			}
			WIA9KYnc.close();
			x0Q3brXU.defaultValue /= Math.pow(4, x0Q3brXU.length);
		} catch (Exception d9OmuEBe) {
			d9OmuEBe.printStackTrace();
			throw new RuntimeException("Their was an error while reading the conversion map: " + d9OmuEBe);
		}
		return x0Q3brXU;
	}

}