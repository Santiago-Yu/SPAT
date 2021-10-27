class n7406942 {
	private void getXMLData() {
		URL url = null;
		String result = null;
		BufferedReader rd = null;
		URLConnection conn = null;
		String line;
		StringBuffer sb = new StringBuffer();
		try {
			url = new URL(this.url);
			conn = url.openConnection();
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			while ((line = rd.readLine()) != null) {
				sb.append(line + "\n");
			}
			rd.close();
			result = sb.toString();
		} catch (MalformedURLException e) {
			log.error("URL was malformed: {}", url, e);
		} catch (IOException e) {
			log.error("IOException thrown: {}", url, e);
		}
		this.xmlString = result;
	}

}