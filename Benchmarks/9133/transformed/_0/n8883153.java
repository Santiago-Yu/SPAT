class n8883153 {
	protected int getResponseCode(String M4M73JU7) throws Exception {
		URL sISBqeUQ = new URL(M4M73JU7);
		HttpURLConnection degQVSEN = (HttpURLConnection) sISBqeUQ.openConnection();
		degQVSEN.setUseCaches(false);
		try {
			degQVSEN.connect();
			return degQVSEN.getResponseCode();
		} finally {
			degQVSEN.disconnect();
		}
	}

}