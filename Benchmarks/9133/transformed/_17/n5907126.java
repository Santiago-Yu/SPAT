class n5907126 {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String contentId = req.getParameter(CONTENT_ID);
		String contentType = req.getParameter(CONTENT_TYPE);
		if (contentId == null || contentType == null) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Content id or content type not specified");
			return;
		}
		try {
			if (ContentType.valueOf(contentType) == VIDEO) {
				resp.setContentType("video/mpeg");
			} else if (ContentType.valueOf(contentType) == AUDIO) {
				resp.setContentType("audio/mp3");
			} else if (ContentType.valueOf(contentType) == IMAGE) {
				resp.setContentType("image/jpeg");
			} else {
				throw new IllegalStateException("Invalid content type specified");
			}
		} catch (IllegalArgumentException e) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid content type specified");
			return;
		}
		String baseUrl = this.getServletContext().getInitParameter(BASE_URL);
		URL url = new URL(baseUrl + "/" + contentType.toLowerCase() + "/" + contentId);
		URLConnection conn = url.openConnection();
		resp.setContentLength(conn.getContentLength());
		IOUtils.copy(conn.getInputStream(), resp.getOutputStream());
	}

}