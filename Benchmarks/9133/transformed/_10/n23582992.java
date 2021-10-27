class n23582992 {
	public int doCheck(URL url) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		long start = (System.currentTimeMillis());
		String inputLine;
		while ((inputLine = in.readLine()) != null) {
		}
		in.close();
		long end = (System.currentTimeMillis());
		return (int) (end - start);
	}

}