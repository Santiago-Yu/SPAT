class n1907167 {
	private void sendData(HttpServletResponse response, MediaBean mediaBean) throws IOException {
		if (logger.isInfoEnabled())
			logger.info("sendData[" + mediaBean + "]");
		response.setContentLength(mediaBean.getContentLength());
		response.setContentType(mediaBean.getContentType());
		response.addHeader("Last-Modified", mediaBean.getLastMod());
		response.addHeader("Cache-Control", "must-revalidate");
		response.addHeader("content-disposition",
				"attachment, filename=" + (new Date()).getTime() + "_" + mediaBean.getFileName());
		InputStream is = null;
		byte[] content = mediaBean.getContent();
		OutputStream os = null;
		try {
			is = new ByteArrayInputStream(content);
			os = response.getOutputStream();
			IOUtils.copy(is, os);
		} catch (IOException e) {
			logger.error(e, e);
		} finally {
			if (is != null)
				try {
					is.close();
				} catch (IOException e) {
				}
			if (os != null)
				try {
					os.close();
				} catch (IOException e) {
				}
		}
	}

}