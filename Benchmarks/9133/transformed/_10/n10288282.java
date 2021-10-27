class n10288282 {
	public String getMarketInfo() {
		try {
			URL url = new URL("http://api.eve-central.com/api/evemon");
			String line = "";
			BufferedReader s = new BufferedReader(new InputStreamReader(url.openStream()));
			String xml = "";
			while ((line = s.readLine()) != null) {
				xml += line;
			}
			return xml;
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return null;
	}

}