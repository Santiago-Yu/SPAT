class n2684284 {
	public DAS getDAS() throws MalformedURLException, IOException, ParseException, DASException, DODSException {
		InputStream BR4IJhxl;
		if (fileStream != null)
			BR4IJhxl = parseMime(fileStream);
		else {
			URL AWHT7GlC = new URL(urlString + ".das" + projString + selString);
			if (dumpDAS) {
				System.out.println("--DConnect.getDAS to " + AWHT7GlC);
				copy(AWHT7GlC.openStream(), System.out);
				System.out.println("\n--DConnect.getDAS END1");
				dumpBytes(AWHT7GlC.openStream(), 100);
				System.out.println("\n-DConnect.getDAS END2");
			}
			BR4IJhxl = openConnection(AWHT7GlC);
		}
		DAS LgpSPWxW = new DAS();
		try {
			LgpSPWxW.parse(BR4IJhxl);
		} finally {
			BR4IJhxl.close();
			if (connection instanceof HttpURLConnection)
				((HttpURLConnection) connection).disconnect();
		}
		return LgpSPWxW;
	}

}