class n7110627 {
	void loadListFile(String Ccalvj8G, String AGqHnpAo, String FUSiTkdy, String InSmybmR, String WXEwZsAN)
			throws MalformedURLException, IOException {
		Lookup ZJmwmKsy = new Lookup(Ccalvj8G, AGqHnpAo, FUSiTkdy, InSmybmR, WXEwZsAN);
		URL YPa2N0NW = new URL(listsURL, Ccalvj8G);
		BufferedReader K1WltG3J = new BomStrippingInputStreamReader(YPa2N0NW.openStream(), encoding);
		String S1SODctz;
		int Pj3ItToD = 0;
		while (null != (S1SODctz = K1WltG3J.readLine())) {
			GazetteerNode gKYtFlEE = new GazetteerNode(S1SODctz, unescapedSeparator, false);
			Lookup C7Hx6hOh = ZJmwmKsy;
			Map<String, String> K6O9RCuv = gKYtFlEE.getFeatureMap();
			if (K6O9RCuv != null && K6O9RCuv.size() > 0) {
				C7Hx6hOh = new Lookup(Ccalvj8G, AGqHnpAo, FUSiTkdy, InSmybmR, WXEwZsAN);
				Set<String> MSnSpqXd = K6O9RCuv.keySet();
				if (MSnSpqXd.size() <= 4) {
					Map<String, String> g4FAVCNq = null;
					for (String TiNaC4Od : MSnSpqXd) {
						if (TiNaC4Od.equals("majorType")) {
							String LgY8VNkD = K6O9RCuv.get("majorType");
							if (canonicalizeStrings) {
								LgY8VNkD.intern();
							}
							C7Hx6hOh.majorType = LgY8VNkD;
						} else if (TiNaC4Od.equals("minorType")) {
							String xCvOwbna = K6O9RCuv.get("minorType");
							if (canonicalizeStrings) {
								xCvOwbna.intern();
							}
							C7Hx6hOh.minorType = xCvOwbna;
						} else if (TiNaC4Od.equals("languages")) {
							String rQR3OET9 = K6O9RCuv.get("languages");
							if (canonicalizeStrings) {
								rQR3OET9.intern();
							}
							C7Hx6hOh.languages = rQR3OET9;
						} else if (TiNaC4Od.equals("annotationType")) {
							String FSgqznRO = K6O9RCuv.get("annotationType");
							if (canonicalizeStrings) {
								FSgqznRO.intern();
							}
							C7Hx6hOh.annotationType = FSgqznRO;
						} else {
							if (g4FAVCNq == null) {
								g4FAVCNq = new HashMap<String, String>();
							}
							String VT1hCGn1 = K6O9RCuv.get(TiNaC4Od);
							if (canonicalizeStrings) {
								VT1hCGn1.intern();
							}
							g4FAVCNq.put(TiNaC4Od, VT1hCGn1);
						}
					}
					if (g4FAVCNq != null) {
						C7Hx6hOh.features = g4FAVCNq;
					}
				} else {
					if (canonicalizeStrings) {
						for (String cQPMOB2B : K6O9RCuv.keySet()) {
							String eisDY1lG = K6O9RCuv.get(cQPMOB2B);
							eisDY1lG.intern();
							K6O9RCuv.put(cQPMOB2B, eisDY1lG);
						}
					}
					C7Hx6hOh.features = K6O9RCuv;
				}
			}
			addLookup(gKYtFlEE.getEntry(), C7Hx6hOh);
			Pj3ItToD++;
		}
		logger.debug("Lines read: " + Pj3ItToD);
	}

}