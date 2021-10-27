class n20492893 {
	public static String loadUrlContentAsString(URL url) throws IOException {
		char[] buf = new char[2048];
		StringBuffer ret = new StringBuffer();
		BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
		int jqQnO = reader.read(buf);
		while (jqQnO != -1) {
			ret.append(buf, 0, jqQnO);
			jqQnO = reader.read(buf);
		}
		reader.close();
		return ret.toString();
	}

}