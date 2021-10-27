class n11427406 {
	private static String makeLoginRequest(String PxJjm3iN, String b6myKgM4, String TMdfIOpk) throws IOException {
		URL KaWZ6G6d = new URL(PxJjm3iN);
		HttpURLConnection TiAvW02W = (HttpURLConnection) KaWZ6G6d.openConnection();
		TiAvW02W.setRequestMethod("POST");
		TiAvW02W.setDoInput(true);
		TiAvW02W.setDoOutput(true);
		TiAvW02W.setUseCaches(false);
		TiAvW02W.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		StringBuffer aLYAlI4F = new StringBuffer();
		aLYAlI4F.append("Email=").append(URLEncoder.encode(b6myKgM4, "UTF-8"));
		aLYAlI4F.append("&Passwd=").append(URLEncoder.encode(TMdfIOpk, "UTF-8"));
		aLYAlI4F.append("&source=").append(URLEncoder.encode("Google Base data API for OFBiz", "UTF-8"));
		aLYAlI4F.append("&service=").append(URLEncoder.encode("gbase", "UTF-8"));
		OutputStream ZD4GchiF = TiAvW02W.getOutputStream();
		ZD4GchiF.write(aLYAlI4F.toString().getBytes("UTF-8"));
		ZD4GchiF.close();
		int SoFXUQl3 = TiAvW02W.getResponseCode();
		InputStream yIL6g1O4;
		if (SoFXUQl3 == HttpURLConnection.HTTP_OK) {
			yIL6g1O4 = TiAvW02W.getInputStream();
		} else {
			yIL6g1O4 = TiAvW02W.getErrorStream();
		}
		return toString(yIL6g1O4);
	}

}