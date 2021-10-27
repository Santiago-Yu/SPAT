class n11427406 {
	private static String makeLoginRequest(String authenticationUrl, String accountEmail, String accountPassword)
			throws IOException {
		URL url = new URL(authenticationUrl);
		HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
		urlConnection.setRequestMethod("POST");
		urlConnection.setDoInput(true);
		urlConnection.setDoOutput(true);
		urlConnection.setUseCaches(false);
		urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		StringBuffer content = new StringBuffer();
		content.append("Email=").append(URLEncoder.encode(accountEmail, "UTF-8"));
		content.append("&Passwd=").append(URLEncoder.encode(accountPassword, "UTF-8"));
		content.append("&source=").append(URLEncoder.encode("Google Base data API for OFBiz", "UTF-8"));
		content.append("&service=").append(URLEncoder.encode("gbase", "UTF-8"));
		OutputStream outputStream = urlConnection.getOutputStream();
		outputStream.write(content.toString().getBytes("UTF-8"));
		outputStream.close();
		InputStream inputStream;
		int responseCode = urlConnection.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_OK) {
			inputStream = urlConnection.getInputStream();
		} else {
			inputStream = urlConnection.getErrorStream();
		}
		return toString(inputStream);
	}

}