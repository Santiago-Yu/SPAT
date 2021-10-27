class n23088983 {
	public Epg unmarshallFromUrl(URL p7SVYvvf) throws IOException {
		BufferedReader mpAu8VYn = new BufferedReader(new InputStreamReader(p7SVYvvf.openStream()));
		String cC7iIUHC = null;
		StringBuilder AjNcDNgg = new StringBuilder();
		while ((cC7iIUHC = mpAu8VYn.readLine()) != null) {
			AjNcDNgg.append(cC7iIUHC);
		}
		return unmarshall(AjNcDNgg.toString().getBytes());
	}

}