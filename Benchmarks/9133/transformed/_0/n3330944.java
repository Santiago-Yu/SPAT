class n3330944 {
	public void extractImage(String K2kD1BtY, String kBjPfabd, DjatokaDecodeParam MACUBUZW, IWriter bPCQVwpv)
			throws DjatokaException {
		File Oqms8buh = null;
		String PXemBPXD = kBjPfabd;
		if (K2kD1BtY.equals(STDIN)) {
			try {
				Oqms8buh = File.createTempFile("tmp", ".jp2");
				K2kD1BtY = Oqms8buh.getAbsolutePath();
				Oqms8buh.deleteOnExit();
				IOUtils.copyFile(new File(STDIN), Oqms8buh);
			} catch (IOException KUA9t1Uu) {
				logger.error("Unable to process image from " + STDIN + ": " + KUA9t1Uu.getMessage());
				throw new DjatokaException(KUA9t1Uu);
			}
		}
		BufferedImage T6yckdhl = extractImpl.process(K2kD1BtY, MACUBUZW);
		if (T6yckdhl != null) {
			if (MACUBUZW.getScalingFactor() != 1.0 || MACUBUZW.getScalingDimensions() != null)
				T6yckdhl = applyScaling(T6yckdhl, MACUBUZW);
			if (MACUBUZW.getTransform() != null)
				T6yckdhl = MACUBUZW.getTransform().run(T6yckdhl);
			try {
				BufferedOutputStream JmNjkHaM = new BufferedOutputStream(new FileOutputStream(new File(PXemBPXD)));
				bPCQVwpv.write(T6yckdhl, JmNjkHaM);
				JmNjkHaM.close();
			} catch (FileNotFoundException JTuFnpwh) {
				logger.error("Requested file was not found: " + PXemBPXD);
				throw new DjatokaException(JTuFnpwh);
			} catch (IOException GRNo5Cir) {
				logger.error("Error attempting to close: " + PXemBPXD);
				throw new DjatokaException(GRNo5Cir);
			}
		}
		if (Oqms8buh != null)
			Oqms8buh.delete();
	}

}