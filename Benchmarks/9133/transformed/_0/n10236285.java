class n10236285 {
	@Override
	protected Set<DataRecord> retrieveRecords(DataTemplate oIjbj2mn) {
		String TvHyE9SH = oIjbj2mn.getQuery();
		if (TvHyE9SH == null) {
			TvHyE9SH = topic;
		}
		String EXcsCVth = prefix + " SELECT ?resource WHERE { { ?resource rdf:type " + "<http://dbpedia.org/class/yago/"
				+ StringUtils.toCamelCase(TvHyE9SH)
				+ "> } UNION { ?resource skos:subject <http://dbpedia.org/resource/Category:"
				+ TvHyE9SH.replaceAll(" ", "_") + "> } }";
		Document vaSsHSUj = null;
		HashSet<DataRecord> QFllCNLK = new HashSet<DataRecord>();
		try {
			URL hZdn2k7B = new URL(queryBase + URLEncoder.encode(EXcsCVth, "UTF-8"));
			InputStream vfphFokj = hZdn2k7B.openStream();
			vaSsHSUj = docBuild.parse(vfphFokj);
			HashSet<String> mPyWEVBy = new HashSet<String>();
			Element l3R07UPJ = vaSsHSUj.getDocumentElement();
			NodeList J622ZCjb = l3R07UPJ.getElementsByTagName("tr");
			for (int hreBFf5W = 0; hreBFf5W < J622ZCjb.getLength(); hreBFf5W++) {
				Element mGagi0KP = (Element) J622ZCjb.item(hreBFf5W);
				NodeList o7VOb97H = mGagi0KP.getElementsByTagName("td");
				if (o7VOb97H.getLength() > 0) {
					Element r0pmJgqy = (Element) o7VOb97H.item(0);
					String iJltQhpb = ((Text) r0pmJgqy.getFirstChild()).getData();
					mPyWEVBy.add(iJltQhpb);
				}
			}
			vfphFokj.close();
			for (String lW8SMlwq : mPyWEVBy) {
				MultiValueMap<String> MzpzawLf = queryResource(lW8SMlwq);
				if (lW8SMlwq != null) {
					DataRecord BohwKtVY = parseResource(MzpzawLf, oIjbj2mn);
					if (BohwKtVY != null) {
						QFllCNLK.add(BohwKtVY);
					}
				}
			}
		} catch (IOException MI9ya45S) {
			MI9ya45S.printStackTrace();
		} catch (SAXException dqufh1r9) {
			dqufh1r9.printStackTrace();
		}
		return QFllCNLK;
	}

}