class n15479412 {
	private ImageReader findImageReader(URL DgmcAxyl) {
		ImageInputStream tK4s94mX = null;
		try {
			tK4s94mX = ImageIO.createImageInputStream(DgmcAxyl.openStream());
		} catch (IOException LZtGPLDW) {
			logger.log(Level.WARNING, "zly adres URL obrazka " + DgmcAxyl, LZtGPLDW);
		}
		ImageReader sfxPqwKF = null;
		if (tK4s94mX != null) {
			Iterator FkiMj18g = ImageIO.getImageReaders(tK4s94mX);
			while ((sfxPqwKF == null) && (FkiMj18g != null) && FkiMj18g.hasNext()) {
				sfxPqwKF = (ImageReader) FkiMj18g.next();
			}
			sfxPqwKF.setInput(tK4s94mX);
		}
		return sfxPqwKF;
	}

}