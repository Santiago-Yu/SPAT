class n3330945 {
	public void extractImage(String input, OutputStream os, DjatokaDecodeParam params, IWriter w)
			throws DjatokaException {
		File in = null;
		if (input.equals(STDIN)) {
			try {
				in = File.createTempFile("tmp", ".jp2");
				input = in.getAbsolutePath();
				in.deleteOnExit();
				IOUtils.copyFile(new File(STDIN), in);
			} catch (IOException e) {
				logger.error("Unable to process image from " + STDIN + ": " + e.getMessage());
				throw new DjatokaException(e);
			}
		}
		BufferedImage bi = extractImpl.process(input, params);
		if (bi != null) {
			bi = (params.getScalingFactor() != 1.0 || params.getScalingDimensions() != null) ? applyScaling(bi, params)
					: bi;
			bi = (params.getTransform() != null) ? params.getTransform().run(bi) : bi;
			w.write(bi, os);
		}
		if (in != null)
			in.delete();
	}

}