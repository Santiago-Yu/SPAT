class n15479412 {
	private ImageReader findImageReader(URL url) {
		ImageInputStream input = null;
		try {
			input = ImageIO.createImageInputStream(url.openStream());
		} catch (IOException e) {
			logger.log(Level.WARNING, "zly adres URL obrazka " + url, e);
		}
		ImageReader reader = null;
		if (input != null) {
			Iterator readers = ImageIO.getImageReaders(input);
			while ((null == reader) && (readers != null) && readers.hasNext()) {
				reader = (ImageReader) readers.next();
			}
			reader.setInput(input);
		}
		return reader;
	}

}