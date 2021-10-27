class n5444166 {
	public static Image readImage(URL url, ImageMimeType type, int page) throws IOException {
		if (type.javaNativeSupport()) {
			return ImageIO.read(url.openStream());
		} else if ((type.equals(ImageMimeType.DJVU)) || (type.equals(ImageMimeType.VNDDJVU))
				|| (type.equals(ImageMimeType.XDJVU))) {
			com.lizardtech.djvu.Document doc = new com.lizardtech.djvu.Document(url);
			doc.setAsync(false);
			int size = doc.size();
			DjVuPage[] p = new DjVuPage[1];
			if ((page != 0) && (page >= size)) {
				page = 0;
			}
			p[0] = doc.getPage(page, 1, true);
			p[0].setAsync(false);
			DjVuImage djvuImage = new DjVuImage(p, true);
			Rectangle pageBounds = djvuImage.getPageBounds(0);
			Image[] images = djvuImage.getImage(new JPanel(), new Rectangle(pageBounds.width, pageBounds.height));
			if (images.length == 1) {
				Image img = images[0];
				return img;
			} else
				return null;
		} else if (type.equals(ImageMimeType.PDF)) {
			PDDocument document = null;
			try {
				int resolution = 96;
				document = PDDocument.load(url.openStream());
				List<?> pages = document.getDocumentCatalog().getAllPages();
				PDPage pdPage = (PDPage) pages.get(page);
				BufferedImage image = pdPage.convertToImage(BufferedImage.TYPE_INT_RGB, resolution);
				return image;
			} finally {
				if (document != null) {
					document.close();
				}
			}
		} else
			throw new IllegalArgumentException("unsupported mimetype '" + type.getValue() + "'");
	}

}