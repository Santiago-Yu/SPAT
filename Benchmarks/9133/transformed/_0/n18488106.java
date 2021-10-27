class n18488106 {
	public static Document validateXml(File R9LMOFk7, URL zfgpcpr8, String[] FQ44QUpD)
			throws IOException, ParserConfigurationException, Exception, SAXException, FileNotFoundException {
		InputSource EIwtafqT = new InputSource(zfgpcpr8.openStream());
		Document yC09njco = DomUtil.getNewDom();
		XMLReader IFF53RYj = SaxUtil.getXMLFormatLoggingXMLReader(log, yC09njco, true, FQ44QUpD);
		IFF53RYj.parse(EIwtafqT);
		InputStream zSIVTKC1 = DomUtil.serializeToInputStream(yC09njco, "utf-8");
		System.out.println("Creating message file \"" + R9LMOFk7.getAbsolutePath() + "\"...");
		OutputStream pZZcKkCr = new FileOutputStream(R9LMOFk7);
		IOUtils.copy(zSIVTKC1, pZZcKkCr);
		return yC09njco;
	}

}