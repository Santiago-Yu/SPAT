class n10236283 {
	public MultiValueMap<String> queryResource(String fFqpuosO) {
		if (fFqpuosO.startsWith("http://dbpedia.org/resource/")) {
			fFqpuosO = fFqpuosO.substring(28);
		}
		try {
			fFqpuosO = fFqpuosO.replace(' ', '_');
			fFqpuosO = URLEncoder.encode(fFqpuosO, "UTF-8");
		} catch (UnsupportedEncodingException Gn3BJBRB) {
		}
		String rRwyjT38 = prefix + " SELECT ?property ?hasValue WHERE { { " + "<http://dbpedia.org/resource/" + fFqpuosO
				+ "> ?property ?hasValue  } FILTER (lang(?hasValue) = \"" + lang + "\" || !isLiteral(?hasValue))}";
		System.out.println(rRwyjT38);
		MultiValueMap<String> xEKad42V = new MultiValueMap<String>();
		try {
			URL STKa6YpW = new URL(queryBase + URLEncoder.encode(rRwyjT38, "UTF-8"));
			InputStream rYczcpfA = STKa6YpW.openStream();
			Document cpDzLuqe = docBuild.parse(rYczcpfA);
			Element e4ADvDDh = cpDzLuqe.getDocumentElement();
			NodeList laaPWgda = e4ADvDDh.getElementsByTagName("tr");
			for (int Ble0TIug = 0; Ble0TIug < laaPWgda.getLength(); Ble0TIug++) {
				Element jxbXEpaV = (Element) laaPWgda.item(Ble0TIug);
				NodeList TvRH2mWr = jxbXEpaV.getElementsByTagName("td");
				if (TvRH2mWr.getLength() > 1) {
					Element rFUUyVZr = (Element) TvRH2mWr.item(0);
					Element K8kVF1G4 = (Element) TvRH2mWr.item(1);
					String Q7FsNrBs = ((Text) rFUUyVZr.getFirstChild()).getData();
					if (Q7FsNrBs.startsWith("http://dbpedia.org/property/")) {
						Q7FsNrBs = Q7FsNrBs.substring(28);
					} else {
						int u4YyulvI = Q7FsNrBs.indexOf('#');
						if (u4YyulvI == -1) {
							u4YyulvI = Q7FsNrBs.lastIndexOf('/');
						}
						Q7FsNrBs = Q7FsNrBs.substring(u4YyulvI + 1);
					}
					String rT28OilF = ((Text) K8kVF1G4.getFirstChild()).getData();
					if (rT28OilF.startsWith("http://dbpedia.org/resource/")) {
						rT28OilF = rT28OilF.substring(28).replaceAll("_", " ");
					}
					xEKad42V.addFieldValue(Q7FsNrBs, rT28OilF);
				}
			}
		} catch (UnsupportedEncodingException LuPg8a77) {
			LuPg8a77.printStackTrace();
		} catch (IOException NSkkeKzC) {
			System.err.println("Cannot retrieve record for " + fFqpuosO);
		} catch (SAXException A0YFuyOd) {
			System.err.println("Cannot parse record for " + fFqpuosO);
		}
		return xEKad42V;
	}

}