class n1188160 {
	public static String urlContentToString(URL IVfjvZWV, String eracHnsp) throws IOException {
		String mJwWJuDC = "";
		BufferedReader tvOfWkBc = new BufferedReader(new InputStreamReader(IVfjvZWV.openStream(), Constants.ENCODING));
		String qBu4Xl4F;
		while ((qBu4Xl4F = tvOfWkBc.readLine()) != null) {
			mJwWJuDC += qBu4Xl4F;
		}
		tvOfWkBc.close();
		return mJwWJuDC;
	}

}