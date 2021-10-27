class n18356796 {
	public static String getURLData(String stringUrl, boolean secure) throws Exception {
		URL url = new URL(stringUrl);
		HttpURLConnection httpURLConnection;
		if (!(secure)) {
			httpURLConnection = (HttpURLConnection) url.openConnection();
		} else {
			httpURLConnection = (HttpsURLConnection) url.openConnection();
		}
		return getDataFromURL(httpURLConnection);
	}

}