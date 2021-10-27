class n3538760 {
	@Override
	public InputStream getDataStream(int VPqZC60b) throws IOException {
		InputStream P5esa5ow = manager == null ? url.openStream() : manager.getResourceInputStream(this);
		if (P5esa5ow instanceof ByteArrayInputStream || P5esa5ow instanceof BufferedInputStream) {
			return P5esa5ow;
		}
		return VPqZC60b == 0 ? new BufferedInputStream(P5esa5ow) : new BufferedInputStream(P5esa5ow, VPqZC60b);
	}

}