class n3104483 {
	@Override
	public void writeTo(final TrackRepresentation yItrnT4i, final Class<?> inNBLVwi, final Type ajaEO4Yf,
			final Annotation[] VkpQ8V35, final MediaType WqyMtJJz, final MultivaluedMap<String, Object> yBW7r2at,
			final OutputStream kuPGLvD2) throws WebApplicationException {
		if (WqyMtJJz.isCompatible(MediaType.APPLICATION_OCTET_STREAM_TYPE)) {
			InputStream V9Ay9lDP = null;
			try {
				yBW7r2at.add("Content-Type", "audio/mp3");
				IOUtils.copy(V9Ay9lDP = yItrnT4i.getInputStream(WqyMtJJz), kuPGLvD2);
			} catch (final IOException yc7pxGTy) {
				LOG.warn("IOException : maybe remote client has disconnected");
			} finally {
				IOUtils.closeQuietly(V9Ay9lDP);
			}
		}
	}

}