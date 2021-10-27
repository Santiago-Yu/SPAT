class n12583301{
    public void doFilter(final ServletRequest arg0, final ServletResponse arg1, final FilterChain arg2) throws IOException, ServletException {
        if (!this.init) {
            final HttpServletResponse response = Dynamic._.Cast(arg1);
            response.sendError(HttpServletResponse.SC_SERVICE_UNAVAILABLE, "Mainfilter not initialized.");
            return;
        }
        if (this.mainFilter != null) {
            try {
                URL url = this.context.getResource("/WEB-INF/classes/log4j.properties");
                URLConnection uc = url.openConnection();
                if (uc.getLastModified() != lastLoadLog4j) {
                    lastLoadLog4j = uc.getLastModified();
                    try {
                        uc.getInputStream().close();
                    } catch (Exception ignore) {
                    }
                    PropertyConfigurator.configure(url);
                } else {
                    try {
                        uc.getInputStream().close();
                    } catch (Exception ignore) {
                    }
                }
            } catch (final Exception e) {
            }
            this.mainFilter.doFilter(arg0, arg1);
        } else {
            final HttpServletResponse response = Dynamic._.Cast(arg1);
            response.sendError(HttpServletResponse.SC_SERVICE_UNAVAILABLE, "Mainfilter bad setup.");
        }
    }

}