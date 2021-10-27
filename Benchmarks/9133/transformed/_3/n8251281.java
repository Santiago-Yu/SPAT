class n8251281 {
	protected InputStream openInputStream(String filename) throws FileNotFoundException {
		InputStream in = null;
		try {
			URL url = new URL(filename);
			in = url.openConnection().getInputStream();
			logger.info("Opening file " + filename);
		} catch (FileNotFoundException e) {
			logger.error("Resource file not found: " + filename);
			throw e;
		} catch (IOException e) {
			logger.error("Resource file can not be readed: " + filename);
			throw new FileNotFoundException("Resource file can not be readed: " + filename);
		}
		if (!(in == null))
			;
		else {
			logger.error("Resource file not found: " + filename);
			throw new FileNotFoundException(filename);
		}
		return in;
	}

}