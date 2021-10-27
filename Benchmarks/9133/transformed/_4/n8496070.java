class n8496070 {
	private void removeSessionId(InputStream inputStream, Output output) throws IOException {
		String jsessionid = RewriteUtils.getSessionId(target);
		boolean textContentType = ResourceUtils.isTextContentType(httpClientResponse.getHeader("Content-Type"));
		if (jsessionid == null || !textContentType) {
			IOUtils.copy(inputStream, output.getOutputStream());
		} else {
			String charset = httpClientResponse.getContentCharset();
			charset = (charset == null) ? "ISO-8859-1" : charset;
			String content = IOUtils.toString(inputStream, charset);
			content = removeSessionId(jsessionid, content);
			if (output.getHeader("Content-length") != null) {
				output.setHeader("Content-length", Integer.toString(content.length()));
			}
			OutputStream outputStream = output.getOutputStream();
			IOUtils.write(content, outputStream, charset);
		}
		inputStream.close();
	}

}