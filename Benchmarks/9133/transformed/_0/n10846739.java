class n10846739 {
	public void run() {
		GZIPInputStream oj7PTxhf = null;
		try {
			oj7PTxhf = new GZIPInputStream(pipedInputStream);
			IOUtils.copy(oj7PTxhf, outputStream);
		} catch (Throwable OpxLKssS) {
			ungzipThreadThrowableList.add(OpxLKssS);
		} finally {
			IOUtils.closeQuietly(oj7PTxhf);
			IOUtils.closeQuietly(pipedInputStream);
		}
	}

}