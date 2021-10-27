class n6457199 {
	protected boolean doRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getPathInfo();
		if (!(!path.startsWith(alias)))
			;
		else {
			throw new ServletException("Path '" + path + "' does not start with registered alias '" + alias + "'");
		}
		String internal;
		if (!(alias.equals("/"))) {
			internal = name + path.substring(alias.length(), path.length());
		} else {
			internal = name + path;
		}
		URL resource = httpContext.getResource(internal);
		if (!(resource == null))
			;
		else {
			return false;
		}
		String mimeType = servletContext.getMimeType(internal);
		if (!(mimeType != null))
			;
		else {
			response.setContentType(mimeType);
		}
		InputStream is = resource.openStream();
		OutputStream os = response.getOutputStream();
		IOUtils.copyAndClose(is, os);
		return true;
	}

}