class n14053971 {
	private static String fetchUrl(String url, boolean keepLineEnds) throws IOException, MalformedURLException {
		BufferedReader br;
		URLConnection destConnection = (new URL(url)).openConnection();
		StringBuffer doc = new StringBuffer();
		String inputLine;
		String contentEncoding;
		destConnection.setRequestProperty("Accept-Encoding", "gzip");
		if (proxyAuth != null)
			destConnection.setRequestProperty("Proxy-Authorization", proxyAuth);
		destConnection.connect();
		contentEncoding = destConnection.getContentEncoding();
		if ((contentEncoding != null) && contentEncoding.equals("gzip")) {
			br = new BufferedReader(new InputStreamReader(new GZIPInputStream(destConnection.getInputStream())));
		} else {
			br = new BufferedReader(new InputStreamReader(destConnection.getInputStream()));
		}
		while ((inputLine = br.readLine()) != null) {
			if (keepLineEnds)
				doc.append(inputLine + "\n");
			else
				doc.append(inputLine);
		}
		br.close();
		return doc.toString();
	}

}