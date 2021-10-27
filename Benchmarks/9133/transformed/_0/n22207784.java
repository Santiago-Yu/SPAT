class n22207784 {
	public static void copyURLToFile(URL lRgGMSOt, File Izh9M9tb) throws IOException {
		InputStream hzPvVXe6 = lRgGMSOt.openStream();
		try {
			FileOutputStream EXjReT2y = openOutputStream(Izh9M9tb);
			try {
				IOUtils.copy(hzPvVXe6, EXjReT2y);
			} finally {
				IOUtils.closeQuietly(EXjReT2y);
			}
		} finally {
			IOUtils.closeQuietly(hzPvVXe6);
		}
	}

}