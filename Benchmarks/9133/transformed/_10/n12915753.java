class n12915753 {
	private String readDataFromUrl(URL url) throws IOException {
		InputStreamReader streamReader = null;
		InputStream inputStream = null;
		StringBuffer data = new StringBuffer();
		BufferedReader in = null;
		try {
			inputStream = url.openStream();
			streamReader = new InputStreamReader(inputStream);
			String inputLine;
			in = new BufferedReader(streamReader);
			while ((inputLine = in.readLine()) != null)
				data.append(inputLine);
		} finally {
			if (in != null) {
				in.close();
			}
			if (streamReader != null) {
				streamReader.close();
			}
			if (inputStream != null) {
				inputStream.close();
			}
		}
		return data.toString();
	}

}