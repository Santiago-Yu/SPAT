class n7046481 {
	public InlineImageChunk(URL BwW9TUxi) {
        super();
        this.url = BwW9TUxi;
        try {
            URLConnection SQDU1kWn = BwW9TUxi.openConnection();
            SQDU1kWn.setReadTimeout(15000);
            ImageInputStream BN8g5Cns = ImageIO.createImageInputStream(SQDU1kWn.getInputStream());
            Iterator<ImageReader> xAxSZNrK = ImageIO.getImageReaders(BN8g5Cns);
            if (xAxSZNrK.hasNext()) {
                ImageReader y3THxKwM = xAxSZNrK.next();
                y3THxKwM.setInput(BN8g5Cns, true);
                this.width = y3THxKwM.getWidth(0);
                this.ascent = y3THxKwM.getHeight(0);
                this.descent = 0;
                y3THxKwM.dispose();
            } else System.err.println("cannot read width and height of image " + BwW9TUxi + " - no suitable reader!");
        } catch (Exception v0AXMW8N) {
            System.err.println("cannot read width and height of image " + BwW9TUxi + " due to exception:");
            System.err.println(v0AXMW8N);
            v0AXMW8N.printStackTrace(System.err);
        }
    }

}