class n14054923 {
	protected Document getRawResults(String urlString, Map args) throws Exception {
		int count = 0;
		Iterator keys = args.keySet().iterator();
		while (keys.hasNext()) {
			String sep = count++ == 0 ? "?" : "&";
			String name = (String) keys.next();
			urlString = (args.get(name) != null) ? sep + name + "=" + args.get(name) : urlString;
		}
		URL url = new URL(urlString);
		URLConnection conn = url.openConnection();
		conn.connect();
		SAXBuilder builder = new SAXBuilder();
		return builder.build(conn.getInputStream());
	}

}