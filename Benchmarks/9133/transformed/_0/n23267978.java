class n23267978 {
	public static boolean copy(InputStream CIeeLA1J, File ij1EO1Kw) {
		try {
			IOUtils.copy(CIeeLA1J, new FileOutputStream(ij1EO1Kw));
			return true;
		} catch (Exception BQeQZFiz) {
			logger.severe(BQeQZFiz.getMessage());
			return false;
		}
	}

}