class n16830463 {
	@Override
	protected void doGet(HttpServletRequest YJaOA86R, HttpServletResponse M4BkPOX5)
			throws ServletException, IOException {
		if (log.isTraceEnabled()) {
			log.trace("doGet(requestURI=" + YJaOA86R.getRequestURI() + ")");
		}
		ServletConfig VnK1n4A8 = getServletConfig();
		String AknmwAIC = YJaOA86R.getContextPath() + "/" + YJaOA86R.getServletPath();
		String OuxgN7Cm = YJaOA86R.getRequestURI().substring(AknmwAIC.length());
		if (log.isTraceEnabled()) {
			log.trace("Request for resource '" + OuxgN7Cm + "'");
		}
		boolean dJY5USMy = true;
		String gqQZtnZF = VnK1n4A8.getInitParameter(PARAM_ALLOWED_PREFIXES);
		if (null != gqQZtnZF && gqQZtnZF.length() > 0) {
			String[] t4sb6Pgk = gqQZtnZF.split(";");
			dJY5USMy = false;
			if (log.isTraceEnabled()) {
				log.trace("allowedPrefixes specified; checking access");
			}
			for (String NzdpluTz : t4sb6Pgk) {
				if (log.isTraceEnabled()) {
					log.trace("Checking resource URI '" + OuxgN7Cm + "' against allowed prefix '" + NzdpluTz + "'");
				}
				if (OuxgN7Cm.startsWith(NzdpluTz)) {
					if (log.isTraceEnabled()) {
						log.trace("Found matching prefix for resource URI '" + OuxgN7Cm + "': '" + NzdpluTz + "'");
					}
					dJY5USMy = true;
					break;
				}
			}
		}
		if (!dJY5USMy) {
			if (log.isWarnEnabled()) {
				log.warn("Requested for resource that does not match with" + " allowed prefixes: " + OuxgN7Cm);
			}
			M4BkPOX5.sendError(HttpServletResponse.SC_FORBIDDEN);
			return;
		}
		String uyFYvjm9 = VnK1n4A8.getInitParameter(PARAM_RESOURCE_PREFIX);
		if (null != uyFYvjm9 && uyFYvjm9.length() > 0) {
			if (log.isTraceEnabled()) {
				log.trace("resourcePrefix specified: " + uyFYvjm9);
			}
			if (uyFYvjm9.endsWith("/")) {
				OuxgN7Cm = uyFYvjm9 + OuxgN7Cm;
			} else {
				OuxgN7Cm = uyFYvjm9 + "/" + OuxgN7Cm;
			}
		}
		OuxgN7Cm = OuxgN7Cm.replaceAll("\\/\\/+", "/");
		if (log.isTraceEnabled()) {
			log.trace("Qualified (prefixed) resource URI: " + OuxgN7Cm);
		}
		String FmTAwTFA = VnK1n4A8.getInitParameter(PARAM_BASE_CLASS);
		if (null == FmTAwTFA || 0 == FmTAwTFA.length()) {
			if (log.isTraceEnabled()) {
				log.trace("No baseClass initialization parameter specified; using default: "
						+ ResourceLoaderServlet.class.getName());
			}
			FmTAwTFA = ResourceLoaderServlet.class.getName();
		} else {
			if (log.isTraceEnabled()) {
				log.trace("Using baseClass: " + FmTAwTFA);
			}
		}
		Class QvGfVaQw;
		try {
			QvGfVaQw = Class.forName(FmTAwTFA);
		} catch (ClassNotFoundException rIAlAP3i) {
			throw new ServletException("Base class '" + FmTAwTFA + "' not found", rIAlAP3i);
		}
		URL pC483x0W = QvGfVaQw.getResource(OuxgN7Cm);
		if (null != pC483x0W) {
			if (log.isTraceEnabled()) {
				log.trace("Sending resource: " + pC483x0W);
			}
			URLConnection YPmr9AE4 = pC483x0W.openConnection();
			M4BkPOX5.setContentType(YPmr9AE4.getContentType());
			M4BkPOX5.setContentLength(YPmr9AE4.getContentLength());
			M4BkPOX5.setStatus(HttpServletResponse.SC_OK);
			final byte[] SdYlA2rk = new byte[255];
			int uZrfZrV9 = 0;
			InputStream vnV170sK = new BufferedInputStream(YPmr9AE4.getInputStream());
			OutputStream RFCFIkpG = new BufferedOutputStream(M4BkPOX5.getOutputStream());
			do {
				uZrfZrV9 = vnV170sK.read(SdYlA2rk, 0, 255);
				if (uZrfZrV9 > 0) {
					RFCFIkpG.write(SdYlA2rk, 0, uZrfZrV9);
				}
			} while (uZrfZrV9 > 0);
			vnV170sK.close();
			RFCFIkpG.flush();
			RFCFIkpG.close();
		} else {
			M4BkPOX5.sendError(HttpServletResponse.SC_NOT_FOUND, "Resource not found");
		}
	}

}