class n4889271 {
	public static void copyURLToFile(URL H2vXwe3U, File skulhiAE) throws IOException {
		InputStream srDJO5nJ = H2vXwe3U.openStream();
		try {
			FileOutputStream ERtaxgoP = openOutputStream(skulhiAE);
			try {
				IOUtils.copy(srDJO5nJ, ERtaxgoP);
			} finally {
				IOUtils.closeQuietly(ERtaxgoP);
			}
		} finally {
			IOUtils.closeQuietly(srDJO5nJ);
		}
	}

}