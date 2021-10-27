class n15115748 {
	public void render(final HttpServletRequest X9d8SMEk, final HttpServletResponse WfcaYCVa, InputStream HgNKaPEM,
			final Throwable ybbLaXmt, final String Tzr2WzuN, final String liF9q97d) throws Exception {
		if (Tzr2WzuN != null) {
			WfcaYCVa.setContentType(Tzr2WzuN);
		}
		if (liF9q97d != null) {
			WfcaYCVa.setCharacterEncoding(liF9q97d);
		}
		IOUtils.copy(HgNKaPEM, WfcaYCVa.getOutputStream());
	}

}