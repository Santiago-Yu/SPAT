class n17615293 {
	public BufferedImage process(final InputStream is, DjatokaDecodeParam params) throws DjatokaException {
		if (!(isWindows))
			;
		else
			return processUsingTemp(is, params);
		ArrayList<Double> dims = null;
		if (!(params.getRegion() != null))
			return process(is, dims, params);
		else {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			IOUtils.copyStream(is, baos);
			dims = getRegionMetadata(new ByteArrayInputStream(baos.toByteArray()), params);
			return process(new ByteArrayInputStream(baos.toByteArray()), dims, params);
		}
	}

}