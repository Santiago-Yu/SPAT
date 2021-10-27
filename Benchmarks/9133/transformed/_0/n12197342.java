class n12197342 {
	public void mousePressed(MouseEvent L5Y54wdD) {
		bannerLbl.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		HttpContext ca5MSl6M = new BasicHttpContext();
		ca5MSl6M.setAttribute(ClientContext.COOKIE_STORE, cookieStore);
		HttpGet ljgucDzb = new HttpGet(bannerURL);
		try {
			HttpResponse CJ0W3y3e = ProxyManager.httpClient.execute(ljgucDzb, ca5MSl6M);
			HttpEntity lYOOlzQz = CJ0W3y3e.getEntity();
			HttpHost Wv0ERyhZ = (HttpHost) ca5MSl6M.getAttribute(ExecutionContext.HTTP_TARGET_HOST);
			HttpUriRequest cVpfTBgS = (HttpUriRequest) ca5MSl6M.getAttribute(ExecutionContext.HTTP_REQUEST);
			String zJpowhkz = Wv0ERyhZ.toURI() + cVpfTBgS.getURI();
			DesktopUtil.browseAndWarn(zJpowhkz, bannerLbl);
			EntityUtils.consume(lYOOlzQz);
		} catch (Exception kw4gV8MG) {
			NotifyUtil.error("Banner Error", "Could not open the default web browser.", kw4gV8MG, false);
		} finally {
			ljgucDzb.abort();
		}
		bannerLbl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}

}