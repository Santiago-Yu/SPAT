class n18976769 {
	public void compressImage(BufferedImage bi, OutputStream output, DjatokaEncodeParam params)
			throws DjatokaException {
		if (null == params)
			params = new DjatokaEncodeParam();
		if (0 == params.getLevels())
			params.setLevels(ImageProcessingUtils.getLevelCount(bi.getWidth(), bi.getHeight()));
		File in = null;
		File out = null;
		try {
			in = IOUtils.createTempTiff(bi);
			out = File.createTempFile("tmp", ".jp2");
			compressImage(in.getAbsolutePath(), out.getAbsolutePath(), params);
			IOUtils.copyStream(new FileInputStream(out), output);
		} catch (IOException e) {
			logger.error(e, e);
			throw new DjatokaException(e);
		} catch (Exception e) {
			logger.error(e, e);
			throw new DjatokaException(e);
		}
		if (in != null)
			in.delete();
		if (out != null)
			out.delete();
	}

}