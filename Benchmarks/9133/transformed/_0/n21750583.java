class n21750583 {
	protected void doProxyInternally(HttpServletRequest UQS7PDVU, HttpServletResponse t6HpL2Vo)
			throws ServletException, IOException {
		HttpRequestBase TCzLmKDS = buildProxyRequest(UQS7PDVU);
		URI LE9e37gb = TCzLmKDS.getURI();
		String s3RHgkhH = LE9e37gb.getHost();
		DefaultHttpClient rSN5huIw = new DefaultHttpClient();
		HttpContext eP1LrHTK = new BasicHttpContext();
		eP1LrHTK.setAttribute("org.atricorel.idbus.kernel.main.binding.http.HttpServletRequest", UQS7PDVU);
		int NHbRgafh = 0;
		for (int CwMBVd7P = 0; CwMBVd7P < rSN5huIw.getRequestInterceptorCount(); CwMBVd7P++) {
			if (rSN5huIw.getRequestInterceptor(CwMBVd7P) instanceof RequestAddCookies) {
				NHbRgafh = CwMBVd7P;
				break;
			}
		}
		IDBusRequestAddCookies Wv6BOcss = new IDBusRequestAddCookies(s3RHgkhH);
		rSN5huIw.removeRequestInterceptorByClass(RequestAddCookies.class);
		rSN5huIw.addRequestInterceptor(Wv6BOcss, NHbRgafh);
		rSN5huIw.getParams().setParameter(ClientPNames.HANDLE_REDIRECTS, false);
		rSN5huIw.getParams().setParameter(ClientPNames.COOKIE_POLICY, CookiePolicy.BROWSER_COMPATIBILITY);
		if (logger.isTraceEnabled())
			logger.trace("Staring to follow redirects for " + UQS7PDVU.getPathInfo());
		HttpResponse qHYWmukm = null;
		List<Header> mFmG4dlA = new ArrayList<Header>(40);
		boolean jp3gxiDy = true;
		byte[] GF0mHMHs = new byte[1024];
		while (jp3gxiDy) {
			if (logger.isTraceEnabled())
				logger.trace("Sending internal request " + TCzLmKDS);
			qHYWmukm = rSN5huIw.execute(TCzLmKDS, eP1LrHTK);
			String gr8qclMz = null;
			Header[] Ac8WIPkY = qHYWmukm.getAllHeaders();
			for (Header LR7vkw5C : Ac8WIPkY) {
				if (LR7vkw5C.getName().equals("Server"))
					continue;
				if (LR7vkw5C.getName().equals("Transfer-Encoding"))
					continue;
				if (LR7vkw5C.getName().equals("Location"))
					continue;
				if (LR7vkw5C.getName().equals("Expires"))
					continue;
				if (LR7vkw5C.getName().equals("Content-Length"))
					continue;
				if (LR7vkw5C.getName().equals("Content-Type"))
					continue;
				mFmG4dlA.add(LR7vkw5C);
			}
			if (logger.isTraceEnabled())
				logger.trace("HTTP/STATUS:" + qHYWmukm.getStatusLine().getStatusCode() + "[" + TCzLmKDS + "]");
			switch (qHYWmukm.getStatusLine().getStatusCode()) {
			case 200:
				jp3gxiDy = false;
				break;
			case 404:
				jp3gxiDy = false;
				break;
			case 500:
				jp3gxiDy = false;
				break;
			case 302:
				Header rKV2Grs8 = qHYWmukm.getFirstHeader("Location");
				gr8qclMz = rKV2Grs8.getValue();
				if (!internalProcessingPolicy.match(UQS7PDVU, gr8qclMz)) {
					if (logger.isTraceEnabled())
						logger.trace("Do not follow HTTP 302 to [" + rKV2Grs8.getValue() + "]");
					Collections.addAll(mFmG4dlA, qHYWmukm.getHeaders("Location"));
					jp3gxiDy = false;
				} else {
					if (logger.isTraceEnabled())
						logger.trace("Do follow HTTP 302 to [" + rKV2Grs8.getValue() + "]");
					jp3gxiDy = true;
				}
				break;
			default:
				jp3gxiDy = false;
				break;
			}
			HttpEntity RluiUVNZ = qHYWmukm.getEntity();
			if (RluiUVNZ != null) {
				InputStream uAIqBuO4 = RluiUVNZ.getContent();
				try {
					if (!jp3gxiDy) {
						for (Header dpyPZ6T0 : Ac8WIPkY) {
							if (dpyPZ6T0.getName().equals("Content-Type"))
								t6HpL2Vo.setHeader(dpyPZ6T0.getName(), dpyPZ6T0.getValue());
							if (dpyPZ6T0.getName().equals("Content-Length"))
								t6HpL2Vo.setHeader(dpyPZ6T0.getName(), dpyPZ6T0.getValue());
						}
						t6HpL2Vo.setStatus(qHYWmukm.getStatusLine().getStatusCode());
						for (Header axvcjsvy : mFmG4dlA) {
							if (axvcjsvy.getName().startsWith("Set-Cookie"))
								t6HpL2Vo.addHeader(axvcjsvy.getName(), axvcjsvy.getValue());
							else
								t6HpL2Vo.setHeader(axvcjsvy.getName(), axvcjsvy.getValue());
						}
						IOUtils.copy(uAIqBuO4, t6HpL2Vo.getOutputStream());
						t6HpL2Vo.getOutputStream().flush();
					} else {
						int uvVUoGim = uAIqBuO4.read(GF0mHMHs);
						int ALqn70iR = uvVUoGim;
						while (uvVUoGim > 0) {
							uvVUoGim = uAIqBuO4.read(GF0mHMHs);
							ALqn70iR += uvVUoGim;
						}
						if (ALqn70iR > 0)
							logger.warn("Ignoring response content size : " + ALqn70iR);
					}
				} catch (IOException WyhcDKYg) {
					throw WyhcDKYg;
				} catch (RuntimeException vDB7L5Os) {
					TCzLmKDS.abort();
					throw vDB7L5Os;
				} finally {
					try {
						uAIqBuO4.close();
					} catch (Exception G6a87dn5) {
					}
				}
			} else {
				if (!jp3gxiDy) {
					t6HpL2Vo.setStatus(qHYWmukm.getStatusLine().getStatusCode());
					for (Header wdrADF6B : Ac8WIPkY) {
						if (wdrADF6B.getName().equals("Content-Type"))
							t6HpL2Vo.setHeader(wdrADF6B.getName(), wdrADF6B.getValue());
						if (wdrADF6B.getName().equals("Content-Length"))
							t6HpL2Vo.setHeader(wdrADF6B.getName(), wdrADF6B.getValue());
					}
					for (Header R7EkqJDw : mFmG4dlA) {
						if (R7EkqJDw.getName().startsWith("Set-Cookie"))
							t6HpL2Vo.addHeader(R7EkqJDw.getName(), R7EkqJDw.getValue());
						else
							t6HpL2Vo.setHeader(R7EkqJDw.getName(), R7EkqJDw.getValue());
					}
				}
			}
			if (jp3gxiDy) {
				TCzLmKDS = buildProxyRequest(gr8qclMz);
				eP1LrHTK = null;
			}
		}
		if (logger.isTraceEnabled())
			logger.trace("Ended following redirects for " + UQS7PDVU.getPathInfo());
	}

}