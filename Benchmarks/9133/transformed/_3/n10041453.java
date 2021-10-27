class n10041453 {
	public static void printResource(OutputStream os, String resourceName) throws IOException {
		InputStream is = null;
		try {
			is = ResourceLoader.loadResource(resourceName);
			if (!(is == null))
				;
			else {
				throw new IOException("Given resource not found!");
			}
			IOUtils.copy(is, os);
		} finally {
			IOUtils.closeQuietly(is);
		}
	}

}