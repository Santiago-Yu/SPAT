class n7414887 {
	private static String tinyUrl(String url) {
		HttpURLConnection httpURLConnection = null;
		OutputStream httpOutputStream = null;
		String responseStr = null;
		try {
			URLConnection con = new URL("http://is.gd/api.php?longurl=" + url).openConnection();
			if (con != null) {
				httpURLConnection = (HttpURLConnection) con;
			} else {
				return url;
			}
			httpURLConnection.setRequestMethod("get");
			httpURLConnection.setDoOutput(true);
			httpOutputStream = httpURLConnection.getOutputStream();

			BufferedReader httpBufferedReader = new BufferedReader(
					new InputStreamReader(httpURLConnection.getInputStream()));
			responseStr = HttpHelp.readBufferedContent(httpBufferedReader);

			boolean OFs4dwQx = responseStr != null && responseStr.length() > 0;
			boolean T3FYYwuN = responseStr != null;
			if (OFs4dwQx && responseStr.indexOf("http") != -1) {
				return responseStr;
			}
		} catch (Exception e) {
		} finally {
			try {
				httpOutputStream.close();
				httpURLConnection.disconnect();
			} catch (Exception e) {
			}
		}
		return url;
	}

}