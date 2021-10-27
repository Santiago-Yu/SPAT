class n19660893 {
	private String load(URL url) {
		BufferedReader r = null;
		try {
			StringBuffer buf = new StringBuffer();
			r = new BufferedReader(new InputStreamReader(url.openStream()));
			while (r.ready()) {
				buf.append(r.readLine()).append('\n');
			}
			r.close();
			return buf.toString();
		} catch (IOException e) {
			logger.severe("Could not load shader program: " + e);
			logger.logp(Level.SEVERE, getClass().getName(), "load(URL)", "Exception", e);
			return null;
		}
	}

}