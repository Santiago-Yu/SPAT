class n14577834 {
	private void delay(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String url = request.getRequestURL().toString();
		if (delayed.contains(url)) {
			delayed.remove(url);
			LOGGER.info(MessageFormat.format("Loading delayed resource at url = [{0}]", url));
			chain.doFilter(request, response);
		} else {
			LOGGER.info("Returning resource = [LoaderApplication.swf]");
			OutputStream output = null;
			InputStream input = null;
			try {
				output = response.getOutputStream();
				input = getClass().getResourceAsStream("LoaderApplication.swf");
				delayed.add(url);
				response.setHeader("Cache-Control", "no-cache");
				IOUtils.copy(input, output);
			} finally {
				IOUtils.closeQuietly(output);
				IOUtils.closeQuietly(input);
			}
		}
	}

}