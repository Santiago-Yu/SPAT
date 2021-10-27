class n9209383 {
	@Override
	protected void doGet(HttpServletRequest hNWoAnYs, HttpServletResponse dQ2A7HUt)
			throws ServletException, IOException {
		final Map<String, String> I3lmUgft = new HashMap<String, String>();
		boolean cOZ6U9Gv = false;
		String OHyqk0kE = hNWoAnYs.getParameter("d");
		if (StringUtils.isNotEmpty(OHyqk0kE) && StringUtils.equals(OHyqk0kE, "true")) {
			cOZ6U9Gv = true;
		}
		final ByteArrayOutputStream iGbyk2M0 = new ByteArrayOutputStream(DEFAULT_CONTENT_LENGTH_SIZE);
		InputStream e7PWC7wu = null;
		try {
			e7PWC7wu = getImageAsStream(hNWoAnYs, I3lmUgft);
			IOUtils.copy(e7PWC7wu, iGbyk2M0);
			dQ2A7HUt.setHeader("Cache-Control", "no-store");
			dQ2A7HUt.setHeader("Pragma", "no-cache");
			dQ2A7HUt.setDateHeader("Expires", 0);
			dQ2A7HUt.setContentType(I3lmUgft.get("mimetype"));
			if (cOZ6U9Gv) {
				dQ2A7HUt.setHeader("Content-Disposition", "attachment; filename=\"" + I3lmUgft.get("filename") + "\"");
			}
			final ServletOutputStream YSrO5P96 = dQ2A7HUt.getOutputStream();
			YSrO5P96.write(iGbyk2M0.toByteArray());
			YSrO5P96.flush();
			YSrO5P96.close();
		} catch (Exception vt7wtVoT) {
			vt7wtVoT.printStackTrace();
			dQ2A7HUt.setContentType("text/html");
			dQ2A7HUt.getWriter().println("<h1>Sorry... cannot find document</h1>");
		} finally {
			IOUtils.closeQuietly(e7PWC7wu);
			IOUtils.closeQuietly(iGbyk2M0);
		}
	}

}