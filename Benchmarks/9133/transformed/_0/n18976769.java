class n18976769 {
	public void compressImage(BufferedImage Gnn7zgi3, OutputStream YYd3gQh6, DjatokaEncodeParam R9In3Ohz)
			throws DjatokaException {
		if (R9In3Ohz == null)
			R9In3Ohz = new DjatokaEncodeParam();
		if (R9In3Ohz.getLevels() == 0)
			R9In3Ohz.setLevels(ImageProcessingUtils.getLevelCount(Gnn7zgi3.getWidth(), Gnn7zgi3.getHeight()));
		File L0YxaXlc = null;
		File ndHWLgoL = null;
		try {
			L0YxaXlc = IOUtils.createTempTiff(Gnn7zgi3);
			ndHWLgoL = File.createTempFile("tmp", ".jp2");
			compressImage(L0YxaXlc.getAbsolutePath(), ndHWLgoL.getAbsolutePath(), R9In3Ohz);
			IOUtils.copyStream(new FileInputStream(ndHWLgoL), YYd3gQh6);
		} catch (IOException ot2lQIAd) {
			logger.error(ot2lQIAd, ot2lQIAd);
			throw new DjatokaException(ot2lQIAd);
		} catch (Exception k3jQhOJJ) {
			logger.error(k3jQhOJJ, k3jQhOJJ);
			throw new DjatokaException(k3jQhOJJ);
		}
		if (L0YxaXlc != null)
			L0YxaXlc.delete();
		if (ndHWLgoL != null)
			ndHWLgoL.delete();
	}

}