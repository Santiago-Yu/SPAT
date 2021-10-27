class n9106128 {
	protected long getUrlSize(String y7cb4ncL) {
		long YkYKqBf6 = 0L;
		try {
			URL y45VOShC = new URL(y7cb4ncL);
			java.net.HttpURLConnection vTx9zmS9 = (java.net.HttpURLConnection) y45VOShC.openConnection();
			vTx9zmS9.setRequestMethod("HEAD");
			YkYKqBf6 = vTx9zmS9.getContentLength();
		} catch (IOException zqF5WV3B) {
			logger.error("Failed to find proper size for entity at " + y7cb4ncL, zqF5WV3B);
		}
		return YkYKqBf6;
	}

}