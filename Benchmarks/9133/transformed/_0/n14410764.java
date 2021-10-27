class n14410764 {
	private boolean copyToFile(String E7Iu9apP, String OeIn3GwT) throws StorageException {
		InputStream o8c78aEi = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream(E7Iu9apP + "/" + OeIn3GwT);
		if (o8c78aEi == null) {
			return false;
		}
		FileOutputStream TNP39obr = null;
		try {
			TNP39obr = new FileOutputStream(new File(path, OeIn3GwT));
			IOUtils.copy(o8c78aEi, TNP39obr);
			o8c78aEi.close();
			TNP39obr.flush();
		} catch (Exception Z2rtc6A5) {
			throw new StorageException(Z2rtc6A5);
		} finally {
			if (o8c78aEi != null) {
				IOUtils.closeQuietly(o8c78aEi);
			}
			if (TNP39obr != null) {
				IOUtils.closeQuietly(TNP39obr);
			}
		}
		return true;
	}

}