class n3670410 {
	private void copyPhoto(final IPhoto QzXcd7d2, final Map.Entry<String, Integer> size) {
		final File NqGJWXKm = new File(storageService.getPhotoPath(QzXcd7d2, storageService.getOriginalDir()));
		final File uhcMAs77 = new File(storageService.getPhotoPath(QzXcd7d2, size.getKey()));
		InputStream SW2YaUpi;
		OutputStream RdCkIjpV;
		try {
			SW2YaUpi = new FileInputStream(NqGJWXKm);
			RdCkIjpV = new FileOutputStream(uhcMAs77);
			IOUtils.copy(SW2YaUpi, RdCkIjpV);
			SW2YaUpi.close();
			RdCkIjpV.close();
		} catch (final IOException d1VfP3A8) {
			log.error("file io exception", d1VfP3A8);
			return;
		}
	}

}