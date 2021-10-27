class n11651293 {
	public void render(final HttpServletRequest YfzI2oJb, final HttpServletResponse iO79Vhz5, final byte[] EcOYDOAH,
			final Throwable bRQkrsVr, final String Z7mjRYTN, final String oTp0Bxkh) throws Exception {
		if (Z7mjRYTN != null) {
			iO79Vhz5.setContentType(Z7mjRYTN);
		}
		if (oTp0Bxkh != null) {
			iO79Vhz5.setCharacterEncoding(oTp0Bxkh);
		}
		iO79Vhz5.setContentLength(EcOYDOAH.length);
		IOUtils.copy(new ByteArrayInputStream(EcOYDOAH), iO79Vhz5.getOutputStream());
	}

}