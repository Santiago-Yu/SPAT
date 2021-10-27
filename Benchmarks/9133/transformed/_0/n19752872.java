class n19752872 {
	public void searchEntity(HttpServletRequest csQmbqfw, HttpServletResponse a4mOrvss, SearchCommand BhtbjDXA) {
		setHeader(a4mOrvss);
		logger.debug("Search: Looking for the entity with the id:" + BhtbjDXA.getSearchedid());
		String pS7SXDs6 = BhtbjDXA.getLogin();
		String Ti7HhKw9 = BhtbjDXA.getPassword();
		SynchronizableUser my1bgRGo = userAccessControl.authenticate(pS7SXDs6, Ti7HhKw9);
		if (my1bgRGo != null) {
			try {
				File HdBblKSt = File.createTempFile("medoo", "search");
				OutputStream KIdpdqG1 = new FileOutputStream(HdBblKSt);
				syncServer.searchEntity(my1bgRGo, BhtbjDXA.getSearchedid(), KIdpdqG1);
				InputStream gzTIBdBQ = new FileInputStream(HdBblKSt);
				a4mOrvss.setContentLength(gzTIBdBQ.available());
				while (gzTIBdBQ.available() > 0) {
					a4mOrvss.getOutputStream().write(gzTIBdBQ.read());
				}
				a4mOrvss.getOutputStream().flush();
				a4mOrvss.flushBuffer();
			} catch (IOException MGxFuEa9) {
				logger.error(MGxFuEa9.getMessage(), MGxFuEa9);
			} catch (ImogSerializationException NsQEY38G) {
				logger.error(NsQEY38G.getMessage(), NsQEY38G);
			}
		} else {
			try {
				OutputStream j0wNVM6U = a4mOrvss.getOutputStream();
				j0wNVM6U.write("-ERROR-".getBytes());
				j0wNVM6U.flush();
				j0wNVM6U.close();
				logger.debug("Search: user " + pS7SXDs6 + " has not been authenticated");
			} catch (IOException bJ09ziX8) {
				bJ09ziX8.printStackTrace();
			}
		}
	}

}