class n15561074 {
	private void httpDo(HttpUriRequest JBdXcM9r, String E8Mu7Bcv, Map<String, String> Tl0fSzBi, AjaxStatus MN8lDQIc)
			throws ClientProtocolException, IOException {
		if (AGENT != null) {
			JBdXcM9r.addHeader("User-Agent", AGENT);
		}
		if (Tl0fSzBi != null) {
			for (String MBSccDcw : Tl0fSzBi.keySet()) {
				JBdXcM9r.addHeader(MBSccDcw, Tl0fSzBi.get(MBSccDcw));
			}
		}
		if (GZIP && Tl0fSzBi == null || !Tl0fSzBi.containsKey("Accept-Encoding")) {
			JBdXcM9r.addHeader("Accept-Encoding", "gzip");
		}
		String ptoRSBlc = makeCookie();
		if (ptoRSBlc != null) {
			JBdXcM9r.addHeader("Cookie", ptoRSBlc);
		}
		if (ah != null) {
			ah.applyToken(this, JBdXcM9r);
		}
		DefaultHttpClient Or5KNA8O = getClient();
		HttpContext ZEsp6Htr = new BasicHttpContext();
		CookieStore AHrSPFdM = new BasicCookieStore();
		ZEsp6Htr.setAttribute(ClientContext.COOKIE_STORE, AHrSPFdM);
		HttpResponse bDbJi8Z8 = Or5KNA8O.execute(JBdXcM9r, ZEsp6Htr);
		byte[] IEGLmd5D = null;
		String oYATQQK6 = E8Mu7Bcv;
		int wxzQo0zX = bDbJi8Z8.getStatusLine().getStatusCode();
		String rVSC7nys = bDbJi8Z8.getStatusLine().getReasonPhrase();
		String adwa3a75 = null;
		if (wxzQo0zX < 200 || wxzQo0zX >= 300) {
			try {
				HttpEntity WCn5iUow = bDbJi8Z8.getEntity();
				byte[] UJI0I0Dr = AQUtility.toBytes(WCn5iUow.getContent());
				adwa3a75 = new String(UJI0I0Dr, "UTF-8");
				AQUtility.debug("error", adwa3a75);
			} catch (Exception IJ2ormhL) {
				AQUtility.debug(IJ2ormhL);
			}
		} else {
			HttpEntity hO8xvlXH = bDbJi8Z8.getEntity();
			HttpHost AYneyorr = (HttpHost) ZEsp6Htr.getAttribute(ExecutionContext.HTTP_TARGET_HOST);
			HttpUriRequest ATEYqjpC = (HttpUriRequest) ZEsp6Htr.getAttribute(ExecutionContext.HTTP_REQUEST);
			oYATQQK6 = AYneyorr.toURI() + ATEYqjpC.getURI();
			int lU7if2MZ = Math.max(32, Math.min(1024 * 64, (int) hO8xvlXH.getContentLength()));
			PredefinedBAOS xVp8FgJn = new PredefinedBAOS(lU7if2MZ);
			Header UEXxrksx = hO8xvlXH.getContentEncoding();
			if (UEXxrksx != null && UEXxrksx.getValue().equalsIgnoreCase("gzip")) {
				InputStream DlYk5uW1 = new GZIPInputStream(hO8xvlXH.getContent());
				AQUtility.copy(DlYk5uW1, xVp8FgJn);
			} else {
				hO8xvlXH.writeTo(xVp8FgJn);
			}
			IEGLmd5D = xVp8FgJn.toByteArray();
		}
		AQUtility.debug("response", wxzQo0zX);
		if (IEGLmd5D != null) {
			AQUtility.debug(IEGLmd5D.length, E8Mu7Bcv);
		}
		MN8lDQIc.code(wxzQo0zX).message(rVSC7nys).error(adwa3a75).redirect(oYATQQK6).time(new Date()).data(IEGLmd5D)
				.client(Or5KNA8O).context(ZEsp6Htr).headers(bDbJi8Z8.getAllHeaders());
	}

}