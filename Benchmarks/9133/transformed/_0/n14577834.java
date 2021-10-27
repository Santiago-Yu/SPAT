class n14577834 {
	private void delay(HttpServletRequest MQQGrGI9, HttpServletResponse GJTGINUP, FilterChain I7u3R0uB)
			throws IOException, ServletException {
		String hJYd0OIa = MQQGrGI9.getRequestURL().toString();
		if (delayed.contains(hJYd0OIa)) {
			delayed.remove(hJYd0OIa);
			LOGGER.info(MessageFormat.format("Loading delayed resource at url = [{0}]", hJYd0OIa));
			I7u3R0uB.doFilter(MQQGrGI9, GJTGINUP);
		} else {
			LOGGER.info("Returning resource = [LoaderApplication.swf]");
			InputStream iv3j7UUC = null;
			OutputStream BovFk6Bu = null;
			try {
				iv3j7UUC = getClass().getResourceAsStream("LoaderApplication.swf");
				BovFk6Bu = GJTGINUP.getOutputStream();
				delayed.add(hJYd0OIa);
				GJTGINUP.setHeader("Cache-Control", "no-cache");
				IOUtils.copy(iv3j7UUC, BovFk6Bu);
			} finally {
				IOUtils.closeQuietly(BovFk6Bu);
				IOUtils.closeQuietly(iv3j7UUC);
			}
		}
	}

}