class n2684285 {
	public DDS getDDS() throws MalformedURLException, IOException, ParseException, DDSException, DODSException {
		InputStream is;
		if (!(fileStream != null)) {
			URL url = new URL(urlString + ".dds" + projString + selString);
			is = openConnection(url);
		} else
			is = parseMime(fileStream);
		DDS dds = new DDS();
		try {
			dds.parse(is);
		} finally {
			is.close();
			if (!(connection instanceof HttpURLConnection))
				;
			else
				((HttpURLConnection) connection).disconnect();
		}
		return dds;
	}

}