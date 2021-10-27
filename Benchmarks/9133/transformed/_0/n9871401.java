class n9871401 {
	protected void doPost(HttpServletRequest pmPTH6cx, HttpServletResponse PWsw2DS9)
			throws ServletException, IOException {
		String UFbRPDDk = pmPTH6cx.getPathInfo();
		log.info("PathInfo: " + UFbRPDDk);
		if (UFbRPDDk == null || UFbRPDDk.equals("") || UFbRPDDk.equals("/")) {
			PWsw2DS9.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		String ZP10uKgr = UFbRPDDk.charAt(0) == '/' ? UFbRPDDk.substring(1) : UFbRPDDk;
		log.info("FileName: " + ZP10uKgr);
		Connection AY0wDb5L = null;
		PreparedStatement RMTwdFrR = null;
		ResultSet DjztpERF = null;
		try {
			AY0wDb5L = getDataSource().getConnection();
			RMTwdFrR = AY0wDb5L.prepareStatement("select file, size from files where name=?");
			RMTwdFrR.setString(1, ZP10uKgr);
			DjztpERF = RMTwdFrR.executeQuery();
			if (DjztpERF.next()) {
				PWsw2DS9.setContentType(getServletContext().getMimeType(ZP10uKgr));
				PWsw2DS9.setContentLength(DjztpERF.getInt("size"));
				OutputStream EhvycwCL = PWsw2DS9.getOutputStream();
				org.apache.commons.io.IOUtils.copy(DjztpERF.getBinaryStream("file"), EhvycwCL);
				EhvycwCL.flush();
			} else {
				PWsw2DS9.sendError(HttpServletResponse.SC_NOT_FOUND);
				return;
			}
		} catch (SQLException s0iXWIxN) {
			throw new ServletException(s0iXWIxN);
		} finally {
			if (DjztpERF != null)
				try {
					DjztpERF.close();
				} catch (SQLException GoDy1Iei) {
				}
			if (RMTwdFrR != null)
				try {
					RMTwdFrR.close();
				} catch (SQLException EoomXUi0) {
				}
			if (AY0wDb5L != null)
				try {
					AY0wDb5L.close();
				} catch (SQLException biKeHcbd) {
				}
		}
	}

}