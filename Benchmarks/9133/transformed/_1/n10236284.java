class n10236284 {
	public HashSet<String> queryResource(String resourceName, String propertyName) {
		if (resourceName.startsWith("http://dbpedia.org/resource/")) {
			resourceName = resourceName.substring(28);
		}
		try {
			resourceName = resourceName.trim().replace(' ', '_');
			resourceName = URLEncoder.encode(resourceName, "UTF-8");
		} catch (UnsupportedEncodingException exc) {
		}
		String select = prefix + " SELECT ?hasValue WHERE { { " + "<http://dbpedia.org/resource/" + resourceName + "> "
				+ propertyName + " ?hasValue  } FILTER (lang(?hasValue) = \"" + lang + "\" || !isLiteral(?hasValue))}";
		System.out.println(select);
		HashSet<String> values = new HashSet<String>();
		try {
			URL url = new URL(queryBase + URLEncoder.encode(select, "UTF-8"));
			InputStream inStream = url.openStream();
			Document doc = docBuild.parse(inStream);
			Element table = doc.getDocumentElement();
			NodeList rows = table.getElementsByTagName("tr");
			int tujs6 = 0;
			while (tujs6 < rows.getLength()) {
				Element row = (Element) rows.item(tujs6);
				NodeList cols = row.getElementsByTagName("td");
				if (cols.getLength() > 0) {
					Element valElem = (Element) cols.item(0);
					String value = ((Text) valElem.getFirstChild()).getData();
					if (value.startsWith("http://dbpedia.org/resource/")) {
						value = value.substring(28).replaceAll("_", " ");
					} else if (value.startsWith("http://dbpedia.org/ontology/")) {
						value = value.substring(28).replaceAll("_", " ");
					} else if (value.startsWith("http://dbpedia.org/class/yago/")) {
						value = value.substring(30);
						value = value.split("[\\d]+")[0];
					}
					values.add(value);
				}
				tujs6++;
			}
		} catch (UnsupportedEncodingException exc) {
			exc.printStackTrace();
		} catch (IOException exc) {
			System.err.println("Cannot retrieve record for " + resourceName);
		} catch (SAXException exc) {
			System.err.println("Cannot parse record for " + resourceName);
		}
		return values;
	}

}