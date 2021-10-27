class n9872346 {
	public static synchronized Document readRemoteDocument(URL url, boolean validate)
			throws IOException, SAXParseException {
		Document document = null;
		if (DEBUG)
			System.out.println("DocumentUtilities.readDocument( " + url + ")");
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setNamespaceAware(true);
			factory.setCoalescing(true);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDefaultUseCaches(false);
			connection.setUseCaches(false);
			connection.setRequestProperty("User-Agent",
					"eXchaNGeR/" + System.getProperty("xngr.version") + " (http://xngr.org/)");
			connection.connect();
			InputStream stream = connection.getInputStream();
			document = factory.newDocumentBuilder().parse(stream);
			stream.close();
			connection.disconnect();
		} catch (SAXException e) {
			if (e instanceof SAXParseException) {
				throw (SAXParseException) e;
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		if (DEBUG)
			System.out.println("DocumentUtilities.readDocument( " + url + ") [" + document + "]");
		return document;
	}

}