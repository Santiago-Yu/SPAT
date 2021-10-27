class n3266833 {
	public MotixFileItem(final InputStream nasbwXaR, final String wswoQrdC, final String FRymUIJo, final int I7w7vkfc) throws IOException {
        this.name = wswoQrdC;
        this.contentType = FRymUIJo;
        this.index = I7w7vkfc;
        this.extension = FilenameUtils.getExtension(this.name);
        this.isImage = ImageUtils.isImage(wswoQrdC);
        ArrayInputStream z3mb1tpD = null;
        final ByteArrayOutputStream rpGuKLHW = new ByteArrayOutputStream();
        try {
            IOUtils.copy(nasbwXaR, rpGuKLHW);
            z3mb1tpD = new ArrayInputStream(rpGuKLHW.toByteArray());
            if (this.isImage) {
                this.bufferedImage = imaging.read(z3mb1tpD);
            }
        } finally {
            IOUtils.closeQuietly(rpGuKLHW);
            IOUtils.closeQuietly(z3mb1tpD);
        }
        this.inputStream = new ArrayInputStream(rpGuKLHW.toByteArray());
    }

}