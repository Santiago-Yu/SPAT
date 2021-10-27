class n18973294 {
	protected static File UrlToAFile(File jr8kWSk0, String QhBSRBya, String vdVzMzZ9) throws CaughtException {
		try {
			logger.info("copy from url: " + QhBSRBya);
			URL O00AJvbv = new URL(QhBSRBya);
			InputStream ujcQObDY = O00AJvbv.openStream();
			File NQxudWP9 = tempDir;
			File qQggWH3N = new File(jr8kWSk0, vdVzMzZ9);
			logger.info("created: " + qQggWH3N.getAbsolutePath());
			copyFile(qQggWH3N, ujcQObDY);
			return qQggWH3N;
		} catch (IOException aRaLl5G9) {
			throw new CaughtException(aRaLl5G9, logger);
		}
	}

}