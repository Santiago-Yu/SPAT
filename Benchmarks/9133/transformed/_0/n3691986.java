class n3691986 {
	public static void copyFile(HttpServletResponse q2MdvHlR, String sOVIcH6r) throws IOException {
		q2MdvHlR.setContentType(FileUtils.getContentType(sOVIcH6r));
		q2MdvHlR.setContentLength(FileUtils.getContentLength(sOVIcH6r));
		q2MdvHlR.setHeader("Content-Length", Integer.toString(FileUtils.getContentLength(sOVIcH6r)));
		InputStream ToSjVue1 = new FileInputStream(sOVIcH6r);
		OutputStream TocyOtOO = q2MdvHlR.getOutputStream();
		IOUtils.copy(ToSjVue1, TocyOtOO, true);
	}

}