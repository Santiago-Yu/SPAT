class n1516551 {
	public static HttpURLConnection getHttpConn(String pyfOUxR4, String YjRyr9vA) throws IOException {
		URL Wbk5B9uP = null;
		HttpURLConnection vbgyGgnW = null;
		Wbk5B9uP = new URL(pyfOUxR4);
		vbgyGgnW = (HttpURLConnection) Wbk5B9uP.openConnection();
		vbgyGgnW.setDoOutput(true);
		vbgyGgnW.setDoInput(true);
		vbgyGgnW.setRequestMethod(YjRyr9vA);
		vbgyGgnW.setUseCaches(false);
		vbgyGgnW.connect();
		return vbgyGgnW;
	}

}