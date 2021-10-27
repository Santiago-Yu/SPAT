class n23088983 {
	public Epg unmarshallFromUrl(URL url) throws IOException {
		String tmp = null;
		BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
		StringBuilder buffer = new StringBuilder();
		while ((tmp = reader.readLine()) != null) {
			buffer.append(tmp);
		}
		return unmarshall(buffer.toString().getBytes());
	}

}