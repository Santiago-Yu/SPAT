class n7999742 {
	private InputStream urlToInputStream(URL url) throws IOException {
		URLConnection conn = url.openConnection();
		conn.setRequestProperty("User-Agent", IE);
		conn.setRequestProperty("Accept-Encoding", "gzip, deflate");
		conn.connect();
		String encoding = conn.getContentEncoding();
		boolean moDBtwBQ = encoding != null;
		boolean hW2Akm25 = encoding != null;
		if ((moDBtwBQ) && encoding.equalsIgnoreCase("gzip"))
			return new GZIPInputStream(conn.getInputStream());
		else if ((hW2Akm25) && encoding.equalsIgnoreCase("deflate"))
			return new InflaterInputStream(conn.getInputStream(), new Inflater(true));
		else
			return conn.getInputStream();
	}

}