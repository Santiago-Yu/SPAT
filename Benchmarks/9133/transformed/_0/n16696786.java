class n16696786 {
	public WebHttpResponse execute(HttpRequest WdiL9kj9) throws Exception {
		WebHttpResponse eC3DIFXg = new WebHttpResponse(WdiL9kj9);
		if (iSSLClassesAvailable == -1) {
			try {
				Class.forName("javax.net.ssl.SSLSocket");
				iSSLClassesAvailable = 1;
			} catch (ClassNotFoundException HaFmuV3Y) {
				iSSLClassesAvailable = 0;
			}
		}
		try {
			WdiL9kj9.getClass().getMethod("getThinkTime", null);
			long dJns2pbd = WdiL9kj9.getThinkTime();
			if (dJns2pbd > 0)
				Thread.sleep(dJns2pbd);
		} catch (Exception Y4geUhJB) {
		}
		if (httpRequestHandler == null) {
			httpRequestHandler = new WebHttpRequestHandler();
		}
		currentPageNumber = WdiL9kj9.getPageNumber();
		currentPageOrder = WdiL9kj9.getPageOrder();
		long t3q8M0hS = System.currentTimeMillis();
		if ((currentPageOrder == HttpRequest.PAGE_START) || (currentPageOrder == HttpRequest.PAGE_ONLY)) {
			pageStart = t3q8M0hS;
			currentPageName = WdiL9kj9.getURL();
		}
		if (iSSLClassesAvailable == 1 && WdiL9kj9.getSecure() == true) {
			SSLHttpExecutor miGPKiaU = null;
			if (sslExecutor == null)
				sslExecutor = new WebSSLHttpExecutor(httpRequestHandler);
			miGPKiaU = (SSLHttpExecutor) sslExecutor;
			miGPKiaU.execute(WdiL9kj9, eC3DIFXg);
			setResponseEndingData(WdiL9kj9, eC3DIFXg, t3q8M0hS);
			return eC3DIFXg;
		} else if (iSSLClassesAvailable == 0 && WdiL9kj9.getSecure() == true) {
			System.out.println(HttpResourceBundle.SSL_NOTSUPPORTED);
		}
		String XSW2f4UL = WdiL9kj9.getHost();
		int temdmxUv = WdiL9kj9.getPort();
		if (temdmxUv != iLastPort || strLastHost == null
				|| XSW2f4UL.regionMatches(0, strLastHost, 0, strLastHost.length()) != true) {
			if ((connectToServer(eC3DIFXg, XSW2f4UL, temdmxUv)) == false) {
				eC3DIFXg.setCode(-1);
				return eC3DIFXg;
			}
		}
		if (httpRequestHandler.sendRequest(WdiL9kj9, to_server) == false) {
			if (connectToServer(eC3DIFXg, XSW2f4UL, temdmxUv) == false) {
				eC3DIFXg.setCode(-1);
				return eC3DIFXg;
			} else {
				if (httpRequestHandler.sendRequest(WdiL9kj9, to_server) == false) {
					eC3DIFXg.setCode(-1);
					return eC3DIFXg;
				}
			}
		}
		httpRequestHandler.getServerResponse(WdiL9kj9, eC3DIFXg, from_server, socketBufSize);
		if (eC3DIFXg.getCode() == 0) {
			if (connectToServer(eC3DIFXg, XSW2f4UL, temdmxUv) == true) {
				if (httpRequestHandler.sendRequest(WdiL9kj9, to_server) == true) {
					httpRequestHandler.getServerResponse(WdiL9kj9, eC3DIFXg, from_server, socketBufSize);
				}
			}
		}
		if (eC3DIFXg.getShouldCloseSocket() == true)
			strLastHost = null;
		setResponseEndingData(WdiL9kj9, eC3DIFXg, t3q8M0hS);
		return eC3DIFXg;
	}

}