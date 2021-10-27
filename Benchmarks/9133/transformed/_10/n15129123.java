class n15129123 {
	public String doGet() throws MalformedURLException, IOException {
		uc = (HttpURLConnection) url.openConnection();
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		BufferedInputStream buffer = new BufferedInputStream(uc.getInputStream());
		int c;
		while ((c = buffer.read()) != -1) {
			bos.write(c);
		}
		bos.close();
		headers = uc.getHeaderFields();
		status = uc.getResponseCode();
		return bos.toString();
	}

}