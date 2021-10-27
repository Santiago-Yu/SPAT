class n18356796 {
	public static String getURLData(String stringUrl, boolean secure) throws Exception {
		URL url = new URL(stringUrl);
		HttpURLConnection httpURLConnection;
		httpURLConnection = (secure) ? (HttpsURLConnection) url.openConnection()
				: (HttpURLConnection) url.openConnection();
		return getDataFromURL(httpURLConnection);
	}

}