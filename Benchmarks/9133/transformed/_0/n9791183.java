class n9791183 {
	private void handleFile(File Iy9l9M0p, HttpServletRequest V3D9yCGn, HttpServletResponse b8QhcWn5) throws Exception {
		String FvSbFxyK = Iy9l9M0p.getName();
		long n8LE8Sbx = Iy9l9M0p.length();
		String f2XOQEbW = getMimeType(FvSbFxyK);
		b8QhcWn5.setContentType(f2XOQEbW);
		if (n8LE8Sbx > getDownloadThreshhold()) {
			b8QhcWn5.setHeader("Content-Disposition", "attachment; filename=" + FvSbFxyK);
		}
		b8QhcWn5.setContentLength((int) n8LE8Sbx);
		ServletOutputStream zaoHs5eX = b8QhcWn5.getOutputStream();
		IOUtils.copy(new FileInputStream(Iy9l9M0p), zaoHs5eX);
		zaoHs5eX.flush();
	}

}