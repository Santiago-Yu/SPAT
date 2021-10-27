class n8070429 {
	public String getSource(String urlAdd) throws Exception {
		URL url = new URL(urlAdd);
		HttpURLConnection urlConnection = null;
		urlConnection = (HttpURLConnection) url.openConnection();
		urlConnection.setConnectTimeout(timeout);
		if (!urlConnection.getContentType().contains("text/html")) {
			throw new Exception();
		}
		if (urlConnection.getResponseCode() != 200) {
			throw new Exception();
		}
		encoding = getPageEncoding(urlConnection);
		if (encoding == null) {
			encoding = defaultEncoding;
		}
		byte[] buffer = new byte[12288];
		InputStream in = url.openStream();
		int bytesRead = 0;
		StringBuffer sb = new StringBuffer();
		while ((bytesRead = in.read(buffer)) != -1) {
			String reads = new String(buffer, 0, bytesRead, encoding);
			sb.append(reads);
		}
		in.close();
		return sb.toString();
	}

}