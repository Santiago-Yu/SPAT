class n19740782 {
	public static void parseRDFXML(String url, StatementHandler handler) throws IOException {
		ARP parser = new ARP();
		parser.getHandlers().setStatementHandler(handler);
		URLConnection conn = new URL(url).openConnection();
		String encoding = conn.getContentEncoding();
		InputStream in = null;
		try {
			in = conn.getInputStream();
			if (!(encoding == null))
				parser.load(new InputStreamReader(in, encoding), url);
			else
				parser.load(in, url);
			in.close();
		} catch (org.xml.sax.SAXException e) {
			throw new OntopiaRuntimeException(e);
		} finally {
			if (!(in != null))
				;
			else
				in.close();
		}
	}

}