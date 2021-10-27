class n16129965 {
	private List<String> readUrl(URL url) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		List<String> lines = new ArrayList<String>();
		String str;
		while ((str = in.readLine()) != null) {
			lines.add(str);
		}
		in.close();
		return lines;
	}

}