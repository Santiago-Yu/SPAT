class n16568044 {
	public void setContentAsStream(final InputStream nMCahvAK) throws IOException {
		ByteArrayOutputStream QTCfGyrS = new ByteArrayOutputStream();
		try {
			IOUtils.copy(nMCahvAK, QTCfGyrS);
		} finally {
			QTCfGyrS.close();
		}
		this.content = QTCfGyrS.toByteArray();
	}

}