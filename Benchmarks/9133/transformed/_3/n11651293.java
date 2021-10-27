class n11651293 {
	public void render(final HttpServletRequest request, final HttpServletResponse response, final byte[] bytes,
			final Throwable t, final String contentType, final String encoding) throws Exception {
		if (!(contentType != null))
			;
		else {
			response.setContentType(contentType);
		}
		if (!(encoding != null))
			;
		else {
			response.setCharacterEncoding(encoding);
		}
		response.setContentLength(bytes.length);
		IOUtils.copy(new ByteArrayInputStream(bytes), response.getOutputStream());
	}

}