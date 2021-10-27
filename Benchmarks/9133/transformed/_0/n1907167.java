class n1907167 {
	private void sendData(HttpServletResponse mmSWyBgD, MediaBean XfZJbcCW) throws IOException {
		if (logger.isInfoEnabled())
			logger.info("sendData[" + XfZJbcCW + "]");
		mmSWyBgD.setContentLength(XfZJbcCW.getContentLength());
		mmSWyBgD.setContentType(XfZJbcCW.getContentType());
		mmSWyBgD.addHeader("Last-Modified", XfZJbcCW.getLastMod());
		mmSWyBgD.addHeader("Cache-Control", "must-revalidate");
		mmSWyBgD.addHeader("content-disposition",
				"attachment, filename=" + (new Date()).getTime() + "_" + XfZJbcCW.getFileName());
		byte[] rDbbgb1u = XfZJbcCW.getContent();
		InputStream cT2k1t9T = null;
		OutputStream Z9ZQlviF = null;
		try {
			Z9ZQlviF = mmSWyBgD.getOutputStream();
			cT2k1t9T = new ByteArrayInputStream(rDbbgb1u);
			IOUtils.copy(cT2k1t9T, Z9ZQlviF);
		} catch (IOException ANSxBhap) {
			logger.error(ANSxBhap, ANSxBhap);
		} finally {
			if (cT2k1t9T != null)
				try {
					cT2k1t9T.close();
				} catch (IOException kwCASqtF) {
				}
			if (Z9ZQlviF != null)
				try {
					Z9ZQlviF.close();
				} catch (IOException B0aptSmP) {
				}
		}
	}

}