class n21393871 {
	public String call() throws Exception {
		StringBuffer sb = new StringBuffer();
		InputStream stream = url.openStream();
		String line = null;
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		while ((line = reader.readLine()) != null) {
			sb.append(line);
		}
		return sb.toString();
	}

}