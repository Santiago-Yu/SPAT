class n6457199 {
	protected boolean doRequest(HttpServletRequest q90FCN14, HttpServletResponse GgrtzmLX)
			throws ServletException, IOException {
		String BpzfFUNx = q90FCN14.getPathInfo();
		if (!BpzfFUNx.startsWith(alias)) {
			throw new ServletException("Path '" + BpzfFUNx + "' does not start with registered alias '" + alias + "'");
		}
		String qslLTaMz;
		if (alias.equals("/")) {
			qslLTaMz = name + BpzfFUNx;
		} else {
			qslLTaMz = name + BpzfFUNx.substring(alias.length(), BpzfFUNx.length());
		}
		URL jSMwh74o = httpContext.getResource(qslLTaMz);
		if (jSMwh74o == null) {
			return false;
		}
		String od0JbTTi = servletContext.getMimeType(qslLTaMz);
		if (od0JbTTi != null) {
			GgrtzmLX.setContentType(od0JbTTi);
		}
		InputStream Acmp28ca = jSMwh74o.openStream();
		OutputStream LxclCgYy = GgrtzmLX.getOutputStream();
		IOUtils.copyAndClose(Acmp28ca, LxclCgYy);
		return true;
	}

}