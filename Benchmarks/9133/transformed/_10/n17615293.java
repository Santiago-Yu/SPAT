class n17615293 {
	public BufferedImage process(final InputStream is, DjatokaDecodeParam params) throws DjatokaException {
		ArrayList<Double> dims = null;
		if (isWindows)
			return processUsingTemp(is, params);
		if (params.getRegion() != null) {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			IOUtils.copyStream(is, baos);
			dims = getRegionMetadata(new ByteArrayInputStream(baos.toByteArray()), params);
			return process(new ByteArrayInputStream(baos.toByteArray()), dims, params);
		} else
			return process(is, dims, params);
	}

}