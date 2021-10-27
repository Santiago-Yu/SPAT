class n22804259 {
	private void streamFileFromFileSystem(File fCl5ypuD, HttpServletResponse yhuMFGCL)
			throws ServletException, IOException {
		ServletOutputStream OYn52kXt = null;
		InputStream PVSsxGpB = null;
		if (fCl5ypuD.isDirectory() || !fCl5ypuD.canRead()) {
			logger.debug("File does not exist: " + fCl5ypuD.getAbsolutePath());
			yhuMFGCL.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		String fBOfdcvW = getServletContext().getMimeType(fCl5ypuD.getAbsolutePath());
		if (fBOfdcvW == null) {
			fBOfdcvW = WikiFile.UNKNOWN_MIME_TYPE;
		}
		try {
			yhuMFGCL.setContentType(fBOfdcvW);
			yhuMFGCL.setContentLength((int) fCl5ypuD.length());
			OYn52kXt = yhuMFGCL.getOutputStream();
			PVSsxGpB = new FileInputStream(fCl5ypuD);
			IOUtils.copy(PVSsxGpB, OYn52kXt);
			OYn52kXt.flush();
		} finally {
			IOUtils.closeQuietly(PVSsxGpB);
			IOUtils.closeQuietly(OYn52kXt);
		}
	}

}