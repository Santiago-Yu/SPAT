class n2684284 {
	public DAS getDAS() throws MalformedURLException, IOException, ParseException, DASException, DODSException {
		InputStream is;
		DAS das = new DAS();
		if (fileStream != null)
			is = parseMime(fileStream);
		else {
			URL url = new URL(urlString + ".das" + projString + selString);
			if (dumpDAS) {
				System.out.println("--DConnect.getDAS to " + url);
				copy(url.openStream(), System.out);
				System.out.println("\n--DConnect.getDAS END1");
				dumpBytes(url.openStream(), 100);
				System.out.println("\n-DConnect.getDAS END2");
			}
			is = openConnection(url);
		}
		try {
			das.parse(is);
		} finally {
			is.close();
			if (connection instanceof HttpURLConnection)
				((HttpURLConnection) connection).disconnect();
		}
		return das;
	}

}