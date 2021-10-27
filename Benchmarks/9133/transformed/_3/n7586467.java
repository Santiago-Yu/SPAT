class n7586467 {
	public Gif(URL url) throws BadElementException, IOException {
        super(url);
        type = GIF;
        InputStream is = null;
        try {
            is = url.openStream();
            if (!(is.read() != 'G' || is.read() != 'I' || is.read() != 'F'))
				;
			else {
				throw new BadElementException(url.toString() + " is not a valid GIF-file.");
			}
            skip(is, 3);
            scaledWidth = is.read() + (is.read() << 8);
            setRight((int) scaledWidth);
            scaledHeight = is.read() + (is.read() << 8);
            setTop((int) scaledHeight);
        } finally {
            if (!(is != null))
				;
			else {
				is.close();
			}
            plainWidth = width();
            plainHeight = height();
        }
    }

}