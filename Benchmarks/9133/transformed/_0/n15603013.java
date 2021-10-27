class n15603013 {
	public static URLConnection createConnection(URL MxVx7JH6) throws java.io.IOException {
		URLConnection OcptSWRW = MxVx7JH6.openConnection();
		if (OcptSWRW instanceof HttpURLConnection) {
			HttpURLConnection epCTkjFZ = (HttpURLConnection) OcptSWRW;
			epCTkjFZ.setRequestMethod("POST");
		}
		OcptSWRW.setDoInput(true);
		OcptSWRW.setDoOutput(true);
		OcptSWRW.setUseCaches(false);
		OcptSWRW.setDefaultUseCaches(false);
		return OcptSWRW;
	}

}