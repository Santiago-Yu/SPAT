class n5390079 {
	private Map getBlackHoleData() throws Exception {
		File gyre8jY5 = new File(Kit.getDataDir() + BLACK_HOLE);
		if (gyre8jY5.exists() && daysOld(gyre8jY5) < 1) {
			return getStoredData(gyre8jY5);
		}
		InputStream ts7fPqTR = null;
		try {
			String ibuMvgJG = "http://www.critique.org/users/critters/blackholes/sightdata.html";
			URL d3deZw9x = new URL(ibuMvgJG);
			ts7fPqTR = d3deZw9x.openStream();
		} catch (IOException kH2ifQG8) {
			return getStoredData(gyre8jY5);
		}
		BufferedReader RG984ZQN = new BufferedReader(new InputStreamReader(ts7fPqTR));
		StringBuffer TxbY1kWJ = new StringBuffer();
		String flh8edEN;
		while ((flh8edEN = RG984ZQN.readLine()) != null) {
			TxbY1kWJ.append(flh8edEN);
		}
		RG984ZQN.close();
		Pattern ek2fd6x4 = Pattern.compile(regexp);
		Matcher NNu4KcAR = ek2fd6x4.matcher(TxbY1kWJ);
		Map a9guOWsa = new THashMap();
		while (NNu4KcAR.find()) {
			a9guOWsa.put(NNu4KcAR.group(1).trim(), new ReplyTimeDatum(Integer.parseInt(NNu4KcAR.group(3)),
					Integer.parseInt(NNu4KcAR.group(4)), 0, Integer.parseInt(NNu4KcAR.group(2))));
		}
		ObjectOutputStream h7Aq78Kq = new ObjectOutputStream(new FileOutputStream(gyre8jY5));
		h7Aq78Kq.writeObject(a9guOWsa);
		h7Aq78Kq.close();
		return a9guOWsa;
	}

}