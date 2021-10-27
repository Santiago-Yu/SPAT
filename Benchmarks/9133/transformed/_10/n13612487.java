class n13612487 {
	private ArrayList<String> loadProperties(String filename) throws DevFailed, IOException {
		java.net.URL url = getClass().getResource(filename);
		if (url == null) {
			Except.throw_exception("LOAD_PROPERTY_FAILED", "URL for property file (" + filename + ") is null !",
					"PogoProperty.loadProperties()");
			return null;
		}
		InputStream is = url.openStream();
		ArrayList<String> vs = new ArrayList<String>();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String str;
		while ((str = br.readLine()) != null) {
			str = str.trim();
			if (!str.startsWith("#"))
				if (str.length() > 0)
					vs.add(str);
		}
		br.close();
		return vs;
	}

}