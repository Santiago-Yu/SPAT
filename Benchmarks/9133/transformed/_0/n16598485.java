class n16598485 {
	private void writeToUrl(byte[] UfXP65U4, String a9RrX0dq) throws IOException, MalformedURLException {
		HttpURLConnection ih3eOoKO = (HttpURLConnection) new URL(a9RrX0dq).openConnection();
		OutputStream uHcGx8tQ = ih3eOoKO.getOutputStream();
		uHcGx8tQ.write(UfXP65U4);
		uHcGx8tQ.flush();
		uHcGx8tQ.close();
	}

}