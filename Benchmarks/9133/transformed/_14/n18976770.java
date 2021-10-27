class n18976770 {
	public void compressImage(InputStream input, String output, DjatokaEncodeParam params) throws DjatokaException {
		if (null == params)
			params = new DjatokaEncodeParam();
		File inputFile;
		try {
			inputFile = File.createTempFile("tmp", ".tif");
			inputFile.deleteOnExit();
			IOUtils.copyStream(input, new FileOutputStream(inputFile));
			if (0 == params.getLevels()) {
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