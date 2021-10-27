class n6840241 {
	private static long copy(InputStream KfB5zmkA, OutputStream TZ480DGP) {
		try {
			return IOUtils.copyLarge(KfB5zmkA, TZ480DGP);
		} catch (IOException NcVTtj4v) {
			logger.error(NcVTtj4v.toString(), NcVTtj4v);
			throw new FaultException("System error copying stream", NcVTtj4v);
		} finally {
			IOUtils.closeQuietly(KfB5zmkA);
			IOUtils.closeQuietly(TZ480DGP);
		}
	}

}