class n10086563 {
	public void loadProfilefromConfig(String filename, P xslProfileClass, String profileTag)
			throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
		profileTag = (Val.chkStr(profileTag).equals("")) ? "Profile" : profileTag;
		String configuration_folder_path = this.getConfigurationFolderPath();
		if (configuration_folder_path == null || configuration_folder_path.length() == 0) {
			Properties properties = new Properties();
			final URL url = CswProfiles.class.getResource("CswCommon.properties");
			properties.load(url.openStream());
			configuration_folder_path = properties.getProperty("DEFAULT_CONFIGURATION_FOLDER_PATH");
		}
		DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		ResourcePath rscPath = new ResourcePath();
		InputSource configFile = rscPath.makeInputSource(configuration_folder_path + filename);
		configFile = (configFile == null) ? rscPath.makeInputSource("/" + configuration_folder_path + filename)
				: configFile;
		Document doc = builder.parse(configFile);
		NodeList profileNodes = doc.getElementsByTagName(profileTag);
		for (int i = 0; i < profileNodes.getLength(); i++) {
			Node currProfile = profileNodes.item(i);
			XPath xpath = XPathFactory.newInstance().newXPath();
			String id = Val.chkStr(xpath.evaluate("ID", currProfile));
			String name = Val.chkStr(xpath.evaluate("Name", currProfile));
			String description = Val.chkStr(xpath.evaluate("Description", currProfile));
			String requestXslt = Val.chkStr(xpath.evaluate("GetRecords/XSLTransformations/Request", currProfile));
			String expectedGptXmlOutput = Val
					.chkStr(xpath.evaluate("GetRecords/XSLTransformations/Request/@expectedGptXmlOutput", currProfile));
			expectedGptXmlOutput = (expectedGptXmlOutput.equals(""))
					? FORMAT_SEARCH_TO_XSL.MINIMAL_LEGACY_CSWCLIENT.toString()
					: expectedGptXmlOutput;
			String responseXslt = Val.chkStr(xpath.evaluate("GetRecords/XSLTransformations/Response", currProfile));
			String requestKVPs = Val.chkStr(xpath.evaluate("GetRecordByID/RequestKVPs", currProfile));
			String metadataXslt = Val.chkStr(xpath.evaluate("GetRecordByID/XSLTransformations/Response", currProfile));
			boolean extentSearch = Boolean.parseBoolean(Val.chkStr(xpath.evaluate("SupportSpatialQuery", currProfile)));
			boolean liveDataMaps = Boolean
					.parseBoolean(Val.chkStr(xpath.evaluate("SupportContentTypeQuery", currProfile)));
			boolean extentDisplay = Boolean
					.parseBoolean(Val.chkStr(xpath.evaluate("SupportSpatialBoundary", currProfile)));
			boolean harvestable = Boolean.parseBoolean(Val.chkStr(xpath.evaluate("Harvestable", currProfile)));
			requestXslt = configuration_folder_path + requestXslt;
			responseXslt = configuration_folder_path + responseXslt;
			metadataXslt = configuration_folder_path + metadataXslt;
			SearchXslProfile profile = null;
			try {
				profile = xslProfileClass.getClass().newInstance();
				profile.setId(id);
				profile.setName(name);
				profile.setDescription(description);
				profile.setRequestxslt(requestXslt);
				profile.setResponsexslt(responseXslt);
				profile.setMetadataxslt(metadataXslt);
				profile.setSupportsContentTypeQuery(liveDataMaps);
				profile.setSupportsSpatialBoundary(extentDisplay);
				profile.setSupportsSpatialQuery(extentSearch);
				profile.setKvp(requestKVPs);
				profile.setHarvestable(harvestable);
				profile.setFormatRequestToXsl(SearchXslProfile.FORMAT_SEARCH_TO_XSL.valueOf(expectedGptXmlOutput));
				profile.setFilter_extentsearch(extentSearch);
				profile.setFilter_livedatamap(liveDataMaps);
				addProfile((P) profile);
			} catch (InstantiationException e) {
				throw new IOException("Could not instantiate profile class" + e.getMessage());
			} catch (IllegalAccessException e) {
				throw new IOException("Could not instantiate profile class" + e.getMessage());
			}
		}
	}

}