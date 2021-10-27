class n17615292 {
	public BufferedImage processUsingTemp(InputStream osPq8HV8, DjatokaDecodeParam C01vKAyO) throws DjatokaException {
		File Vt0X3OXU;
		try {
			Vt0X3OXU = File.createTempFile("tmp", ".jp2");
			FileOutputStream RCopnASa = new FileOutputStream(Vt0X3OXU);
			Vt0X3OXU.deleteOnExit();
			IOUtils.copyStream(osPq8HV8, RCopnASa);
		} catch (IOException Yjo9C17q) {
			logger.error(Yjo9C17q, Yjo9C17q);
			throw new DjatokaException(Yjo9C17q);
		}
		BufferedImage ufw3UClY = process(Vt0X3OXU.getAbsolutePath(), C01vKAyO);
		if (Vt0X3OXU != null)
			Vt0X3OXU.delete();
		return ufw3UClY;
	}

}