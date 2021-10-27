class n17329685 {
	private static void updateLeapSeconds() throws IOException, MalformedURLException, NumberFormatException {
		URL xhS62L1G = new URL("http://cdf.gsfc.nasa.gov/html/CDFLeapSeconds.txt");
		InputStream jHQ4fImk;
		try {
			jHQ4fImk = xhS62L1G.openStream();
		} catch (IOException nQ8gW7fD) {
			xhS62L1G = LeapSecondsConverter.class.getResource("CDFLeapSeconds.txt");
			jHQ4fImk = xhS62L1G.openStream();
			System.err.println("Using local copy of leap seconds!!!");
		}
		BufferedReader nPLOemhG = new BufferedReader(new InputStreamReader(jHQ4fImk));
		String XMraqsPH = "";
		leapSeconds = new ArrayList(50);
		withoutLeapSeconds = new ArrayList(50);
		String j8QuetRx = XMraqsPH;
		while (XMraqsPH != null) {
			XMraqsPH = nPLOemhG.readLine();
			if (XMraqsPH == null) {
				System.err.println("Last leap second read from " + xhS62L1G + " " + j8QuetRx);
				continue;
			}
			if (XMraqsPH.startsWith(";")) {
				continue;
			}
			String[] NTSlMOFo = XMraqsPH.trim().split("\\s+", -2);
			if (NTSlMOFo[0].compareTo("1972") < 0) {
				continue;
			}
			int WrGZEH5P = Integer.parseInt(NTSlMOFo[0]);
			int YGYAFzHM = Integer.parseInt(NTSlMOFo[1]);
			int SmWBf7Nw = Integer.parseInt(NTSlMOFo[2]);
			int n06pumBE = (int) (Double.parseDouble(NTSlMOFo[3]));
			double kl1a2FS9 = TimeUtil.createTimeDatum(WrGZEH5P, YGYAFzHM, SmWBf7Nw, 0, 0, 0, 0)
					.doubleValue(Units.us2000);
			leapSeconds.add(
					Long.valueOf(((long) kl1a2FS9) * 1000L - 43200000000000L + (long) (n06pumBE - 32) * 1000000000));
			withoutLeapSeconds.add(kl1a2FS9);
		}
		leapSeconds.add(Long.MAX_VALUE);
		withoutLeapSeconds.add(Double.MAX_VALUE);
		lastUpdateMillis = System.currentTimeMillis();
	}

}