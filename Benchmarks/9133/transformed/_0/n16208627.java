class n16208627 {
	@Override
	protected void doPost(final HttpServletRequest ZCBsuXES, final HttpServletResponse evLPW6Aw)
			throws ServletException, IOException {
		final String JFqm1k3b = ZCBsuXES.getParameter("url");
		if (!isAllowed(JFqm1k3b)) {
			evLPW6Aw.setStatus(HttpServletResponse.SC_FORBIDDEN);
			return;
		}
		final HttpClient UpBa8rls = new HttpClient();
		UpBa8rls.getParams().setVersion(HttpVersion.HTTP_1_0);
		final PostMethod ajI47UuJ = new PostMethod(JFqm1k3b);
		ajI47UuJ.getParams().setVersion(HttpVersion.HTTP_1_0);
		ajI47UuJ.setFollowRedirects(false);
		final RequestEntity uqC3q9WE = new InputStreamRequestEntity(ZCBsuXES.getInputStream());
		ajI47UuJ.setRequestEntity(uqC3q9WE);
		try {
			final int kEpvVUfb = UpBa8rls.executeMethod(ajI47UuJ);
			if (kEpvVUfb != -1) {
				InputStream c3XCa3AT = null;
				ServletOutputStream OFFmntEy = null;
				try {
					c3XCa3AT = ajI47UuJ.getResponseBodyAsStream();
					try {
						OFFmntEy = evLPW6Aw.getOutputStream();
						IOUtils.copy(c3XCa3AT, OFFmntEy);
					} finally {
						if (OFFmntEy != null) {
							try {
								OFFmntEy.flush();
							} catch (IOException zJ46tsct) {
							}
						}
					}
				} catch (IOException c2pZoq8w) {
					final String SgFpbGB4 = c2pZoq8w.getMessage();
					if (!"chunked stream ended unexpectedly".equals(SgFpbGB4)) {
						throw c2pZoq8w;
					}
				} finally {
					IOUtils.closeQuietly(c3XCa3AT);
				}
			}
		} finally {
			ajI47UuJ.releaseConnection();
		}
	}

}