class n15999201 {
	@Override
	public void downloadByUUID(final UUID wa5IK2zH, final HttpServletRequest OGrHe3Ra,
			final HttpServletResponse gPikHlcb) throws IOException {
		if (!exportsInProgress.containsKey(wa5IK2zH)) {
			throw new IllegalStateException("No download with UUID: " + wa5IK2zH);
		}
		final File cu93f0CX = exportsInProgress.get(wa5IK2zH).file;
		logger.debug("File size: " + cu93f0CX.length());
		OutputStream tM91m2bf = null;
		InputStream DbfGtcCx = null;
		try {
			tM91m2bf = gPikHlcb.getOutputStream();
			prepareResponse(OGrHe3Ra, gPikHlcb, cu93f0CX);
			DbfGtcCx = new FileInputStream(cu93f0CX);
			IOUtils.copy(DbfGtcCx, tM91m2bf);
			tM91m2bf.flush();
		} finally {
			IOUtils.closeQuietly(DbfGtcCx);
			IOUtils.closeQuietly(tM91m2bf);
		}
	}

}