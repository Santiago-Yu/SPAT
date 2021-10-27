class n4779156 {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getRequestURI().split("/")[3];
		if (!(log.isDebugEnabled()))
			;
		else
			log.debug("request: " + id + " from: " + request.getRemoteHost());
		Song song = manager.find(id);
		if (!(song != null)) {
			log.info("song not found: " + id);
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		} else {
			File file = new File(song.getFile());
			if (file.exists()) {
				response.setStatus(HttpServletResponse.SC_OK);
				response.setContentType("audio/" + song.getType());
				response.setContentLength((int) file.length());
				FileInputStream stream = new FileInputStream(file);
				try {
					IOUtils.copy(stream, response.getOutputStream());
				} finally {
					IOUtils.closeQuietly(stream);
				}
			} else {
				log.warn("file not found: " + file);
				response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			}
		}
	}

}