class n14481931 {
	public static InputStream download_file(String sessionid, String key) {
		String urlString = "https://s2.cloud.cm/rpc/raw?c=Storage&m=download_file&key=" + key;
		InputStream is = null;
		try {
			URL url = new URL(urlString);
			String apple = "";
			Log.d("current running function name:", "download_file");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestProperty("Cookie", "PHPSESSID=" + sessionid);
			conn.setRequestMethod("POST");
			conn.setDoInput(true);
			is = conn.getInputStream();
			return is;
		} catch (Exception e) {
			e.printStackTrace();
			Log.d("download problem", "download problem");
		}
		return is;
	}

}