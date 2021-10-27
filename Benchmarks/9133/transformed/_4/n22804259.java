class n22804259 {
	private void streamFileFromFileSystem(File file, HttpServletResponse response)
			throws ServletException, IOException {
		ServletOutputStream out = null;
		InputStream in = null;
		if (file.isDirectory() || !file.canRead()) {
			logger.debug("File does not exist: " + file.getAbsolutePath());
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		String mimeType = getServletContext().getMimeType(file.getAbsolutePath());
		mimeType = (mimeType == null) ? WikiFile.UNKNOWN_MIME_TYPE : mimeType;
		try {
			response.setContentType(mimeType);
			response.setContentLength((int) file.length());
			out = response.getOutputStream();
			in = new FileInputStream(file);
			IOUtils.copy(in, out);
			out.flush();
		} finally {
			IOUtils.closeQuietly(in);
			IOUtils.closeQuietly(out);
		}
	}

}