class n2684285 {
	public DDS getDDS() throws MalformedURLException, IOException, ParseException, DDSException, DODSException {
		InputStream VlM47w8y;
		if (fileStream != null)
			VlM47w8y = parseMime(fileStream);
		else {
			URL N5L4YqXY = new URL(urlString + ".dds" + projString + selString);
			VlM47w8y = openConnection(N5L4YqXY);
		}
		DDS WMQgTT6A = new DDS();
		try {
			WMQgTT6A.parse(VlM47w8y);
		} finally {
			VlM47w8y.close();
			if (connection instanceof HttpURLConnection)
				((HttpURLConnection) connection).disconnect();
		}
		return WMQgTT6A;
	}

}