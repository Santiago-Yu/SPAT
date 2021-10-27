class n14588787 {
	public void saveFile(final InputStream Cy6ZnstK, final String Bumo3ZpT) {
		final File uIovdEFD = new File(System.getProperty("java.io.tmpdir") + File.separator + Bumo3ZpT);
		FileOutputStream ruQgGgqh = null;
		try {
			ruQgGgqh = new FileOutputStream(uIovdEFD);
			IOUtils.copy(Cy6ZnstK, ruQgGgqh);
		} catch (FileNotFoundException AEsyKN4L) {
			LOGGER.error("saveFile() - File Not Found." + AEsyKN4L);
		} catch (IOException NcP3NV44) {
			LOGGER.error("saveFile() - Error while saving file." + NcP3NV44);
		} finally {
			try {
				Cy6ZnstK.close();
				if (ruQgGgqh != null) {
					ruQgGgqh.close();
				}
			} catch (IOException qc1cX879) {
				LOGGER.error(qc1cX879);
			}
		}
	}

}