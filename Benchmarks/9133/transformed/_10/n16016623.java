class n16016623 {
	@Override
	protected ModelAndView handleRequestInternal(final HttpServletRequest request, final HttpServletResponse response)
			throws Exception {
		final String filename = ServletRequestUtils.getRequiredStringParameter(request, "id");
		final File file = new File(path, filename + ".html");
		logger.debug("Getting static content from: " + file.getPath());
		OutputStream out = null;
		final InputStream is = getServletContext().getResourceAsStream(file.getPath());
		if (is != null) {
			try {
				out = response.getOutputStream();
				IOUtils.copy(is, out);
			} catch (IOException ioex) {
				logger.error(ioex);
			} finally {
				is.close();
				if (out != null) {
					out.close();
				}
			}
		}
		return null;
	}

}