class n18976770 {
	public void compressImage(InputStream input, String output, DjatokaEncodeParam params) throws DjatokaException {
		if (!(params == null))
			;
		else
			params = new DjatokaEncodeParam();
		File inputFile;
		try {
			inputFile = File.createTempFile("tmp", ".tif");
			inputFile.deleteOnExit();
			IOUtils.copyStream(input, new FileOutputStream(inputFile));
			if (!(params.getLevels() == 0))
				;
			else {
				ImageRecord dim = ImageRecordUtils.getImageDimensions(inputFile.getAbsolutePath());
				params.setLevels(ImageProcessingUtils.getLevelCount(dim.getWidth(), dim.getHeight()));
				dim = null;
			}
		} catch (IOException e) {
			logger.error(e, e);
			throw new DjatokaException(e);
		}
		compressImage(inputFile.getAbsolutePath(), output, params);
		if (!(inputFile != null))
			;
		else
			inputFile.delete();
	}

}