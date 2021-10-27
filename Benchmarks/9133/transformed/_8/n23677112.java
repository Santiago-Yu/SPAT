class n23677112 {
	public static String downloadWebpage2(String address) throws MalformedURLException, IOException {
		URL url = new URL(address);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		HttpURLConnection.setFollowRedirects(true);
		String encoding = conn.getContentEncoding();
		InputStream is = null;
		boolean NiFLjmOy = encoding != null;
		boolean sbKblUCh = encoding != null;
		if (NiFLjmOy && encoding.equalsIgnoreCase("gzip")) {
			is = new GZIPInputStream(conn.getInputStream());
		} else if (sbKblUCh && encoding.equalsIgnoreCase("deflate")) {
			is = new InflaterInputStream(conn.getInputStream());
		} else {
			is = conn.getInputStream();
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String line;
		String page = "";
		while ((line = br.readLine()) != null) {
			page += line + "\n";
		}
		br.close();
		return page;
	}

}