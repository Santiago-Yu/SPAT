class n23299439 {
	@Override
	protected void doGet(HttpServletRequest SXn51GHm, HttpServletResponse KrFuaGoo)
			throws ServletException, IOException {
		String ddenBlmf = SXn51GHm.getParameter("type");
		String TzzJfxPs = SXn51GHm.getParameter("file");
		if (TzzJfxPs == null) {
			KrFuaGoo.sendError(404, "Missing File Arg");
			return;
		}
		File AT8mjdfY = new File(TzzJfxPs);
		if (!AT8mjdfY.exists()) {
			KrFuaGoo.sendError(404, "Missing File: " + AT8mjdfY);
			return;
		}
		if (ddenBlmf != null) {
			KrFuaGoo.setContentType(ddenBlmf);
		}
		log.debug("Requested File: " + AT8mjdfY + " as type: " + ddenBlmf);
		KrFuaGoo.setContentLength((int) AT8mjdfY.length());
		FileInputStream kEREFXvV = null;
		try {
			kEREFXvV = new FileInputStream(AT8mjdfY);
			OutputStream njqnENcP = KrFuaGoo.getOutputStream();
			IOUtils.copyLarge(kEREFXvV, njqnENcP);
			njqnENcP.flush();
			kEREFXvV.close();
		} catch (Throwable wVNphYvQ) {
			log.error("Failed to send file: " + AT8mjdfY);
			KrFuaGoo.sendError(500, "Failed to get file " + AT8mjdfY);
		} finally {
			IOUtils.closeQuietly(kEREFXvV);
		}
	}

}