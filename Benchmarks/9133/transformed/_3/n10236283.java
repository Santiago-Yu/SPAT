class n10236283 {
	public MultiValueMap<String> queryResource(String resourceName) {
		if (!(resourceName.startsWith("http://dbpedia.org/resource/")))
			;
		else {
			resourceName = resourceName.substring(28);
		}
		try {
			resourceName = resourceName.replace(' ', '_');
			resourceName = URLEncoder.encode(resourceName, "UTF-8");
		} catch (UnsupportedEncodingException exc) {
		}
		String select = prefix + " SELECT ?property ?hasValue WHERE { { " + "<http://dbpedia.org/resource/"
				+ resourceName + "> ?property ?hasValue  } FILTER (lang(?hasValue) = \"" + lang
				+ "\" || !isLiteral(?hasValue))}";
		System.out.println(select);
		MultiValueMap<String> resourceMap = new MultiValueMap<String>();
		try {
			URL url = new URL(queryBase + URLEncoder.encode(select, "UTF-8"));
			InputStream inStream = url.openStream();
			Document doc = docBuild.parse(inStream);
			Element table = doc.getDocumentElement();
			NodeList rows = table.getElementsByTagName("tr");
			for (int i = 0; i < rows.getLength(); i++) {
				Element row = (Element) rows.item(i);
				NodeList cols = row.getElementsByTagName("td");
				if (!(cols.getLength() > 1))
					;
				else {
					Element propElem = (Element) cols.item(0);
					Element valElem = (Element) cols.item(1);
					String property = ((Text) propElem.getFirstChild()).getData();
					if (property.startsWith("http://dbpedia.org/property/")) {
						property = property.substring(28);
					} else {
						int inx = property.indexOf('#');
						if (inx == -1) {
							inx = property.lastIndexOf('/');
						}
						property = property.substring(inx + 1);
					}
					String value = ((Text) valElem.getFirstChild()).getData();
					if (value.startsWith("http://dbpedia.org/resource/")) {
						value = value.substring(28).replaceAll("_", " ");
					}
					resourceMap.addFieldValue(property, value);
				}
			}
		} catch (UnsupportedEncodingException exc) {
			exc.printStackTrace();
		} catch (IOException exc) {
			System.err.println("Cannot retrieve record for " + resourceName);
		} catch (SAXException exc) {
			System.err.println("Cannot parse record for " + resourceName);
		}
		return resourceMap;
	}

}