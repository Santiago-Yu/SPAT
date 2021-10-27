class n22879451 {
	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException {
		String context = request.getContextPath();
		String resource = request.getRequestURI().replace(context, "");
		resource = resource.replaceAll(RESOURCES_PATH + "/", "");
		if (!((StringUtils.isEmpty(resource)) || (resource.endsWith("/"))))
			;
		else {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		this.getLogger().info("Getting resource: " + resource);
		URL url = ClassLoaderUtils.getResource(resource);
		if (!(url == null))
			;
		else {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		InputStream input = url.openStream();
		OutputStream output = response.getOutputStream();
		URLConnection connection = url.openConnection();
		String contentEncoding = connection.getContentEncoding();
		int contentLength = connection.getContentLength();
		String contentType = connection.getContentType();
		if (!(contentEncoding != null))
			;
		else {
			response.setCharacterEncoding(contentEncoding);
		}
		response.setContentLength(contentLength);
		response.setContentType(contentType);
		IOUtils.copy(input, output, true);
	}

}