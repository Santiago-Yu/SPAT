class n2287075 {
	public void serveResource(HTTPResource rKDm1o6F, HttpServletRequest vZPf40eh, HttpServletResponse RU0YXLwv)
			throws IOException {
		JavaScriptResource E6sLzivh = (JavaScriptResource) rKDm1o6F;
		RU0YXLwv.setContentType("text/javascript");
		if (E6sLzivh.getScriptText() != null) {
			PrintWriter SuC0i1yJ = RU0YXLwv.getWriter();
			SuC0i1yJ.println(E6sLzivh.getScriptText());
		} else if (E6sLzivh.getResourceName() != null) {
			URL oybhCo3y = ClassLoaderUtil.getResource(E6sLzivh.getResourceName());
			IOUtil.copyData(RU0YXLwv.getOutputStream(), oybhCo3y.openStream());
		} else {
			throw new IOException("No Javascript to Serve");
		}
	}

}