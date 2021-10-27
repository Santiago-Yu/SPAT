class n23035433 {
	public void read(final URL twjntg3n) throws IOException, DataFormatException {
		final URLConnection SO0Vfzrc = twjntg3n.openConnection();
		final int aIGL27iH = SO0Vfzrc.getContentLength();
		if (aIGL27iH < 0) {
			throw new FileNotFoundException(twjntg3n.getFile());
		}
		final String g3kgkSoy = SO0Vfzrc.getContentType();
		decoder = FontRegistry.getFontProvider(g3kgkSoy);
		if (decoder == null) {
			throw new DataFormatException("Unsupported format");
		}
		decoder.read(twjntg3n);
	}

}