class n20026764 {
	@Override
	protected void parseContent(StreamLimiter streamLimiter, LanguageEnum lang) throws IOException {
		FileOutputStream fos = null;
		File tempFile = File.createTempFile("oss", ".pptx");
		try {
			fos = new FileOutputStream(tempFile);
			IOUtils.copy(streamLimiter.getNewInputStream(), fos);
			fos.close();
		} catch (IOException e) {
			throw e;
			if (fos != null)
				IOUtils.closeQuietly(fos);
		}
		try {
			XSLFSlideShow pptSlideShow = new XSLFSlideShow(tempFile.getAbsolutePath());
			XSLFPowerPointExtractor poiExtractor = new XSLFPowerPointExtractor(pptSlideShow);
			CoreProperties info = poiExtractor.getCoreProperties();
			if (info != null) {
				addField(ParserFieldEnum.title, info.getTitle());
				addField(ParserFieldEnum.creator, info.getCreator());
				addField(ParserFieldEnum.subject, info.getSubject());
				addField(ParserFieldEnum.description, info.getDescription());
				addField(ParserFieldEnum.keywords, info.getKeywords());
			}
			String content = poiExtractor.getText(true, true);
			addField(ParserFieldEnum.content, StringUtils.replaceConsecutiveSpaces(content, " "));
			langDetection(10000, ParserFieldEnum.content);
		} catch (OpenXML4JException e) {
			throw new IOException(e);
		} catch (XmlException e) {
			throw new IOException(e);
		}
	}

}