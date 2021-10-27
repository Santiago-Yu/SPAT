class n8041989 {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
		String requestURI = req.getRequestURI();
		logger.info("The requested URI: {}", requestURI);
		String parameter = requestURI.substring(requestURI.lastIndexOf(ARXIVID_ENTRY) + ARXIVID_ENTRY_LENGTH);
		int signIndex = parameter.indexOf(StringUtil.ARXIVID_SEGMENTID_DELIMITER);
		String arxivId;
		if (signIndex != -1)
			arxivId = parameter.substring(0, signIndex);
		else
			arxivId = parameter;
		String segmentId;
		if (signIndex != -1)
			segmentId = parameter.substring(signIndex + 1);
		else
			segmentId = null;
		if (arxivId == null) {
			logger.error("The request with an empty arxiv id parameter");
			return;
		}
		String filePath;
		if (segmentId == null)
			filePath = format("/opt/mocassin/aux-pdf/%s" + StringUtil.arxivid2filename(arxivId, "pdf"));
		else
			filePath = "/opt/mocassin/pdf/"
					+ StringUtil.segmentid2filename(arxivId, Integer.parseInt(segmentId), "pdf");
		if (!new File(filePath).exists()) {
			filePath = format("/opt/mocassin/aux-pdf/%s", StringUtil.arxivid2filename(arxivId, "pdf"));
		}
		try {
			FileInputStream fileInputStream = new FileInputStream(filePath);
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			IOUtils.copy(fileInputStream, byteArrayOutputStream);
			resp.setContentType("application/pdf");
			resp.setHeader("Content-disposition",
					String.format("attachment; filename=%s", StringUtil.arxivid2filename(arxivId, "pdf")));
			ServletOutputStream outputStream = resp.getOutputStream();
			outputStream.write(byteArrayOutputStream.toByteArray());
			outputStream.close();
		} catch (FileNotFoundException e) {
			logger.error("Error while downloading: PDF file= '{}' not found", filePath);
		} catch (IOException e) {
			logger.error("Error while downloading the PDF file", e);
		}
	}

}