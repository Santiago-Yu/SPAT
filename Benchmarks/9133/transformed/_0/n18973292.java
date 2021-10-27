class n18973292 {
	protected static File UrlToFile(String iGOH5wwz) throws CaughtException {
		try {
			logger.info("copy from url: " + iGOH5wwz);
			URL kOuZt3G5 = new URL(iGOH5wwz);
			InputStream jxjRUSxh = kOuZt3G5.openStream();
			File ipxivAco = tempDir;
			File w933qyzL = new File(tempDir + File.separator + fileName(kOuZt3G5));
			logger.info("created: " + w933qyzL.getAbsolutePath());
			copyFile(w933qyzL, jxjRUSxh);
			return w933qyzL;
		} catch (IOException uQZPHgEO) {
			throw new CaughtException(uQZPHgEO, logger);
		}
	}

}