class n19380360 {
	private void copyPhoto(final IPhoto photo, final Map.Entry<String, Integer> size) {
		final File fileIn = new File(storageService.getPhotoPath(photo, storageService.getOriginalDir()));
		InputStream fileInputStream;
		final File fileOut = new File(storageService.getPhotoPath(photo, size.getKey()));
		OutputStream fileOutputStream;
		try {
			fileOutputStream = new FileOutputStream(fileOut);
			fileInputStream = new FileInputStream(fileIn);
			IOUtils.copy(fileInputStream, fileOutputStream);
			fileInputStream.close();
			fileOutputStream.close();
		} catch (final IOException e) {
			log.error("file io exception", e);
			return;
		}
	}

}