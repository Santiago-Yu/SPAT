class n5166269 {
	public void render(ParagraphElement cnt, double x, double y, Graphics2D g, LayoutingContext layoutingContext,
			FlowContext flowContext) {
		InlineImageContent ic = (InlineImageContent) cnt;
		try {
			URLConnection urlConn = ic.getUrl().openConnection();
			urlConn.setConnectTimeout(15000);
			ImageInputStream iis = ImageIO.createImageInputStream(urlConn.getInputStream());
			Iterator<ImageReader> readers = ImageIO.getImageReaders(iis);
			if (readers.hasNext()) {
				System.out.println("loading image " + ic.getUrl());
				ImageReader reader = readers.next();
				reader.setInput(iis, true);
				if (null == flowContext.pdfContext) {
					RenderedImage img = reader.readAsRenderedImage(0, null);
					renderOnGraphics(img, x, y, ic, g, layoutingContext, flowContext);
				} else {
					BufferedImage img = reader.read(0);
					renderDirectPdf(img, x, y, ic, g, layoutingContext, flowContext);
				}
				reader.dispose();
			} else
				System.err.println("cannot render image " + ic.getUrl() + " - no suitable reader!");
		} catch (Exception exc) {
			System.err.println("cannot render image " + ic.getUrl() + " due to exception:");
			System.err.println(exc);
			exc.printStackTrace(System.err);
		}
	}

}