class n7320804 {
	protected String getRequestContent(String CvA28aXN, String qoIgsu6h) throws Exception {
		URL Wr5pFQWg = new URL(CvA28aXN);
		HttpURLConnection WEFavGpf = (HttpURLConnection) Wr5pFQWg.openConnection();
		WEFavGpf.setRequestProperty("Referer", REFERER_STR);
		WEFavGpf.setRequestMethod(qoIgsu6h);
		WEFavGpf.setUseCaches(false);
		WEFavGpf.connect();
		BufferedReader IbKz7WMx = new BufferedReader(new InputStreamReader(WEFavGpf.getInputStream()));
		String mFtr890E = IbKz7WMx.readLine();
		IbKz7WMx.close();
		WEFavGpf.disconnect();
		return mFtr890E;
	}

}