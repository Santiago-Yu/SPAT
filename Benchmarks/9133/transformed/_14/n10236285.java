class n10236285 {
	@Override
	protected Set<DataRecord> retrieveRecords(DataTemplate template) {
		String query = template.getQuery();
		if (null == query) {
			query = topic;
		}
		String select = prefix + " SELECT ?resource WHERE { { ?resource rdf:type " + "<http://dbpedia.org/class/yago/"
				+ StringUtils.toCamelCase(query)
				+ "> } UNION { ?resource skos:subject <http://dbpedia.org/resource/Category:"
				+ query.replaceAll(" ", "_") + "> } }";
		Document doc = null;
		HashSet<DataRecord> recs = new HashSet<DataRecord>();
		try {
			URL url = new URL(queryBase + URLEncoder.encode(select, "UTF-8"));
			InputStream inStream = url.openStream();
			doc = docBuild.parse(inStream);
			HashSet<String> resourceNames = new HashSet<String>();
			Element table = doc.getDocumentElement();
			NodeList rows = table.getElementsByTagName("tr");
			for (int i = 0; i < rows.getLength(); i++) {
				Element row = (Element) rows.item(i);
				NodeList cols = row.getElementsByTagName("td");
				if (cols.getLength() > 0) {
					Element elem = (Element) cols.item(0);
					String resource = ((Text) elem.getFirstChild()).getData();
					resourceNames.add(resource);
				}
			}
			inStream.close();
			for (String resource : resourceNames) {
				MultiValueMap<String> resRecord = queryResource(resource);
				if (resource != null) {
					DataRecord rec = parseResource(resRecord, template);
					if (rec != null) {
						recs.add(rec);
					}
				}
			}
		} catch (IOException exc) {
			exc.printStackTrace();
		} catch (SAXException exc) {
			exc.printStackTrace();
		}
		return recs;
	}

}