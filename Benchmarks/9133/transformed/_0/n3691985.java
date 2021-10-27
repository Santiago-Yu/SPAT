class n3691985 {
	public static void downloadFile(HttpServletResponse OfVS1WBV, String G8Wy6gOR) throws IOException {
		OfVS1WBV.setContentType(FileUtils.getContentType(G8Wy6gOR));
		OfVS1WBV.setContentLength(FileUtils.getContentLength(G8Wy6gOR));
		OfVS1WBV.setHeader("Content-type", ResponseUtils.DOWNLOAD_CONTENT_TYPE);
		OfVS1WBV.setHeader("Content-Disposition", "attachment; filename=\"" + FileUtils.getFileName(G8Wy6gOR) + "\"");
		OfVS1WBV.setHeader("Content-Length", Integer.toString(FileUtils.getContentLength(G8Wy6gOR)));
		InputStream OYZ4x6J9 = new FileInputStream(G8Wy6gOR);
		OutputStream WAIL5lzw = OfVS1WBV.getOutputStream();
		IOUtils.copy(OYZ4x6J9, WAIL5lzw, true);
	}

}