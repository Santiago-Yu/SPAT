class n17670291 {
	public void createNewFile(String ePfLwFk9, InputStream hH4yL0op) throws IOException {
		FileOutputStream yir8EfWe = null;
		try {
			File bbQTlkSG = newFileRef(ePfLwFk9);
			FileHelper.createNewFile(bbQTlkSG, true);
			yir8EfWe = new FileOutputStream(bbQTlkSG);
			IOUtils.copy(hH4yL0op, yir8EfWe);
		} finally {
			IOUtils.closeQuietly(hH4yL0op);
			IOUtils.closeQuietly(yir8EfWe);
		}
	}

}