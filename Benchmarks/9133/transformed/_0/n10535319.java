class n10535319 {
	private static Collection<String> createTopLevelFiles(Configuration EGYBNJKk, Collections qMQn6WgW, Sets toB4vy9a)
			throws FlickrException, SAXException, IOException, JDOMException, TransformerException {
		Collection<String> DsSr4ENS = new HashSet<String>();
		File Z2OVL5Ia = getToplevelXmlFilename(EGYBNJKk.photosBaseDirectory);
		Logger.getLogger(FlickrDownload.class).info("Creating XML file " + Z2OVL5Ia.getAbsolutePath());
		MediaIndexer HwegIfEy = new XmlMediaIndexer(EGYBNJKk);
		Element LoXeqzAJ = new Element("flickr").addContent(XmlUtils.createApplicationXml())
				.addContent(XmlUtils.createUserXml(EGYBNJKk)).addContent(qMQn6WgW.createTopLevelXml())
				.addContent(toB4vy9a.createTopLevelXml()).addContent(new Stats(toB4vy9a).createStatsXml(HwegIfEy));
		DsSr4ENS.addAll(HwegIfEy.writeIndex());
		XmlUtils.outputXmlFile(Z2OVL5Ia, LoXeqzAJ);
		DsSr4ENS.add(Z2OVL5Ia.getName());
		Logger.getLogger(FlickrDownload.class).info("Copying support files and performing XSLT transformations");
		IOUtils.copyToFileAndCloseStreams(XmlUtils.class.getResourceAsStream("xslt/" + PHOTOS_CSS_FILENAME),
				new File(EGYBNJKk.photosBaseDirectory, PHOTOS_CSS_FILENAME));
		DsSr4ENS.add(PHOTOS_CSS_FILENAME);
		IOUtils.copyToFileAndCloseStreams(XmlUtils.class.getResourceAsStream("xslt/" + PLAY_ICON_FILENAME),
				new File(EGYBNJKk.photosBaseDirectory, PLAY_ICON_FILENAME));
		DsSr4ENS.add(PLAY_ICON_FILENAME);
		XmlUtils.performXsltTransformation(EGYBNJKk, "all_sets.xsl", Z2OVL5Ia,
				new File(EGYBNJKk.photosBaseDirectory, ALL_SETS_HTML_FILENAME));
		DsSr4ENS.add(ALL_SETS_HTML_FILENAME);
		XmlUtils.performXsltTransformation(EGYBNJKk, "all_collections.xsl", Z2OVL5Ia,
				new File(EGYBNJKk.photosBaseDirectory, ALL_COLLECTIONS_HTML_FILENAME));
		DsSr4ENS.add(ALL_COLLECTIONS_HTML_FILENAME);
		DsSr4ENS.add(Collections.COLLECTIONS_ICON_DIRECTORY);
		XmlUtils.performXsltTransformation(EGYBNJKk, "stats.xsl", Z2OVL5Ia,
				new File(EGYBNJKk.photosBaseDirectory, STATS_HTML_FILENAME));
		DsSr4ENS.add(STATS_HTML_FILENAME);
		toB4vy9a.performXsltTransformation();
		for (AbstractSet hEw8bZVM : toB4vy9a.getSets()) {
			DsSr4ENS.add(hEw8bZVM.getSetId());
		}
		return DsSr4ENS;
	}

}