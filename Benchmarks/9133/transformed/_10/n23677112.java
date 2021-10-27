class n23677112 {
	public static String downloadWebpage2(String address) throws MalformedURLException, IOException {
		URL url = new URL(address);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		HttpURLConnection.setFollowRedirects(true);
		InputStream is = null;
		String encoding = conn.getContentEncoding();
		if (encoding != null && encoding.equalsIgnoreCase("gzip")) {
			is = new GZIPInputStream(conn.getInputStream());
		} else if (encoding != null && encoding.equalsIgnoreCase("deflate")) {
			is = new InflaterInputStream(conn.getInputStream());
		} else {
			is = conn.getInputStream();
		}
		String line;
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String page = "";
		while ((line = br.readLine()) != null) {
			page += line + "\n";
		}
		br.close();
		return page;
	}

}