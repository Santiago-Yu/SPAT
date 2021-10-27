class n9209383 {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		boolean download = false;
		final Map<String, String> fileAttr = new HashMap<String, String>();
		String dw = req.getParameter("d");
		if (StringUtils.isNotEmpty(dw) && StringUtils.equals(dw, "true")) {
			download = true;
		}
		InputStream imageInputStream = null;
		final ByteArrayOutputStream imageOutputStream = new ByteArrayOutputStream(DEFAULT_CONTENT_LENGTH_SIZE);
		try {
			imageInputStream = getImageAsStream(req, fileAttr);
			IOUtils.copy(imageInputStream, imageOutputStream);
			resp.setHeader("Cache-Control", "no-store");
			resp.setHeader("Pragma", "no-cache");
			resp.setDateHeader("Expires", 0);
			resp.setContentType(fileAttr.get("mimetype"));
			if (download) {
				resp.setHeader("Content-Disposition", "attachment; filename=\"" + fileAttr.get("filename") + "\"");
			}
			final ServletOutputStream responseOutputStream = resp.getOutputStream();
			responseOutputStream.write(imageOutputStream.toByteArray());
			responseOutputStream.flush();
			responseOutputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
			resp.setContentType("text/html");
			resp.getWriter().println("<h1>Sorry... cannot find document</h1>");
		} finally {
			IOUtils.closeQuietly(imageInputStream);
			IOUtils.closeQuietly(imageOutputStream);
		}
	}

}