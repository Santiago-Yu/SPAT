class n21566853 {
	public void readURL() throws Exception {
		URL url = new URL("http://www.google.com");
		URLConnection c = url.openConnection();
		Map<String, List<String>> headers = c.getHeaderFields();
		for (String s : headers.keySet()) {
			System.out.println(s + ": " + headers.get(s));
		}
		BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
		String line = reader.readLine();
		for (; line != null;) {
			System.out.println(line);
			line = reader.readLine();
		}
		reader.close();
	}

}