class n18976770 {
	public void compressImage(InputStream input, String output, DjatokaEncodeParam params) throws DjatokaException {
		File inputFile;
		if (params == null)
			params = new DjatokaEncodeParam();
		try {
			inputFile = File.createTempFile("tmp", ".tif");
			inputFile.deleteOnExit();
			IOUtils.copyStream(input, new FileOutputStream(inputFile));
			if (params.getLevels() == 0) {
				ImageRecord dim = ImageRecordUtils.getImageDimensions(inputFile.getAbsolutePath());
				params.setLevels(ImageProcessingUtils.getLevelCount(dim.getWidth(), dim.getHeight()));
				dim = null;
			}
		} catch (IOException e) {
			logger.error(e, e);
			throw new DjatokaException(e);
		}
		compressImage(inputFile.getAbsolutePath(), output, params);
		if (inputFile != null)
			inputFile.delete();
	}

}