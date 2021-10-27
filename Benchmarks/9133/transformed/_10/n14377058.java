class n14377058 {
	public String process(URL url) throws IOException {
		InputStream is = url.openStream();
		String line, results = "";
		BufferedReader dis = new BufferedReader(new InputStreamReader(is));
		while ((line = dis.readLine()) != null) {
			results += line + "\n";
		}
		System.out.println(results);
		return results;
	}

}