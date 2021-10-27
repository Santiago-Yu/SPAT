class n21877683 {
	public void doFilter(ServletRequest UbixXCil, ServletResponse V4mkrk0R, FilterChain XE6KydU8)
			throws IOException, ServletException {
		if (!(UbixXCil instanceof HttpServletRequest)) {
			log.fatal("not a http request");
			return;
		}
		HttpServletRequest N2HHTvse = (HttpServletRequest) UbixXCil;
		String zcVVuBgQ = N2HHTvse.getRequestURI();
		int LQtmSNA1 = 0;
		String ukjW7SUG = null;
		LQtmSNA1 = zcVVuBgQ.indexOf(path);
		if (LQtmSNA1 <= -1) {
			log.fatal("the url pattern must match: " + path + " found uri: " + zcVVuBgQ);
			return;
		}
		ukjW7SUG = zcVVuBgQ.substring(LQtmSNA1 + path.length());
		int R1jbo6A4 = zcVVuBgQ.lastIndexOf('.');
		if (R1jbo6A4 <= -1) {
			log.fatal("no file suffix found for resource: " + zcVVuBgQ);
			return;
		}
		String hKxTlJR1 = zcVVuBgQ.substring(R1jbo6A4 + 1).toLowerCase();
		String KVQKHZvi = (String) mimeTypes.get(hKxTlJR1);
		if (KVQKHZvi == null) {
			log.fatal("no mimeType found for resource: " + zcVVuBgQ);
			log.fatal("valid mimeTypes are: " + mimeTypes.keySet());
			return;
		}
		String ec1OJvej = getThemeName();
		if (ec1OJvej == null) {
			ec1OJvej = this.themeName;
		}
		if (!ec1OJvej.startsWith("/")) {
			ec1OJvej = "/" + ec1OJvej;
		}
		InputStream gdFOFYr5 = null;
		gdFOFYr5 = ResourceFilter.class.getResourceAsStream(ec1OJvej + ukjW7SUG);
		if (gdFOFYr5 != null) {
			IOUtils.copy(gdFOFYr5, V4mkrk0R.getOutputStream());
			V4mkrk0R.setContentType(KVQKHZvi);
			V4mkrk0R.flushBuffer();
			IOUtils.closeQuietly(V4mkrk0R.getOutputStream());
			IOUtils.closeQuietly(gdFOFYr5);
		} else {
			log.fatal("error loading resource: " + ukjW7SUG);
		}
	}

}