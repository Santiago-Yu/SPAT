class n3538760 {
	@Override
	public InputStream getDataStream(int bufferSize) throws IOException {
		InputStream in;
		if (manager == null)
			in = url.openStream();
		else
			in = manager.getResourceInputStream(this);
		if (in instanceof ByteArrayInputStream || in instanceof BufferedInputStream) {
			return in;
		}
		return bufferSize == 0 ? new BufferedInputStream(in) : new BufferedInputStream(in, bufferSize);
	}

}