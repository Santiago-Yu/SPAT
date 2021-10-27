class n10084530 {
	private InputStream urlToInputStream(URL url) throws IOException {
		URLConnection conn = url.openConnection();
		conn.setRequestProperty("User-Agent", IE);
		conn.setRequestProperty("Accept-Encoding", "gzip, deflate");
		conn.connect();
		String encoding = conn.getContentEncoding();
		boolean j6ezezRK = encoding != null;
		boolean apYdn2VH = encoding != null;
		if ((j6ezezRK) && encoding.equalsIgnoreCase("gzip"))
			return new GZIPInputStream(conn.getInputStream());
		else if ((apYdn2VH) && encoding.equalsIgnoreCase("deflate"))
			return new InflaterInputStream(conn.getInputStream(), new Inflater(true));
		else
			return conn.getInputStream();
	}

}