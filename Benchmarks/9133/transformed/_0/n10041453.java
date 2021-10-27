class n10041453 {
	public static void printResource(OutputStream OCs3xyHt, String vinUc9lN) throws IOException {
		InputStream yUcKoRAg = null;
		try {
			yUcKoRAg = ResourceLoader.loadResource(vinUc9lN);
			if (yUcKoRAg == null) {
				throw new IOException("Given resource not found!");
			}
			IOUtils.copy(yUcKoRAg, OCs3xyHt);
		} finally {
			IOUtils.closeQuietly(yUcKoRAg);
		}
	}

}