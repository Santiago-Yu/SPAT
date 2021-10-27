class n5166269 {
	public void render(ParagraphElement eusd3VeE, double VI1THPaI, double bv5J3Bsi, Graphics2D aaF1Cxh8,
			LayoutingContext jy4Gjbpm, FlowContext aryevGt0) {
		InlineImageContent iRmmhkaf = (InlineImageContent) eusd3VeE;
		try {
			URLConnection U2G9FvzG = iRmmhkaf.getUrl().openConnection();
			U2G9FvzG.setConnectTimeout(15000);
			ImageInputStream iAsEHSEb = ImageIO.createImageInputStream(U2G9FvzG.getInputStream());
			Iterator<ImageReader> k40ywbhR = ImageIO.getImageReaders(iAsEHSEb);
			if (k40ywbhR.hasNext()) {
				System.out.println("loading image " + iRmmhkaf.getUrl());
				ImageReader qFqmGtle = k40ywbhR.next();
				qFqmGtle.setInput(iAsEHSEb, true);
				if (aryevGt0.pdfContext == null) {
					RenderedImage fKv42zLL = qFqmGtle.readAsRenderedImage(0, null);
					renderOnGraphics(fKv42zLL, VI1THPaI, bv5J3Bsi, iRmmhkaf, aaF1Cxh8, jy4Gjbpm, aryevGt0);
				} else {
					BufferedImage t5OMsfFR = qFqmGtle.read(0);
					renderDirectPdf(t5OMsfFR, VI1THPaI, bv5J3Bsi, iRmmhkaf, aaF1Cxh8, jy4Gjbpm, aryevGt0);
				}
				qFqmGtle.dispose();
			} else
				System.err.println("cannot render image " + iRmmhkaf.getUrl() + " - no suitable reader!");
		} catch (Exception mP1R5Qg8) {
			System.err.println("cannot render image " + iRmmhkaf.getUrl() + " due to exception:");
			System.err.println(mP1R5Qg8);
			mP1R5Qg8.printStackTrace(System.err);
		}
	}

}