class n7999742 {
	private InputStream urlToInputStream(URL uRyi9DyQ) throws IOException {
		URLConnection tuvDyr7V = uRyi9DyQ.openConnection();
		tuvDyr7V.setRequestProperty("User-Agent", IE);
		tuvDyr7V.setRequestProperty("Accept-Encoding", "gzip, deflate");
		tuvDyr7V.connect();
		String YR5mtvln = tuvDyr7V.getContentEncoding();
		if ((YR5mtvln != null) && YR5mtvln.equalsIgnoreCase("gzip"))
			return new GZIPInputStream(tuvDyr7V.getInputStream());
		else if ((YR5mtvln != null) && YR5mtvln.equalsIgnoreCase("deflate"))
			return new InflaterInputStream(tuvDyr7V.getInputStream(), new Inflater(true));
		else
			return tuvDyr7V.getInputStream();
	}

}