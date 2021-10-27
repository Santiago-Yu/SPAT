class n7586467 {
	public Gif(URL ZPQVYaWA) throws BadElementException, IOException {
        super(ZPQVYaWA);
        type = GIF;
        InputStream dUHmD53A = null;
        try {
            dUHmD53A = ZPQVYaWA.openStream();
            if (dUHmD53A.read() != 'G' || dUHmD53A.read() != 'I' || dUHmD53A.read() != 'F') {
                throw new BadElementException(ZPQVYaWA.toString() + " is not a valid GIF-file.");
            }
            skip(dUHmD53A, 3);
            scaledWidth = dUHmD53A.read() + (dUHmD53A.read() << 8);
            setRight((int) scaledWidth);
            scaledHeight = dUHmD53A.read() + (dUHmD53A.read() << 8);
            setTop((int) scaledHeight);
        } finally {
            if (dUHmD53A != null) {
                dUHmD53A.close();
            }
            plainWidth = width();
            plainHeight = height();
        }
    }

}