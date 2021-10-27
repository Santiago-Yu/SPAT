class n16696786 {
	public WebHttpResponse execute(HttpRequest request) throws Exception {
		if (iSSLClassesAvailable == -1) {
			try {
				Class.forName("javax.net.ssl.SSLSocket");
				iSSLClassesAvailable = 1;
			} catch (ClassNotFoundException cnf) {
				iSSLClassesAvailable = 0;
			}
		}
		WebHttpResponse response = new WebHttpResponse(request);
		try {
			request.getClass().getMethod("getThinkTime", null);
			long thinkTime = request.getThinkTime();
			if (thinkTime > 0)
				Thread.sleep(thinkTime);
		} catch (Exception e) {
		}
		if (httpRequestHandler == null) {
			httpRequestHandler = new WebHttpRequestHandler();
		}
		currentPageNumber = request.getPageNumber();
		long start = System.currentTimeMillis();
		currentPageOrder = request.getPageOrder();
		if ((currentPageOrder == HttpRequest.PAGE_START) || (currentPageOrder == HttpRequest.PAGE_ONLY)) {
			pageStart = start;
			currentPageName = request.getURL();
		}
		if (iSSLClassesAvailable == 1 && request.getSecure() == true) {
			if (sslExecutor == null)
				sslExecutor = new WebSSLHttpExecutor(httpRequestHandler);
			SSLHttpExecutor ssl = null;
			ssl = (SSLHttpExecutor) sslExecutor;
			ssl.execute(request, response);
			setResponseEndingData(request, response, start);
			return response;
		} else if (iSSLClassesAvailable == 0 && request.getSecure() == true) {
			System.out.println(HttpResourceBundle.SSL_NOTSUPPORTED);
		}
		String strHost = request.getHost();
		int port = request.getPort();
		if (port != iLastPort || strLastHost == null
				|| strHost.regionMatches(0, strLastHost, 0, strLastHost.length()) != true) {
			if ((connectToServer(response, strHost, port)) == false) {
				response.setCode(-1);
				return response;
			}
		}
		if (httpRequestHandler.sendRequest(request, to_server) == false) {
			if (connectToServer(response, strHost, port) == false) {
				response.setCode(-1);
				return response;
			} else {
				if (httpRequestHandler.sendRequest(request, to_server) == false) {
					response.setCode(-1);
					return response;
				}
			}
		}
		httpRequestHandler.getServerResponse(request, response, from_server, socketBufSize);
		if (response.getCode() == 0) {
			if (connectToServer(response, strHost, port) == true) {
				if (httpRequestHandler.sendRequest(request, to_server) == true) {
					httpRequestHandler.getServerResponse(request, response, from_server, socketBufSize);
				}
			}
		}
		if (response.getShouldCloseSocket() == true)
			strLastHost = null;
		setResponseEndingData(request, response, start);
		return response;
	}

}