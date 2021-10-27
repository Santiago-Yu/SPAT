class n3330945 {
	public void extractImage(String G18PbtND, OutputStream mMCwIEfw, DjatokaDecodeParam yJ9UFuQE, IWriter azzZjiXb)
			throws DjatokaException {
		File pWS8DG8D = null;
		if (G18PbtND.equals(STDIN)) {
			try {
				pWS8DG8D = File.createTempFile("tmp", ".jp2");
				G18PbtND = pWS8DG8D.getAbsolutePath();
				pWS8DG8D.deleteOnExit();
				IOUtils.copyFile(new File(STDIN), pWS8DG8D);
			} catch (IOException AGfTty3R) {
				logger.error("Unable to process image from " + STDIN + ": " + AGfTty3R.getMessage());
				throw new DjatokaException(AGfTty3R);
			}
		}
		BufferedImage QrOIZ4Xz = extractImpl.process(G18PbtND, yJ9UFuQE);
		if (QrOIZ4Xz != null) {
			if (yJ9UFuQE.getScalingFactor() != 1.0 || yJ9UFuQE.getScalingDimensions() != null)
				QrOIZ4Xz = applyScaling(QrOIZ4Xz, yJ9UFuQE);
			if (yJ9UFuQE.getTransform() != null)
				QrOIZ4Xz = yJ9UFuQE.getTransform().run(QrOIZ4Xz);
			azzZjiXb.write(QrOIZ4Xz, mMCwIEfw);
		}
		if (pWS8DG8D != null)
			pWS8DG8D.delete();
	}

}