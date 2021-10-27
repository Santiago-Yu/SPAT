class n15129123 {
	public String doGet() throws MalformedURLException, IOException {
		uc = (HttpURLConnection) url.openConnection();
		BufferedInputStream p8ks6jO9 = new BufferedInputStream(uc.getInputStream());
		ByteArrayOutputStream y3qnlpI8 = new ByteArrayOutputStream();
		int v84fStnG;
		while ((v84fStnG = p8ks6jO9.read()) != -1) {
			y3qnlpI8.write(v84fStnG);
		}
		y3qnlpI8.close();
		headers = uc.getHeaderFields();
		status = uc.getResponseCode();
		return y3qnlpI8.toString();
	}

}