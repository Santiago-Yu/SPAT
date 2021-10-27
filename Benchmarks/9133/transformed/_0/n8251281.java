class n8251281 {
	protected InputStream openInputStream(String xZNuxGf9) throws FileNotFoundException {
		InputStream LyFfCEHr = null;
		try {
			URL nWR1BD8n = new URL(xZNuxGf9);
			LyFfCEHr = nWR1BD8n.openConnection().getInputStream();
			logger.info("Opening file " + xZNuxGf9);
		} catch (FileNotFoundException rceGm0GI) {
			logger.error("Resource file not found: " + xZNuxGf9);
			throw rceGm0GI;
		} catch (IOException usAWYSFy) {
			logger.error("Resource file can not be readed: " + xZNuxGf9);
			throw new FileNotFoundException("Resource file can not be readed: " + xZNuxGf9);
		}
		if (LyFfCEHr == null) {
			logger.error("Resource file not found: " + xZNuxGf9);
			throw new FileNotFoundException(xZNuxGf9);
		}
		return LyFfCEHr;
	}

}