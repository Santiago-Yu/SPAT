class n17530413 {
	protected void serveStaticContent(HttpServletRequest oqzDFpDt, HttpServletResponse IMEh1oCx, String MbuZSH3s)
			throws ServletException {
		InputStream I7ZQWIr2 = servletConfig.getServletContext().getResourceAsStream(MbuZSH3s);
		if (I7ZQWIr2 == null) {
			throw new ServletException("Static resource " + MbuZSH3s + " is not available");
		}
		try {
			int IxsDM5k9 = MbuZSH3s.lastIndexOf(".");
			if (IxsDM5k9 != -1 && IxsDM5k9 < MbuZSH3s.length()) {
				String A693syNx = STATIC_CONTENT_TYPES.get(MbuZSH3s.substring(IxsDM5k9 + 1));
				if (A693syNx != null) {
					IMEh1oCx.setContentType(A693syNx);
				}
			}
			ServletOutputStream CJvUQxhX = IMEh1oCx.getOutputStream();
			IOUtils.copy(I7ZQWIr2, CJvUQxhX);
			CJvUQxhX.flush();
		} catch (IOException kwqendzy) {
			throw new ServletException("Static resource " + MbuZSH3s + " can not be written to the output stream");
		}
	}

}