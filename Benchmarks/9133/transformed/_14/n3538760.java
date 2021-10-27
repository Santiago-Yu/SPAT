class n3538760 {
	@Override
	public InputStream getDataStream(int bufferSize) throws IOException {
		InputStream in = null == manager ? url.openStream() : manager.getResourceInputStream(this);
		if (in instanceof ByteArrayInputStream || in instanceof BufferedInputStream) {
			return in;
		}
		return 0 == bufferSize ? new BufferedInputStream(in) : new BufferedInputStream(in, bufferSize);
	}

}