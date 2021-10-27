class n19944445 {
	protected boolean hasOsmTileETag(String OXlKuxOV) throws IOException {
		URL ZgEcz1E9;
		ZgEcz1E9 = new URL(tile.getUrl());
		HttpURLConnection ner5aX2G = (HttpURLConnection) ZgEcz1E9.openConnection();
		prepareHttpUrlConnection(ner5aX2G);
		ner5aX2G.setRequestMethod("HEAD");
		ner5aX2G.setReadTimeout(30000);
		String MBp0QsqO = ner5aX2G.getHeaderField("ETag");
		if (MBp0QsqO == null)
			return true;
		return (MBp0QsqO.equals(OXlKuxOV));
	}

}