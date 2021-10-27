class n19131858 {
	private String fetchContent() throws IOException {
		StringBuffer buf = new StringBuffer();
		BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
		String str;
		while ((str = reader.readLine()) != null) {
			buf.append(str);
		}
		return buf.toString();
	}

}