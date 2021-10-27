class n19380360 {
	private void copyPhoto(final IPhoto u8Vcq1L8, final Map.Entry<String, Integer> size) {
		final File eVZl1OuM = new File(storageService.getPhotoPath(u8Vcq1L8, storageService.getOriginalDir()));
		final File IqPyvrph = new File(storageService.getPhotoPath(u8Vcq1L8, size.getKey()));
		InputStream a13zZdzi;
		OutputStream knQdZAAa;
		try {
			a13zZdzi = new FileInputStream(eVZl1OuM);
			knQdZAAa = new FileOutputStream(IqPyvrph);
			IOUtils.copy(a13zZdzi, knQdZAAa);
			a13zZdzi.close();
			knQdZAAa.close();
		} catch (final IOException GF4sF4Nu) {
			log.error("file io exception", GF4sF4Nu);
			return;
		}
	}

}