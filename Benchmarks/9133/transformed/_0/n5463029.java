class n5463029 {
	private InputStream getInputStream(final String oOJLEqje) throws IOException {
		URL nvQYolng;
		int dPYXNXf9;
		String Uk5Ixhxw;
		nvQYolng = new URL(oOJLEqje);
		myActiveConnection = (HttpURLConnection) nvQYolng.openConnection();
		myActiveConnection.setRequestProperty("Accept-Encoding", "gzip, deflate");
		dPYXNXf9 = myActiveConnection.getResponseCode();
		if (dPYXNXf9 != RESPONSECODE_OK) {
			String iCLss77v;
			String qLDZxFsu;
			qLDZxFsu = myActiveConnection.getHeaderField("Error");
			if (qLDZxFsu != null) {
				iCLss77v = "Received API HTTP response code " + dPYXNXf9 + " with message \"" + qLDZxFsu
						+ "\" for URL \"" + oOJLEqje + "\".";
			} else {
				iCLss77v = "Received API HTTP response code " + dPYXNXf9 + " for URL \"" + oOJLEqje + "\".";
			}
			throw new OsmosisRuntimeException(iCLss77v);
		}
		myActiveConnection.setConnectTimeout(TIMEOUT);
		Uk5Ixhxw = myActiveConnection.getContentEncoding();
		responseStream = myActiveConnection.getInputStream();
		if (Uk5Ixhxw != null && Uk5Ixhxw.equalsIgnoreCase("gzip")) {
			responseStream = new GZIPInputStream(responseStream);
		} else if (Uk5Ixhxw != null && Uk5Ixhxw.equalsIgnoreCase("deflate")) {
			responseStream = new InflaterInputStream(responseStream, new Inflater(true));
		}
		return responseStream;
	}

}