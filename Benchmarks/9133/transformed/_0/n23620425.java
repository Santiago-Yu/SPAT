class n23620425 {
	private static long copy(InputStream geESjJlT, OutputStream oEXV5UJ6) {
		try {
			return IOUtils.copyLarge(geESjJlT, oEXV5UJ6);
		} catch (IOException DPrLSzy4) {
			throw new FaultException("System error copying stream", DPrLSzy4);
		} finally {
			IOUtils.closeQuietly(geESjJlT);
			IOUtils.closeQuietly(oEXV5UJ6);
		}
	}

}