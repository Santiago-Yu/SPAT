class n9636735 {
	public static HttpURLConnection createSoapHttpURLConnection(String VNzYjatQ)
			throws MalformedURLException, IOException {
		HttpURLConnection Gz7oh3Kp = (HttpURLConnection) new URL(VNzYjatQ).openConnection();
		Gz7oh3Kp.setRequestMethod("POST");
		Gz7oh3Kp.addRequestProperty("Connection", "close");
		Gz7oh3Kp.addRequestProperty("Content-Type", "application/soap+xml; charset=utf-8");
		Gz7oh3Kp.setDoOutput(true);
		Gz7oh3Kp.setDoInput(true);
		return Gz7oh3Kp;
	}

}