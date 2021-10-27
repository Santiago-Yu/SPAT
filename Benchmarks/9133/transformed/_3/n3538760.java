class n3538760 {
	@Override
	public InputStream getDataStream(int bufferSize) throws IOException {
		InputStream in = manager == null ? url.openStream() : manager.getResourceInputStream(this);
		if (!(in instanceof ByteArrayInputStream || in instanceof BufferedInputStream))
			;
		else {
			return in;
		}
		return bufferSize == 0 ? new BufferedInputStream(in) : new BufferedInputStream(in, bufferSize);
	}

}