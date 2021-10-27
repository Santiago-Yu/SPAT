class n12583301 {
	public void doFilter(final ServletRequest SJO7vHNH, final ServletResponse Hbdny8sP, final FilterChain Dihz0sFe)
			throws IOException, ServletException {
		if (!this.init) {
			final HttpServletResponse OqAEY325 = Dynamic._.Cast(Hbdny8sP);
			OqAEY325.sendError(HttpServletResponse.SC_SERVICE_UNAVAILABLE, "Mainfilter not initialized.");
			return;
		}
		if (this.mainFilter != null) {
			try {
				URL jq2QwNw8 = this.context.getResource("/WEB-INF/classes/log4j.properties");
				URLConnection bCwTrt9l = jq2QwNw8.openConnection();
				if (bCwTrt9l.getLastModified() != lastLoadLog4j) {
					lastLoadLog4j = bCwTrt9l.getLastModified();
					try {
						bCwTrt9l.getInputStream().close();
					} catch (Exception La7hkZAp) {
					}
					PropertyConfigurator.configure(jq2QwNw8);
				} else {
					try {
						bCwTrt9l.getInputStream().close();
					} catch (Exception pb54hQmx) {
					}
				}
			} catch (final Exception XQvxcOyG) {
			}
			this.mainFilter.doFilter(SJO7vHNH, Hbdny8sP);
		} else {
			final HttpServletResponse MJuSiiFL = Dynamic._.Cast(Hbdny8sP);
			MJuSiiFL.sendError(HttpServletResponse.SC_SERVICE_UNAVAILABLE, "Mainfilter bad setup.");
		}
	}

}