class n15115748 {
	public void render(final HttpServletRequest request, final HttpServletResponse response, InputStream inputStream,
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
		IOUtils.copy(inputStream, response.getOutputStream());
	}

}