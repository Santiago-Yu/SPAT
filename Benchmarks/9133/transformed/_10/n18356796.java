class n18356796 {
	public static String getURLData(String stringUrl, boolean secure) throws Exception {
		HttpURLConnection httpURLConnection;
		URL url = new URL(stringUrl);
		if (secure) {
			httpURLConnection = (HttpsURLConnection) url.openConnection();
		} else {
			httpURLConnection = (HttpURLConnection) url.openConnection();
		}
		return getDataFromURL(httpURLConnection);
	}

}