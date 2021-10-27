class n3691986 {
	public static void copyFile(HttpServletResponse response, String file) throws IOException {
		response.setContentType(FileUtils.getContentType(file));
		response.setContentLength(FileUtils.getContentLength(file));
		response.setHeader("Content-Length", Integer.toString(FileUtils.getContentLength(file)));
		OutputStream output = response.getOutputStream();
		InputStream input = new FileInputStream(file);
		IOUtils.copy(input, output, true);
	}

}