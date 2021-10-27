class n3732503 {
	protected KMLRoot parseCachedKMLFile(URL nC0UpwJd, String JT2XA43c, String BEnyF7UV, boolean hXMBDyqt)
			throws IOException, XMLStreamException {
		KMLDoc CGX1kJZ5;
		InputStream LaV2EtfP = nC0UpwJd.openStream();
		if (KMLConstants.KMZ_MIME_TYPE.equals(BEnyF7UV))
			CGX1kJZ5 = new KMZInputStream(LaV2EtfP);
		else
			CGX1kJZ5 = new KMLInputStream(LaV2EtfP, WWIO.makeURI(JT2XA43c));
		try {
			KMLRoot ZPMzdrQx = new KMLRoot(CGX1kJZ5, hXMBDyqt);
			ZPMzdrQx.parse();
			return ZPMzdrQx;
		} catch (XMLStreamException uIDDamYH) {
			LaV2EtfP.close();
			throw uIDDamYH;
		}
	}

}