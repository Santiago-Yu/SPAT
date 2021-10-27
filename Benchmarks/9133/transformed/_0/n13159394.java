class n13159394 {
	public HttpResponse fetch(HttpServletRequest vZKG9dRh) throws IOException {
		GUI = SwingUI.getApplicatoin();
		DefaultHttpClient XqUm2Wyj = new DefaultHttpClient();
		CookieSpecFactory nCswghoG = new CookieSpecFactory() {

			public CookieSpec newInstance(HttpParams pVIEjxrG) {
				return new BrowserCompatSpec() {

					@Override
					public void validate(Cookie iizLk8vu, CookieOrigin js5e89ca) throws MalformedCookieException {
					}
				};
			}
		};
		if (Helper.useProxy()) {
			HttpHost Uku23FV2 = new HttpHost(Helper.getProxyServer(), Helper.getProxyPort());
			XqUm2Wyj.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, Uku23FV2);
		}
		XqUm2Wyj.getCookieSpecs().register("easy", nCswghoG);
		XqUm2Wyj.getParams().setParameter(ClientPNames.COOKIE_POLICY, "easy");
		String TXbpytjc = Helper.getRemoteServer();
		try {
			HttpUriRequest oVBUzOKv = createRequest(vZKG9dRh);
			addHeader(vZKG9dRh, oVBUzOKv);
			HttpResponse D6wSGu5X = XqUm2Wyj.execute(oVBUzOKv);
			if (D6wSGu5X.getStatusLine().getStatusCode() == HttpStatus.SC_FORBIDDEN) {
				challengeProxy(TXbpytjc);
			}
			logger.info(Helper.count.incrementAndGet() + " Response received from "
					+ vZKG9dRh.getRequestURL().toString() + ", status is " + D6wSGu5X.getStatusLine());
			GUI.updateFetchCount();
			return D6wSGu5X;
		} catch (ClientProtocolException aLPeHL10) {
			logger.error("Fetch ClientProtocol Error", aLPeHL10);
			throw aLPeHL10;
		} catch (IOException FJAatVH5) {
			logger.error("Fetch IO Error", FJAatVH5);
			throw FJAatVH5;
		}
	}

}