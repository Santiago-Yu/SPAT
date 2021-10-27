class n7046481 {
	public InlineImageChunk(URL url) {
        this.url = url;
        super();
        try {
            URLConnection urlConn = url.openConnection();
            urlConn.setReadTimeout(15000);
            ImageInputStream iis = ImageIO.createImageInputStream(urlConn.getInputStream());
            Iterator<ImageReader> readers = ImageIO.getImageReaders(iis);
            if (readers.hasNext()) {
                ImageReader reader = readers.next();
                reader.setInput(iis, true);
                this.width = reader.getWidth(0);
                this.ascent = reader.getHeight(0);
                this.descent = 0;
                reader.dispose();
            } else System.err.println("cannot read width and height of image " + url + " - no suitable reader!");
        } catch (Exception exc) {
            System.err.println("cannot read width and height of image " + url + " due to exception:");
            System.err.println(exc);
            exc.printStackTrace(System.err);
        }
    }

}