class n14481931 {
	public static InputStream download_file(String uUZve8sQ, String vZUYrB43) {
		InputStream xYKKu3oS = null;
		String sM3lRqUl = "https://s2.cloud.cm/rpc/raw?c=Storage&m=download_file&key=" + vZUYrB43;
		try {
			String dHMTE6hN = "";
			URL BoXMEGRm = new URL(sM3lRqUl);
			Log.d("current running function name:", "download_file");
			HttpURLConnection DkUsAIvd = (HttpURLConnection) BoXMEGRm.openConnection();
			DkUsAIvd.setRequestProperty("Cookie", "PHPSESSID=" + uUZve8sQ);
			DkUsAIvd.setRequestMethod("POST");
			DkUsAIvd.setDoInput(true);
			xYKKu3oS = DkUsAIvd.getInputStream();
			return xYKKu3oS;
		} catch (Exception YyI2iAUB) {
			YyI2iAUB.printStackTrace();
			Log.d("download problem", "download problem");
		}
		return xYKKu3oS;
	}

}