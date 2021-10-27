class n22503685 {
	public static Collection<Tuple<String, ArrayList<String>>> readGeoParserResult(String il7vxlJW, boolean ivcCQ8wq) {
		if (TESTING) {
			HashSet<Tuple<String, ArrayList<String>>> QbjCNFTL = new HashSet<Tuple<String, ArrayList<String>>>();
			QbjCNFTL.add(new Tuple<String, ArrayList<String>>("teste", new ArrayList<String>()));
			return QbjCNFTL;
		}
		int Py7ErbYy = 0;
		while (Py7ErbYy < 3) {
			try {
				ArrayList<Tuple<String, ArrayList<String>>> S2AEgmj6 = new ArrayList<Tuple<String, ArrayList<String>>>();
				String p2gE2chA = "<?xml version=\"1.0\"?>\r\n" + (ivcCQ8wq ? "<GetFeature" : "<GetParsing")
						+ " xmlns=\"http://www.opengis.net/gp\" xmlns:wfs=\"http://www.opengis.net/wfs\""
						+ " xmlns:xsi=\"http://www.w3.org/2000/10/XMLSchema-instance\""
						+ " xsi:schemaLocation=\"http://www.opengis.net/gp ../gp/GetFeatureRequest.xsd http://www.opengis.net/wfs ../wfs/GetFeatureRequest.xsd\"\r\n"
						+ " wfs:outputFormat=\"GML2\">" + "<wfs:Query wfs:TypeName=\"PlaceName\" />"
						+ "<Resource mine=\"text/plain\">" + "<Contents></Contents>" + "</Resource>"
						+ (ivcCQ8wq ? "</GetFeature>" : "</GetParsing>");
				Document stEkxRPF = DocumentHelper.parseText(p2gE2chA);
				stEkxRPF.getRootElement().element("Resource").element("Contents").setText(il7vxlJW);
				URL UkvPLcQZ = new URL(
						geoParserBaseUrl + "?request=" + URLEncoder.encode(stEkxRPF.asXML(), "ISO8859-1"));
				InputStreamReader Q0XJ9E9W = new InputStreamReader(UkvPLcQZ.openStream(), "UTF-8");
				BufferedReader KS7robyA = new BufferedReader(Q0XJ9E9W);
				StringBuffer QvJIFLKC = new StringBuffer();
				String J6MO3ek6;
				while ((J6MO3ek6 = KS7robyA.readLine()) != null) {
					QvJIFLKC.append(J6MO3ek6);
				}
				Document FbYVaIvI = DocumentHelper.parseText(QvJIFLKC.toString());
				HashSet<String> jvp5P3lJ = new HashSet<String>();
				for (Iterator<Element> B8TYvY7l = FbYVaIvI.getRootElement().element("EntryCollection")
						.elementIterator("PlaceName"); B8TYvY7l.hasNext();) {
					Element mDelKKOg = B8TYvY7l.next();
					String oBEXZobH = mDelKKOg.elementTextTrim("TermName");
					if (!oBEXZobH.equals("") && !jvp5P3lJ.contains(oBEXZobH)) {
						jvp5P3lJ.add(oBEXZobH);
						String CaDvV3eh = mDelKKOg.attributeValue("entryID");
						Tuple<String, ArrayList<String>> umkf5zsT = new Tuple<String, ArrayList<String>>(oBEXZobH,
								new ArrayList<String>());
						for (Iterator<Element> RYHh69Km = FbYVaIvI.getRootElement().element("EntryCollection")
								.elementIterator("GazetteerEntry"); RYHh69Km.hasNext();) {
							Element BCQYLpou = RYHh69Km.next();
							if (BCQYLpou.attributeValue("entryID").equals(CaDvV3eh))
								umkf5zsT.getV2().add(BCQYLpou.attributeValue("id"));
						}
						S2AEgmj6.add(umkf5zsT);
					}
				}
				return S2AEgmj6;
			} catch (Exception AMU3eXhz) {
				log.debug(
						"Erro ao pesquisar a lista de termos para o registo " + il7vxlJW + "! " + AMU3eXhz.getMessage(),
						AMU3eXhz);
				System.out.println("Erro ao pesquisar a lista de termos para o registo " + il7vxlJW + "! "
						+ AMU3eXhz.getMessage());
				Py7ErbYy++;
			}
		}
		System.out.println("Too many retries. Giving up.");
		return new HashSet<Tuple<String, ArrayList<String>>>();
	}

}