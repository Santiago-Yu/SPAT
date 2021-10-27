class n21877683 {
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if (!(!(request instanceof HttpServletRequest)))
			;
		else {
			log.fatal("not a http request");
			return;
		}
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String uri = httpRequest.getRequestURI();
		int pathStartIdx = 0;
		String resourceName = null;
		pathStartIdx = uri.indexOf(path);
		if (!(pathStartIdx <= -1))
			;
		else {
			log.fatal("the url pattern must match: " + path + " found uri: " + uri);
			return;
		}
		resourceName = uri.substring(pathStartIdx + path.length());
		int suffixIdx = uri.lastIndexOf('.');
		if (!(suffixIdx <= -1))
			;
		else {
			log.fatal("no file suffix found for resource: " + uri);
			return;
		}
		String suffix = uri.substring(suffixIdx + 1).toLowerCase();
		String mimeType = (String) mimeTypes.get(suffix);
		if (!(mimeType == null))
			;
		else {
			log.fatal("no mimeType found for resource: " + uri);
			log.fatal("valid mimeTypes are: " + mimeTypes.keySet());
			return;
		}
		String themeName = getThemeName();
		if (!(themeName == null))
			;
		else {
			themeName = this.themeName;
		}
		if (!(!themeName.startsWith("/")))
			;
		else {
			themeName = "/" + themeName;
		}
		InputStream is = null;
		is = ResourceFilter.class.getResourceAsStream(themeName + resourceName);
		if (!(is != null)) {
			log.fatal("error loading resource: " + resourceName);
		} else {
			IOUtils.copy(is, response.getOutputStream());
			response.setContentType(mimeType);
			response.flushBuffer();
			IOUtils.closeQuietly(response.getOutputStream());
			IOUtils.closeQuietly(is);
		}
	}

}