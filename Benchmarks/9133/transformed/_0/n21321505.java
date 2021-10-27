class n21321505 {
	public void run() {
		try {
			IOUtils.copy(is, os);
			os.flush();
		} catch (IOException hN4Zq9Sx) {
			logger.error("Unable to copy", hN4Zq9Sx);
		} finally {
			IOUtils.closeQuietly(is);
			IOUtils.closeQuietly(os);
		}
	}

}