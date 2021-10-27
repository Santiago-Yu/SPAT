class n10236284 {
	public HashSet<String> queryResource(String i5lBtoDd, String bGqnJQZX) {
		if (i5lBtoDd.startsWith("http://dbpedia.org/resource/")) {
			i5lBtoDd = i5lBtoDd.substring(28);
		}
		try {
			i5lBtoDd = i5lBtoDd.trim().replace(' ', '_');
			i5lBtoDd = URLEncoder.encode(i5lBtoDd, "UTF-8");
		} catch (UnsupportedEncodingException a93ozG3W) {
		}
		String i6wnNuhu = prefix + " SELECT ?hasValue WHERE { { " + "<http://dbpedia.org/resource/" + i5lBtoDd + "> "
				+ bGqnJQZX + " ?hasValue  } FILTER (lang(?hasValue) = \"" + lang + "\" || !isLiteral(?hasValue))}";
		System.out.println(i6wnNuhu);
		HashSet<String> ZCr78rvn = new HashSet<String>();
		try {
			URL Uu83Gotf = new URL(queryBase + URLEncoder.encode(i6wnNuhu, "UTF-8"));
			InputStream TN1xQI0D = Uu83Gotf.openStream();
			Document geTPg5Rh = docBuild.parse(TN1xQI0D);
			Element nWJEXmbx = geTPg5Rh.getDocumentElement();
			NodeList pNq9lYVX = nWJEXmbx.getElementsByTagName("tr");
			for (int mCXeT4Oa = 0; mCXeT4Oa < pNq9lYVX.getLength(); mCXeT4Oa++) {
				Element KzQBPr7m = (Element) pNq9lYVX.item(mCXeT4Oa);
				NodeList cylFdDgm = KzQBPr7m.getElementsByTagName("td");
				if (cylFdDgm.getLength() > 0) {
					Element Nfa7fjJn = (Element) cylFdDgm.item(0);
					String bpzcKLEk = ((Text) Nfa7fjJn.getFirstChild()).getData();
					if (bpzcKLEk.startsWith("http://dbpedia.org/resource/")) {
						bpzcKLEk = bpzcKLEk.substring(28).replaceAll("_", " ");
					} else if (bpzcKLEk.startsWith("http://dbpedia.org/ontology/")) {
						bpzcKLEk = bpzcKLEk.substring(28).replaceAll("_", " ");
					} else if (bpzcKLEk.startsWith("http://dbpedia.org/class/yago/")) {
						bpzcKLEk = bpzcKLEk.substring(30);
						bpzcKLEk = bpzcKLEk.split("[\\d]+")[0];
					}
					ZCr78rvn.add(bpzcKLEk);
				}
			}
		} catch (UnsupportedEncodingException KisjHBwn) {
			KisjHBwn.printStackTrace();
		} catch (IOException suVb4kJo) {
			System.err.println("Cannot retrieve record for " + i5lBtoDd);
		} catch (SAXException iWLWzQJ6) {
			System.err.println("Cannot parse record for " + i5lBtoDd);
		}
		return ZCr78rvn;
	}

}