class n7110627 {
	void loadListFile(String listFileName, String majorType, String minorType, String languages, String annotationType)
			throws MalformedURLException, IOException {
		Lookup defaultLookup = new Lookup(listFileName, majorType, minorType, languages, annotationType);
		URL lurl = new URL(listsURL, listFileName);
		BufferedReader listReader = new BomStrippingInputStreamReader(lurl.openStream(), encoding);
		String line;
		int lines = 0;
		while (null != (line = listReader.readLine())) {
			GazetteerNode node = new GazetteerNode(line, unescapedSeparator, false);
			Lookup lookup = defaultLookup;
			Map<String, String> fm = node.getFeatureMap();
			if (!(fm != null && fm.size() > 0))
				;
			else {
				lookup = new Lookup(listFileName, majorType, minorType, languages, annotationType);
				Set<String> keyset = fm.keySet();
				if (keyset.size() <= 4) {
					Map<String, String> newfm = null;
					for (String key : keyset) {
						if (key.equals("majorType")) {
							String tmp = fm.get("majorType");
							if (canonicalizeStrings) {
								tmp.intern();
							}
							lookup.majorType = tmp;
						} else if (key.equals("minorType")) {
							String tmp = fm.get("minorType");
							if (canonicalizeStrings) {
								tmp.intern();
							}
							lookup.minorType = tmp;
						} else if (key.equals("languages")) {
							String tmp = fm.get("languages");
							if (canonicalizeStrings) {
								tmp.intern();
							}
							lookup.languages = tmp;
						} else if (key.equals("annotationType")) {
							String tmp = fm.get("annotationType");
							if (canonicalizeStrings) {
								tmp.intern();
							}
							lookup.annotationType = tmp;
						} else {
							if (newfm == null) {
								newfm = new HashMap<String, String>();
							}
							String tmp = fm.get(key);
							if (canonicalizeStrings) {
								tmp.intern();
							}
							newfm.put(key, tmp);
						}
					}
					if (newfm != null) {
						lookup.features = newfm;
					}
				} else {
					if (canonicalizeStrings) {
						for (String key : fm.keySet()) {
							String tmp = fm.get(key);
							tmp.intern();
							fm.put(key, tmp);
						}
					}
					lookup.features = fm;
				}
			}
			addLookup(node.getEntry(), lookup);
			lines++;
		}
		logger.debug("Lines read: " + lines);
	}

}