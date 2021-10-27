class n16696786 {
	public WebHttpResponse execute(HttpRequest request) throws Exception {
		WebHttpResponse response = new WebHttpResponse(request);
		if (-1 == iSSLClassesAvailable) {
			try {
				Class.forName("javax.net.ssl.SSLSocket");
				iSSLClassesAvailable = 1;
			} catch (ClassNotFoundException cnf) {
				iSSLClassesAvailable = 0;
			}
		}
		try {
			request.getClass().getMethod("getThinkTime", null);
			long thinkTime = request.getThinkTime();
			if (thinkTime > 0)
				Thread.sleep(thinkTime);
		} catch (Exception e) {
		}
		if (null == httpRequestHandler) {
			httpRequestHandler = new WebHttpRequestHandler();
		}
		currentPageNumber = request.getPageNumber();
		currentPageOrder = request.getPageOrder();
		long start = System.currentTimeMillis();
		if ((HttpRequest.PAGE_START == currentPageOrder) || (HttpRequest.PAGE_ONLY == currentPageOrder)) {
			pageStart = start;
			currentPageName = request.getURL();
		}
		if (1 == iSSLClassesAvailable && true == request.getSecure()) {
			SSLHttpExecutor ssl = null;
			if (null == sslExecutor)
				sslExecutor = new WebSSLHttpExecutor(httpRequestHandler);
			ssl = (SSLHttpExecutor) sslExecutor;
			ssl.execute(request, response);
			setResponseEndingData(request, response, start);
			return response;
		} else if (0 == iSSLClassesAvailable && true == request.getSecure()) {
			System.out.println(HttpResourceBundle.SSL_NOTSUPPORTED);
		}
		String strHost = request.getHost();
		int port = request.getPort();
		if (port != iLastPort || null == strLastHost
				|| strHost.regionMatches(0, strLastHost, 0, strLastHost.length()) != true) {
			if (false == (connectToServer(response, strHost, port))) {
				response.setCode(-1);
				return response;
			}
		}
		if (false == httpRequestHandler.sendRequest(request, to_server)) {
			if (false == connectToServer(response, strHost, port)) {
				response.setCode(-1);
				return response;
			} else {
				if (false == httpRequestHandler.sendRequest(request, to_server)) {
					response.setCode(-1);
					return response;
				}
			}
		}
		httpRequestHandler.getServerResponse(request, response, from_server, socketBufSize);
		if (0 == response.getCode()) {
			if (true == connectToServer(response, strHost, port)) {
				if (true == httpRequestHandler.sendRequest(request, to_server)) {
					httpRequestHandler.getServerResponse(request, response, from_server, socketBufSize);
				}
			}
		}
		if (true == response.getShouldCloseSocket())
			strLastHost = null;
		setResponseEndingData(request, response, start);
		return response;
	}

}