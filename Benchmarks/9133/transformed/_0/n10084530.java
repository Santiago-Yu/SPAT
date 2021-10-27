class n10084530 {
	private InputStream urlToInputStream(URL CQANI9eX) throws IOException {
		URLConnection xNf7ie5f = CQANI9eX.openConnection();
		xNf7ie5f.setRequestProperty("User-Agent", IE);
		xNf7ie5f.setRequestProperty("Accept-Encoding", "gzip, deflate");
		xNf7ie5f.connect();
		String bpyncQNm = xNf7ie5f.getContentEncoding();
		if ((bpyncQNm != null) && bpyncQNm.equalsIgnoreCase("gzip"))
			return new GZIPInputStream(xNf7ie5f.getInputStream());
		else if ((bpyncQNm != null) && bpyncQNm.equalsIgnoreCase("deflate"))
			return new InflaterInputStream(xNf7ie5f.getInputStream(), new Inflater(true));
		else
			return xNf7ie5f.getInputStream();
	}

}