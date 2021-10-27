class n3169056 {
	private List<String> getHashesFrom(String webPage) {
		Vector<String> out = new Vector();
		try {
			URL url = new URL(webPage);
			String line;
			BufferedReader r = new BufferedReader(new InputStreamReader(url.openStream()));
			while ((line = r.readLine()) != null) {
				out.add(line);
			}
		} catch (Exception X) {
			return null;
		}
		return out;
	}

}