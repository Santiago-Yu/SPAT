class n9872346 {
	public static synchronized Document readRemoteDocument(URL JyZTfwb3, boolean n8XZImOo)
			throws IOException, SAXParseException {
		if (DEBUG)
			System.out.println("DocumentUtilities.readDocument( " + JyZTfwb3 + ")");
		Document eFw5qkgw = null;
		try {
			DocumentBuilderFactory hzCzH8K5 = DocumentBuilderFactory.newInstance();
			hzCzH8K5.setNamespaceAware(true);
			hzCzH8K5.setCoalescing(true);
			HttpURLConnection DP5rX72f = (HttpURLConnection) JyZTfwb3.openConnection();
			DP5rX72f.setDefaultUseCaches(false);
			DP5rX72f.setUseCaches(false);
			DP5rX72f.setRequestProperty("User-Agent",
					"eXchaNGeR/" + System.getProperty("xngr.version") + " (http://xngr.org/)");
			DP5rX72f.connect();
			InputStream MgNw8MD8 = DP5rX72f.getInputStream();
			eFw5qkgw = hzCzH8K5.newDocumentBuilder().parse(MgNw8MD8);
			MgNw8MD8.close();
			DP5rX72f.disconnect();
		} catch (SAXException RKlXeGer) {
			if (RKlXeGer instanceof SAXParseException) {
				throw (SAXParseException) RKlXeGer;
			}
		} catch (ParserConfigurationException elGMXkv0) {
			elGMXkv0.printStackTrace();
		}
		if (DEBUG)
			System.out.println("DocumentUtilities.readDocument( " + JyZTfwb3 + ") [" + eFw5qkgw + "]");
		return eFw5qkgw;
	}

}