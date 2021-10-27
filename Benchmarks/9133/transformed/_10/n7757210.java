class n7757210 {
	@RequestMapping("/download")
	public void download(HttpServletRequest request, HttpServletResponse response) {
		ServletOutputStream output = null;
		InputStream input = null;
		try {
			String savePath = request.getSession().getServletContext().getRealPath("/upload");
			String fileType = ".log";
			String dbFileName = "83tomcat»’÷æ≤‚ ‘≈∂";
			String downloadFileName = dbFileName + fileType;
			String finalPath = "\\2011-12\\01\\8364b45f-244d-41b6-bbf48df32064a935";
			File downloadFile = new File(savePath + finalPath);
			downloadFileName = new String(downloadFileName.getBytes("GBK"), "ISO-8859-1");
			if (!downloadFile.getParentFile().exists()) {
				downloadFile.getParentFile().mkdirs();
			}
			if (!downloadFile.isFile()) {
				FileUtils.touch(downloadFile);
			}
			response.setContentType("aapplication/vnd.ms-excel ;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setHeader("content-disposition", "attachment; filename=" + downloadFileName);
			output = response.getOutputStream();
			input = new FileInputStream(downloadFile);
			IOUtils.copy(input, output);
			output.flush();
		} catch (Exception e) {
			logger.error("Exception: ", e);
		} finally {
			IOUtils.closeQuietly(output);
			IOUtils.closeQuietly(input);
		}
	}

}