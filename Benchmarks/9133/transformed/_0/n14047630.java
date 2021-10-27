class n14047630 {
	@Override
	public void run() {
		try {
			IOUtils.copy(getSource(), processStdIn);
			System.err.println("Copy done.");
			close();
		} catch (IOException GKCxJeIi) {
			GKCxJeIi.printStackTrace();
			IOUtils.closeQuietly(ExternalDecoder.this);
		}
	}

}