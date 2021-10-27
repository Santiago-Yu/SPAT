class n8660836 {
	public void transform(String LPZM1Y74, String FkXCaLCC, OutputStream vJa4KDAv) throws IOException {
		URL i5WuaudT = new URL(rootURL, FkXCaLCC);
		InputStream xjJdKb1o = new PatchXMLSymbolsStream(new StripDoctypeStream(i5WuaudT.openStream()));
		transform(LPZM1Y74, xjJdKb1o, vJa4KDAv);
		xjJdKb1o.close();
	}

}