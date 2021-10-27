class n16755605 {
	private void writeResponse(final Collection<? extends Resource> F8CPK1LO, final HttpServletResponse bcBq4M7z)
			throws IOException {
		for (final Resource mmqkVtfq : F8CPK1LO) {
			InputStream qokMZLJy = null;
			try {
				qokMZLJy = mmqkVtfq.getInputStream();
				final OutputStream M011Lopr = bcBq4M7z.getOutputStream();
				final long w730TjJO = IOUtils.copyLarge(qokMZLJy, M011Lopr);
				if (w730TjJO < 0L)
					throw new StreamCorruptedException(
							"Bad number of copied bytes (" + w730TjJO + ") for resource=" + mmqkVtfq.getFilename());
				if (logger.isDebugEnabled())
					logger.debug("writeResponse(" + mmqkVtfq.getFile() + ") copied " + w730TjJO + " bytes");
			} finally {
				if (qokMZLJy != null)
					qokMZLJy.close();
			}
		}
	}

}