class n10086563 {
	public void loadProfilefromConfig(String VenjAf4v, P ZgkLmtKA, String etU6MYKw)
			throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
		if (Val.chkStr(etU6MYKw).equals("")) {
			etU6MYKw = "Profile";
		}
		String tlcYZmi8 = this.getConfigurationFolderPath();
		if (tlcYZmi8 == null || tlcYZmi8.length() == 0) {
			Properties CrGqbUjw = new Properties();
			final URL O7RlnMee = CswProfiles.class.getResource("CswCommon.properties");
			CrGqbUjw.load(O7RlnMee.openStream());
			tlcYZmi8 = CrGqbUjw.getProperty("DEFAULT_CONFIGURATION_FOLDER_PATH");
		}
		DocumentBuilder JkfH9OAI = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		ResourcePath YGhXchRc = new ResourcePath();
		InputSource TyheiBgH = YGhXchRc.makeInputSource(tlcYZmi8 + VenjAf4v);
		if (TyheiBgH == null) {
			TyheiBgH = YGhXchRc.makeInputSource("/" + tlcYZmi8 + VenjAf4v);
		}
		Document WYi5UTto = JkfH9OAI.parse(TyheiBgH);
		NodeList Dsqrfcjz = WYi5UTto.getElementsByTagName(etU6MYKw);
		for (int lC5nqLRd = 0; lC5nqLRd < Dsqrfcjz.getLength(); lC5nqLRd++) {
			Node ukZR7iEo = Dsqrfcjz.item(lC5nqLRd);
			XPath uJnuJBZ2 = XPathFactory.newInstance().newXPath();
			String JQqG65o4 = Val.chkStr(uJnuJBZ2.evaluate("ID", ukZR7iEo));
			String rXmBSjFc = Val.chkStr(uJnuJBZ2.evaluate("Name", ukZR7iEo));
			String lRwctHGG = Val.chkStr(uJnuJBZ2.evaluate("Description", ukZR7iEo));
			String XJNCkyS0 = Val.chkStr(uJnuJBZ2.evaluate("GetRecords/XSLTransformations/Request", ukZR7iEo));
			String TWkzhSZy = Val
					.chkStr(uJnuJBZ2.evaluate("GetRecords/XSLTransformations/Request/@expectedGptXmlOutput", ukZR7iEo));
			if (TWkzhSZy.equals("")) {
				TWkzhSZy = FORMAT_SEARCH_TO_XSL.MINIMAL_LEGACY_CSWCLIENT.toString();
			}
			String W6ybinLU = Val.chkStr(uJnuJBZ2.evaluate("GetRecords/XSLTransformations/Response", ukZR7iEo));
			String eMbJ08Zy = Val.chkStr(uJnuJBZ2.evaluate("GetRecordByID/RequestKVPs", ukZR7iEo));
			String oPCWkm4Z = Val.chkStr(uJnuJBZ2.evaluate("GetRecordByID/XSLTransformations/Response", ukZR7iEo));
			boolean ew7ZKuF3 = Boolean.parseBoolean(Val.chkStr(uJnuJBZ2.evaluate("SupportSpatialQuery", ukZR7iEo)));
			boolean anoZvLua = Boolean.parseBoolean(Val.chkStr(uJnuJBZ2.evaluate("SupportContentTypeQuery", ukZR7iEo)));
			boolean P4tGaG27 = Boolean.parseBoolean(Val.chkStr(uJnuJBZ2.evaluate("SupportSpatialBoundary", ukZR7iEo)));
			boolean hIBO9mZR = Boolean.parseBoolean(Val.chkStr(uJnuJBZ2.evaluate("Harvestable", ukZR7iEo)));
			XJNCkyS0 = tlcYZmi8 + XJNCkyS0;
			W6ybinLU = tlcYZmi8 + W6ybinLU;
			oPCWkm4Z = tlcYZmi8 + oPCWkm4Z;
			SearchXslProfile xFoHdno1 = null;
			try {
				xFoHdno1 = ZgkLmtKA.getClass().newInstance();
				xFoHdno1.setId(JQqG65o4);
				xFoHdno1.setName(rXmBSjFc);
				xFoHdno1.setDescription(lRwctHGG);
				xFoHdno1.setRequestxslt(XJNCkyS0);
				xFoHdno1.setResponsexslt(W6ybinLU);
				xFoHdno1.setMetadataxslt(oPCWkm4Z);
				xFoHdno1.setSupportsContentTypeQuery(anoZvLua);
				xFoHdno1.setSupportsSpatialBoundary(P4tGaG27);
				xFoHdno1.setSupportsSpatialQuery(ew7ZKuF3);
				xFoHdno1.setKvp(eMbJ08Zy);
				xFoHdno1.setHarvestable(hIBO9mZR);
				xFoHdno1.setFormatRequestToXsl(SearchXslProfile.FORMAT_SEARCH_TO_XSL.valueOf(TWkzhSZy));
				xFoHdno1.setFilter_extentsearch(ew7ZKuF3);
				xFoHdno1.setFilter_livedatamap(anoZvLua);
				addProfile((P) xFoHdno1);
			} catch (InstantiationException drjyoEhj) {
				throw new IOException("Could not instantiate profile class" + drjyoEhj.getMessage());
			} catch (IllegalAccessException ZqFOPXvK) {
				throw new IOException("Could not instantiate profile class" + ZqFOPXvK.getMessage());
			}
		}
	}

}