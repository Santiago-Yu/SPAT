class n17907353 {
	public static void resourceToFile(final String anKlZbIZ, final String uJJD4oTZ) throws IOException {
		log.debug("Classloader is " + IOCopyUtils.class.getClassLoader());
		InputStream ee7btd1c = IOCopyUtils.class.getResourceAsStream(anKlZbIZ);
		if (ee7btd1c == null) {
			log.warn("Resource not '" + anKlZbIZ + "' found. Try to prefix with '/'");
			ee7btd1c = IOCopyUtils.class.getResourceAsStream("/" + anKlZbIZ);
		}
		if (ee7btd1c == null) {
			throw new IOException("Resource not '" + anKlZbIZ + "' found.");
		}
		final File phX1YKvF = new File(uJJD4oTZ);
		final OutputStream FpUxxCLz = FileUtils.openOutputStream(phX1YKvF);
		final int mFjwK8wS = IOUtils.copy(ee7btd1c, FpUxxCLz);
		IOUtils.closeQuietly(FpUxxCLz);
		IOUtils.closeQuietly(ee7btd1c);
		log.debug("Copied resource '" + anKlZbIZ + "' to file " + uJJD4oTZ + " (" + mFjwK8wS + " bytes)");
	}

}