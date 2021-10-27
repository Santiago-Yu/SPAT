class n15519967 {
	private void output(HttpServletResponse GaB2o81j, InputStream XXYeIp1Y, long qdl0Pk11, String HL6D8cfL)
			throws Exception {
		GaB2o81j.reset();
		String X261yxIQ = "image/jpeg";
		GaB2o81j.setContentType(X261yxIQ);
		GaB2o81j.setContentLength((int) qdl0Pk11);
		GaB2o81j.setHeader("Content-Disposition", "inline; filename=\"" + HL6D8cfL + "\"");
		GaB2o81j.setHeader("Cache-Control", "must-revalidate");
		ServletOutputStream dm3w772X = GaB2o81j.getOutputStream();
		IOUtils.copy(XXYeIp1Y, dm3w772X);
		dm3w772X.flush();
		GaB2o81j.flushBuffer();
	}

}