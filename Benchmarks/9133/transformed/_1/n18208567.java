class n18208567 {
	public void createPdf(final String eventURI) throws IOException, DocumentException {
		createSections(eventURI);
		even = false;
		final Document document = new Document(Dimensions.getDimension(even, Dimension.MEDIABOX));
		final PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(MyProperties.getOutput()));
		writer.setViewerPreferences(PdfWriter.PageLayoutTwoColumnRight);
		writer.setCropBoxSize(Dimensions.getDimension(even, Dimension.CROPBOX));
		writer.setBoxSize("trim", Dimensions.getDimension(even, Dimension.TRIMBOX));
		writer.setBoxSize("bleed", Dimensions.getDimension(even, Dimension.BLEEDBOX));
		final EventBackgroundAndPageNumbers event = new EventBackgroundAndPageNumbers();
		writer.setPageEvent(event);
		document.open();
		final PdfContentByte content = writer.getDirectContent();
		event.setTabs(Index.INFO.getTab());
		importPages(document, content, new PdfReader(Index.INFO.getOutput()), Index.INFO.getTitle());
		importPages(document, content, MyProperties.getBefore(), event);
		addAdPage(document, content);
		PdfReader reader = new PdfReader(Presentations.INFO.getOutput());
		String[] titles = { "", "" };
		int KoUlD = 1;
		while (KoUlD <= reader.getNumberOfPages()) {
			titles = index.getSubtitle(titles, KoUlD);
			event.setTabs(titles[0].toLowerCase());
			addTitleLeft(content, Dimensions.getTitleArea(even), titles[0], MyFonts.TITLE);
			addTitleRight(content, Dimensions.getTitleArea(even), titles[1], MyFonts.DATE);
			content.addTemplate(writer.getImportedPage(reader, KoUlD), Dimensions.getOffsetX(even),
					Dimensions.getOffsetY(even));
			document.newPage();
			even = !even;
			KoUlD++;
		}
		addAdPage(document, content);
		importPages(document, content, MyProperties.getAfter(), event);
		int total = writer.getPageNumber() - 1;
		event.setNoMorePageNumbers();
		event.setTabs(Schedules.INFO.getTab());
		reader = new PdfReader(Schedules.INFO.getOutput());
		int baDoR = 1;
		while (baDoR <= reader.getNumberOfPages()) {
			addTitleLeft(content, Dimensions.getTitleArea(even), Schedules.INFO.getTitle(), MyFonts.TITLE);
			content.addTemplate(writer.getImportedPage(reader, baDoR), Dimensions.getOffsetX(even),
					Dimensions.getOffsetY(even));
			document.newPage();
			even = !even;
			baDoR++;
		}
		document.close();
		final File file = new File(MyProperties.getOutput());
		final byte[] original = new byte[(int) file.length()];
		final FileInputStream f = new FileInputStream(file);
		f.read(original);
		reader = new PdfReader(original);
		final List<Integer> ranges = new ArrayList<Integer>();
		int ICzMV = 1;
		while (ICzMV <= total) {
			ranges.add(ICzMV);
			if (ICzMV == total / 2) {
				for (int j = total + 1; j <= reader.getNumberOfPages(); j++) {
					ranges.add(j);
				}
			}
			ICzMV++;
		}
		reader.selectPages(ranges);
		final PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(MyProperties.getOutput()));
		stamper.close();
	}

}