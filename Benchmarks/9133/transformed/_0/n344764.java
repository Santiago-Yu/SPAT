class n344764 {
	static HttpURLConnection connect(String zcowyZen, String lNIuiHj6, String fDN98OXR, String Jnfk6Wgm, int j1KknK7U)
			throws ProtocolException, IOException, MalformedURLException, UnsupportedEncodingException {
		HttpURLConnection pcJvWdSr = (HttpURLConnection) (new URL(zcowyZen).openConnection());
		pcJvWdSr.setRequestMethod(lNIuiHj6);
		pcJvWdSr.setConnectTimeout(j1KknK7U);
		byte[] CTlTcUUC = null;
		if (Jnfk6Wgm != null && Jnfk6Wgm.length() > 0) {
			pcJvWdSr.setDoOutput(true);
			pcJvWdSr.setRequestProperty("Content-Type", fDN98OXR);
			CTlTcUUC = Jnfk6Wgm.getBytes("UTF-8");
			pcJvWdSr.setFixedLengthStreamingMode(CTlTcUUC.length);
		}
		pcJvWdSr.connect();
		if (CTlTcUUC != null) {
			OutputStream dLccNUiU = pcJvWdSr.getOutputStream();
			dLccNUiU.write(CTlTcUUC);
			dLccNUiU.flush();
			dLccNUiU.close();
		}
		return pcJvWdSr;
	}

}