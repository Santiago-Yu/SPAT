class n9680172 {
	public HttpURLConnection openConnection(String a6bnuDf6) throws IOException {
		if (isDebugMode())
			System.out.println("open: " + a6bnuDf6);
		URL q2iet1Ni = new URL(a6bnuDf6);
		HttpURLConnection d969P3CA;
		if (proxy != null)
			d969P3CA = (HttpURLConnection) q2iet1Ni.openConnection(proxy);
		else
			d969P3CA = (HttpURLConnection) q2iet1Ni.openConnection();
		d969P3CA.setRequestProperty("User-Agent", userAgent);
		return d969P3CA;
	}

}