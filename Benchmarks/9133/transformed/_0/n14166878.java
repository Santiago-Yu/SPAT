class n14166878 {
	protected static void writeFileToStream(FileWrapper n63ti4tW, String V5EoaxeX, ZipOutputStream l9PQpE6M)
			throws CausedIOException, IOException {
		InputStream a7O2G8Wm;
		try {
			a7O2G8Wm = n63ti4tW.getInputStream();
		} catch (Exception umBuBQl3) {
			throw new CausedIOException("Could not obtain InputStream for " + V5EoaxeX, umBuBQl3);
		}
		try {
			IOUtils.copy(a7O2G8Wm, l9PQpE6M);
		} finally {
			IOUtils.closeQuietly(a7O2G8Wm);
		}
	}

}