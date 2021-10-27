class n2972949 {
	@Override
	protected void doGet(HttpServletRequest GwH3qmnd, HttpServletResponse PF2GiSYY)
			throws ServletException, IOException {
		if (GwH3qmnd.getParameter("i") != null) {
			String rNxl1z4s = GwH3qmnd.getParameter("i");
			if (rNxl1z4s == null) {
				PF2GiSYY.sendError(404, "Image was null");
				return;
			}
			File dMaHLhDK = null;
			if (rNxl1z4s.startsWith("file")) {
				try {
					dMaHLhDK = new File(new URI(rNxl1z4s));
				} catch (URISyntaxException QYTgcDzU) {
					PF2GiSYY.sendError(500, QYTgcDzU.getMessage());
					return;
				}
			} else {
				dMaHLhDK = new File(rNxl1z4s);
			}
			if (dMaHLhDK.exists()) {
				dMaHLhDK = dMaHLhDK.getCanonicalFile();
				if (dMaHLhDK.getName().endsWith(".jpg") || dMaHLhDK.getName().endsWith(".png")) {
					PF2GiSYY.setContentType("image/png");
					FileInputStream JSMwcMH0 = null;
					OutputStream c9ZW6JyP = PF2GiSYY.getOutputStream();
					try {
						JSMwcMH0 = new FileInputStream(dMaHLhDK);
						IOUtils.copy(JSMwcMH0, c9ZW6JyP);
					} finally {
						c9ZW6JyP.flush();
						if (JSMwcMH0 != null)
							JSMwcMH0.close();
					}
				}
			}
			return;
		}
		String ZsoUzEjO = "/media" + GwH3qmnd.getPathInfo();
		String y6fBnklV[] = ZsoUzEjO.split("/");
		mediaHandler.handleRequest(y6fBnklV, GwH3qmnd, PF2GiSYY);
	}

}