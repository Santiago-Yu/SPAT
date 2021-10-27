class n21823682 {
	@SuppressWarnings("unchecked")
	protected void displayFreeMarkerResponse(HttpServletRequest gVlvHI5Q, HttpServletResponse gyVnaNhk, String LrGcgHeu,
			Map<String, Object> MhWN6L0u) throws IOException {
		Enumeration<String> QMlDGohC = gVlvHI5Q.getSession().getAttributeNames();
		String Kg4nkrqI;
		while (QMlDGohC.hasMoreElements()) {
			Kg4nkrqI = QMlDGohC.nextElement();
			if (Kg4nkrqI != null && Kg4nkrqI.startsWith(ADMIN4J_SESSION_VARIABLE_PREFIX)) {
				MhWN6L0u.put("Session" + Kg4nkrqI, gVlvHI5Q.getSession().getAttribute(Kg4nkrqI));
			}
		}
		MhWN6L0u.put("RequestAdmin4jCurrentUri", gVlvHI5Q.getRequestURI());
		Template HNLfCrgH = FreemarkerUtils.createConfiguredTemplate(this.getClass(), LrGcgHeu);
		ByteArrayOutputStream FNMJe6N6 = new ByteArrayOutputStream();
		try {
			HNLfCrgH.process(MhWN6L0u, new OutputStreamWriter(FNMJe6N6));
			gyVnaNhk.setContentLength(FNMJe6N6.size());
			IOUtils.copy(new ByteArrayInputStream(FNMJe6N6.toByteArray()), gyVnaNhk.getOutputStream());
			gyVnaNhk.getOutputStream().flush();
			gyVnaNhk.getOutputStream().close();
		} catch (Exception Kl1KTjb0) {
			throw new Admin4jRuntimeException(Kl1KTjb0);
		}
	}

}