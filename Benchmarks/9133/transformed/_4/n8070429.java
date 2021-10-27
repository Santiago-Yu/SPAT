class n8070429 {
	public String getSource(String urlAdd) throws Exception {
		HttpURLConnection urlConnection = null;
		URL url = new URL(urlAdd);
		urlConnection = (HttpURLConnection) url.openConnection();
		urlConnection.setConnectTimeout(timeout);
		if (!urlConnection.getContentType().contains("text/html")) {
			throw new Exception();
		}
		if (urlConnection.getResponseCode() != 200) {
			throw new Exception();
		}
		encoding = getPageEncoding(urlConnection);
		encoding = (encoding == null) ? defaultEncoding : encoding;
		InputStream in = url.openStream();
		byte[] buffer = new byte[12288];
		StringBuffer sb = new StringBuffer();
		int bytesRead = 0;
		while ((bytesRead = in.read(buffer)) != -1) {
			String reads = new String(buffer, 0, bytesRead, encoding);
			sb.append(reads);
		}
		in.close();
		return sb.toString();
	}

}