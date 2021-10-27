class n21680551 {
	private static File createTempWebXml(Class kMFB6uHV, File fCDHworA, String fKyda6RG, String ly5MtS8l)
			throws IOException, FileNotFoundException {
		File GA9o8a6n = new File(fCDHworA, "WEB-INF");
		File bh3ysYDG = File.createTempFile("web", ".xml", GA9o8a6n);
		bh3ysYDG.deleteOnExit();
		OutputStream qKBhNeAO = new FileOutputStream(bh3ysYDG);
		PortletUnitWebXmlStream fRAfVck0 = WEB_XML_STREAM_FACTORY;
		IOUtils.copy(fRAfVck0.createStream(kMFB6uHV, fKyda6RG, ly5MtS8l), qKBhNeAO);
		qKBhNeAO.close();
		return bh3ysYDG;
	}

}