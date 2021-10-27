class n21393871 {
	public String call() throws Exception {
		InputStream stream = url.openStream();
		StringBuffer sb = new StringBuffer();
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		String line = null;
		for (; (line = reader.readLine()) != null;) {
			sb.append(line);
		}
		return sb.toString();
	}

}