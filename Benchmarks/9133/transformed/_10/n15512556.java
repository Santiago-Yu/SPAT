class n15512556 {
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
			e.printStackTrace();
			return null;
		}
	}

}