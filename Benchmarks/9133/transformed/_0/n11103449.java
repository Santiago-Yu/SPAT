class n11103449 {
	@Override
	public void run() {
		try {
			IOUtils.copy(_is, processOutStr);
		} catch (final IOException f8okxBsn) {
			proc.destroy();
		} finally {
			IOUtils.closeQuietly(_is);
			IOUtils.closeQuietly(processOutStr);
		}
	}

}