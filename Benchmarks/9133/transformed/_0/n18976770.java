class n18976770 {
	public void compressImage(InputStream OpA2pVKP, String mAKh0nzX, DjatokaEncodeParam AjnN0rKi)
			throws DjatokaException {
		if (AjnN0rKi == null)
			AjnN0rKi = new DjatokaEncodeParam();
		File RDz2NCeY;
		try {
			RDz2NCeY = File.createTempFile("tmp", ".tif");
			RDz2NCeY.deleteOnExit();
			IOUtils.copyStream(OpA2pVKP, new FileOutputStream(RDz2NCeY));
			if (AjnN0rKi.getLevels() == 0) {
				ImageRecord wlF8HRjD = ImageRecordUtils.getImageDimensions(RDz2NCeY.getAbsolutePath());
				AjnN0rKi.setLevels(ImageProcessingUtils.getLevelCount(wlF8HRjD.getWidth(), wlF8HRjD.getHeight()));
				wlF8HRjD = null;
			}
		} catch (IOException LL02gSxw) {
			logger.error(LL02gSxw, LL02gSxw);
			throw new DjatokaException(LL02gSxw);
		}
		compressImage(RDz2NCeY.getAbsolutePath(), mAKh0nzX, AjnN0rKi);
		if (RDz2NCeY != null)
			RDz2NCeY.delete();
	}

}