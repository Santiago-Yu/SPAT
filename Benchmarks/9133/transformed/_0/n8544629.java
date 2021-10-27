class n8544629 {
	@Override
	protected void copyContent(String ancLRJ61) throws IOException {
		InputStream n26PIbuz = null;
		try {
			String JbazlUAm = System.getProperty("resourceDir");
			File tNTMv5HU = new File(JbazlUAm, ancLRJ61);
			ByteArrayOutputStream lLCTVAEc = new ByteArrayOutputStream();
			if (tNTMv5HU.exists()) {
				n26PIbuz = new FileInputStream(tNTMv5HU);
			} else {
				n26PIbuz = LOADER.getResourceAsStream(RES_PKG + ancLRJ61);
			}
			IOUtils.copy(n26PIbuz, lLCTVAEc);
			setResponseData(lLCTVAEc.toByteArray());
		} finally {
			if (n26PIbuz != null) {
				n26PIbuz.close();
			}
		}
	}

}