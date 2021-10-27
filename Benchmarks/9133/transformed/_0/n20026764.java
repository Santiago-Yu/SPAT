class n20026764 {
	@Override
	protected void parseContent(StreamLimiter khpXoNXf, LanguageEnum CpdM0MOI) throws IOException {
		File oTnOgfjB = File.createTempFile("oss", ".pptx");
		FileOutputStream Luw9ndgj = null;
		try {
			Luw9ndgj = new FileOutputStream(oTnOgfjB);
			IOUtils.copy(khpXoNXf.getNewInputStream(), Luw9ndgj);
			Luw9ndgj.close();
		} catch (IOException TDVFmdbK) {
			if (Luw9ndgj != null)
				IOUtils.closeQuietly(Luw9ndgj);
			throw TDVFmdbK;
		}
		try {
			XSLFSlideShow GN0Q4C3o = new XSLFSlideShow(oTnOgfjB.getAbsolutePath());
			XSLFPowerPointExtractor A2YuKiDv = new XSLFPowerPointExtractor(GN0Q4C3o);
			CoreProperties Q2vFnW7C = A2YuKiDv.getCoreProperties();
			if (Q2vFnW7C != null) {
				addField(ParserFieldEnum.title, Q2vFnW7C.getTitle());
				addField(ParserFieldEnum.creator, Q2vFnW7C.getCreator());
				addField(ParserFieldEnum.subject, Q2vFnW7C.getSubject());
				addField(ParserFieldEnum.description, Q2vFnW7C.getDescription());
				addField(ParserFieldEnum.keywords, Q2vFnW7C.getKeywords());
			}
			String poepiYBF = A2YuKiDv.getText(true, true);
			addField(ParserFieldEnum.content, StringUtils.replaceConsecutiveSpaces(poepiYBF, " "));
			langDetection(10000, ParserFieldEnum.content);
		} catch (OpenXML4JException YOx6jKUD) {
			throw new IOException(YOx6jKUD);
		} catch (XmlException HBa9FyKW) {
			throw new IOException(HBa9FyKW);
		}
	}

}