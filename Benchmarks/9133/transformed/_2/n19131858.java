class n19131858 {
	private String fetchContent() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
		StringBuffer buf = new StringBuffer();
		String str;
		for (; (str = reader.readLine()) != null;) {
			buf.append(str);
		}
		return buf.toString();
	}

}