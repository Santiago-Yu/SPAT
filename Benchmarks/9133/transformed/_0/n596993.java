class n596993 {
	private String makeLoginRequest(URL II2drdVX) throws IOException {
		HttpURLConnection w3BZJKJG = (HttpURLConnection) II2drdVX.openConnection();
		w3BZJKJG.setRequestMethod("POST");
		w3BZJKJG.setDoInput(true);
		w3BZJKJG.setDoOutput(true);
		w3BZJKJG.setUseCaches(false);
		w3BZJKJG.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		StringBuilder tFvYqk58 = new StringBuilder();
		tFvYqk58.append("Email=").append(URLEncoder.encode(EMAIL, "UTF-8"));
		tFvYqk58.append("&Passwd=").append(URLEncoder.encode(PASSWORD, "UTF-8"));
		tFvYqk58.append("&service=").append(URLEncoder.encode(SERVICE, "UTF-8"));
		tFvYqk58.append("&source=").append(URLEncoder.encode("Google Base data API", "UTF-8"));
		OutputStream iO0IV143 = w3BZJKJG.getOutputStream();
		iO0IV143.write(tFvYqk58.toString().getBytes("UTF-8"));
		iO0IV143.close();
		int rWxKJLYa = w3BZJKJG.getResponseCode();
		InputStream HcEf5nkk;
		if (rWxKJLYa == HttpURLConnection.HTTP_OK) {
			HcEf5nkk = w3BZJKJG.getInputStream();
		} else {
			HcEf5nkk = w3BZJKJG.getErrorStream();
		}
		return toString(HcEf5nkk);
	}

}