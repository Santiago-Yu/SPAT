class n14054923 {
	protected Document getRawResults(String urlString, Map args) throws Exception {
		Iterator keys = args.keySet().iterator();
		int count = 0;
		while (keys.hasNext()) {
			String sep = count++ == 0 ? "?" : "&";
			String name = (String) keys.next();
			if (args.get(name) != null) {
				urlString += sep + name + "=" + args.get(name);
			}
		}
		URL url = new URL(urlString);
		URLConnection conn = url.openConnection();
		conn.connect();
		SAXBuilder builder = new SAXBuilder();
		return builder.build(conn.getInputStream());
	}

}