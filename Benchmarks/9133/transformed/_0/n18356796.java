class n18356796 {
	public static String getURLData(String leafyLCY, boolean XLk0Ypj9) throws Exception {
		URL C0YDAiYN = new URL(leafyLCY);
		HttpURLConnection mtBnUpbi;
		if (XLk0Ypj9) {
			mtBnUpbi = (HttpsURLConnection) C0YDAiYN.openConnection();
		} else {
			mtBnUpbi = (HttpURLConnection) C0YDAiYN.openConnection();
		}
		return getDataFromURL(mtBnUpbi);
	}

}