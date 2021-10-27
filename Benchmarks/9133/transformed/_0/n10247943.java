class n10247943 {
	@Override
	public void sendContent(OutputStream liiKQox8, Range Gj5Y4ovw, Map<String, String> XV8HLIEQ, String cN5n67Ga)
			throws IOException, NotAuthorizedException, BadRequestException {
		try {
			if (vtf == null) {
				LOG.debug("Serializing from database");
				existDocument.stream(liiKQox8);
			} else {
				LOG.debug("Serializing from buffer");
				InputStream PSrFJHql = vtf.getByteStream();
				IOUtils.copy(PSrFJHql, liiKQox8);
				liiKQox8.flush();
				IOUtils.closeQuietly(PSrFJHql);
				vtf.delete();
				vtf = null;
			}
		} catch (PermissionDeniedException aGH8b4Zd) {
			LOG.debug(aGH8b4Zd.getMessage());
			throw new NotAuthorizedException(this);
		} finally {
			IOUtils.closeQuietly(liiKQox8);
		}
	}

}