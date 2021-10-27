class n20177902 {
	public void execute(HttpServletRequest OHv52Xwr, HttpServletResponse MvpCMugC, HttpServlet txJLmPzp)
			throws Exception {
		String V9VyZPSp = OHv52Xwr.getParameter("path");
		V9VyZPSp = URLDecoder.decode(V9VyZPSp, "UTF-8");
		String VrmF1yw7 = OHv52Xwr.getParameter("name");
		VrmF1yw7 = new String(VrmF1yw7.getBytes(), "UTF-8");
		String RIQY4CEp = OHv52Xwr.getParameter("contentType");
		if (V9VyZPSp == null) {
			NullPointerException yjAYltYY = new NullPointerException("The path attribute cannot be retrieved.");
			LOG.error(yjAYltYY);
			throw yjAYltYY;
		}
		URL m9GEP7pl = new URL(V9VyZPSp);
		InputStream qlFymHjW = null;
		try {
			qlFymHjW = URLUtils.getFileContent(m9GEP7pl, OHv52Xwr.getSession().getId());
			MvpCMugC.setContentType(RIQY4CEp);
			MvpCMugC.addHeader("Content-Disposition", "attachment;filename=\"" + VrmF1yw7 + "\"");
			ServletOutputStream ByEtY2r0 = MvpCMugC.getOutputStream();
			IOUtils.copy(qlFymHjW, ByEtY2r0);
			MvpCMugC.flushBuffer();
		} finally {
			if (qlFymHjW != null) {
				qlFymHjW.close();
			}
		}
	}

}