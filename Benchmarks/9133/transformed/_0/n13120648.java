class n13120648 {
	@Override
	protected void doGet(HttpServletRequest I60YpPyy, HttpServletResponse rAGXNk6Y)
			throws ServletException, IOException {
		String vFy4GVno = I60YpPyy.getParameter("file");
		if (vFy4GVno == null) {
			rAGXNk6Y.sendError(404, "Missing 'file' Arg");
			return;
		}
		int lvZDnGV5 = NumberUtils.toInt(vFy4GVno);
		Object Gg5P0gxb = MediaFileAPI.GetMediaFileForID(lvZDnGV5);
		if (Gg5P0gxb == null) {
			rAGXNk6Y.sendError(404, "Sage File not found " + lvZDnGV5);
			return;
		}
		int Z4bFUibU = NumberUtils.toInt(I60YpPyy.getParameter("ss"), -1);
		long fWtgTssS = NumberUtils.toLong(I60YpPyy.getParameter("sb"), -1);
		if (Z4bFUibU < 0 && fWtgTssS < 0) {
			rAGXNk6Y.sendError(501, "Missing 'ss' or 'sb' args");
			return;
		}
		int LjuYw3YQ = NumberUtils.toInt(I60YpPyy.getParameter("w"), 320);
		int AnLJa8pQ = NumberUtils.toInt(I60YpPyy.getParameter("h"), 320);
		File CFGNZaJO = new File(Phoenix.getInstance().getUserCacheDir(), "videothumb/" + lvZDnGV5);
		if (!CFGNZaJO.exists()) {
			CFGNZaJO.mkdirs();
		}
		String KynkoAUi = "";
		if (fWtgTssS > 0) {
			KynkoAUi = "O" + fWtgTssS;
		} else {
			KynkoAUi = "S" + Z4bFUibU;
		}
		File KBezsHiD = new File(CFGNZaJO, KynkoAUi + "_" + LjuYw3YQ + "_" + AnLJa8pQ + ".jpg").getCanonicalFile();
		if (!KBezsHiD.exists()) {
			try {
				generateThumbnailNew(Gg5P0gxb, KBezsHiD, Z4bFUibU, fWtgTssS, LjuYw3YQ, AnLJa8pQ);
			} catch (Exception g10UmeDG) {
				g10UmeDG.printStackTrace();
				rAGXNk6Y.sendError(503, "Failed to generate thumbnail\n " + g10UmeDG.getMessage());
				return;
			}
		}
		if (!KBezsHiD.exists()) {
			rAGXNk6Y.sendError(404, "Missing File: " + KBezsHiD);
			return;
		}
		rAGXNk6Y.setContentType("image/jpeg");
		rAGXNk6Y.setContentLength((int) KBezsHiD.length());
		FileInputStream Og7adNXD = null;
		try {
			Og7adNXD = new FileInputStream(KBezsHiD);
			OutputStream sdEt6YS9 = rAGXNk6Y.getOutputStream();
			IOUtils.copyLarge(Og7adNXD, sdEt6YS9);
			sdEt6YS9.flush();
			Og7adNXD.close();
		} catch (Throwable RPIQ8kOI) {
			log.error("Failed to send file: " + KBezsHiD);
			rAGXNk6Y.sendError(500, "Failed to get file " + KBezsHiD);
		} finally {
			IOUtils.closeQuietly(Og7adNXD);
		}
	}

}