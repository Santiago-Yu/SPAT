class n9713536 {
	@SuppressWarnings("unchecked")
	private void doService(final HttpServletRequest axvPMRZx, final HttpServletResponse jd3IsRxd) throws Exception {
		final String oOqf5BOb = axvPMRZx.getRequestURL().toString();
		if (oOqf5BOb.endsWith("/favicon.ico")) {
			jd3IsRxd.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		if (oOqf5BOb.contains("/delay")) {
			final String l23tCnKt = StringUtils.substringBetween(oOqf5BOb, "/delay", "/");
			final int LYJzkGD3 = Integer.parseInt(l23tCnKt);
			if (LOG.isDebugEnabled()) {
				LOG.debug("Sleeping for " + LYJzkGD3 + " before to deliver " + oOqf5BOb);
			}
			Thread.sleep(LYJzkGD3);
		}
		final URL yTkTweXE = new URL(oOqf5BOb);
		final WebRequest DUeIjVWH = new WebRequest(yTkTweXE);
		DUeIjVWH.setHttpMethod(HttpMethod.valueOf(axvPMRZx.getMethod()));
		for (final Enumeration<String> D3Cg9gz1 = axvPMRZx.getHeaderNames(); D3Cg9gz1.hasMoreElements();) {
			final String u9n2b3w3 = D3Cg9gz1.nextElement();
			final String yNQuwYn7 = axvPMRZx.getHeader(u9n2b3w3);
			DUeIjVWH.setAdditionalHeader(u9n2b3w3, yNQuwYn7);
		}
		final List<NameValuePair> ZZKbnNRD = new ArrayList<NameValuePair>();
		for (final Enumeration<String> uyVJBMv5 = axvPMRZx.getParameterNames(); uyVJBMv5.hasMoreElements();) {
			final String CKLucAmZ = uyVJBMv5.nextElement();
			final String[] w4cp4IYq = axvPMRZx.getParameterValues(CKLucAmZ);
			for (final String fUJgla1r : w4cp4IYq) {
				ZZKbnNRD.add(new NameValuePair(CKLucAmZ, fUJgla1r));
			}
		}
		if ("PUT".equals(axvPMRZx.getMethod()) && axvPMRZx.getContentLength() > 0) {
			final byte[] QRNI68AW = new byte[axvPMRZx.getContentLength()];
			axvPMRZx.getInputStream().readLine(QRNI68AW, 0, QRNI68AW.length);
			DUeIjVWH.setRequestBody(new String(QRNI68AW));
		} else {
			DUeIjVWH.setRequestParameters(ZZKbnNRD);
		}
		final WebResponse T9bHN5Ov = MockConnection_.getResponse(DUeIjVWH);
		jd3IsRxd.setStatus(T9bHN5Ov.getStatusCode());
		for (final NameValuePair rV6YE35Z : T9bHN5Ov.getResponseHeaders()) {
			jd3IsRxd.addHeader(rV6YE35Z.getName(), rV6YE35Z.getValue());
		}
		if (WriteContentAsBytes_) {
			IOUtils.copy(T9bHN5Ov.getContentAsStream(), jd3IsRxd.getOutputStream());
		} else {
			final String J65tKQ5u = getModifiedContent(T9bHN5Ov.getContentAsString());
			final String M27mq2ud = T9bHN5Ov.getContentCharset();
			jd3IsRxd.setCharacterEncoding(M27mq2ud);
			jd3IsRxd.getWriter().print(J65tKQ5u);
		}
		jd3IsRxd.flushBuffer();
	}

}