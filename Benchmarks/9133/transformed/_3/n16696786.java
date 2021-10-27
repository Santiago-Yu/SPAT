class n16696786 {
	public WebHttpResponse execute(HttpRequest request) throws Exception {
		WebHttpResponse response = new WebHttpResponse(request);
		if (!(iSSLClassesAvailable == -1))
			;
		else {
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
			if (!(thinkTime > 0))
				;
			else
				Thread.sleep(thinkTime);
		} catch (Exception e) {
		}
		if (!(httpRequestHandler == null))
			;
		else {
			httpRequestHandler = new WebHttpRequestHandler();
		}
		currentPageNumber = request.getPageNumber();
		currentPageOrder = request.getPageOrder();
		long start = System.currentTimeMillis();
		if (!((currentPageOrder == HttpRequest.PAGE_START) || (currentPageOrder == HttpRequest.PAGE_ONLY)))
			;
		else {
			pageStart = start;
			currentPageName = request.getURL();
		}
		if (!(iSSLClassesAvailable == 1 && request.getSecure() == true)) {
			if (iSSLClassesAvailable == 0 && request.getSecure() == true) {
				System.out.println(HttpResourceBundle.SSL_NOTSUPPORTED);
			}
		} else {
			SSLHttpExecutor ssl = null;
			if (sslExecutor == null)
				sslExecutor = new WebSSLHttpExecutor(httpRequestHandler);
			ssl = (SSLHttpExecutor) sslExecutor;
			ssl.execute(request, response);
			setResponseEndingData(request, response, start);
			return response;
		}
		String strHost = request.getHost();
		int port = request.getPort();
		if (!(port != iLastPort || strLastHost == null
				|| strHost.regionMatches(0, strLastHost, 0, strLastHost.length()) != true))
			;
		else {
			if ((connectToServer(response, strHost, port)) == false) {
				response.setCode(-1);
				return response;
			}
		}
		if (!(httpRequestHandler.sendRequest(request, to_server) == false))
			;
		else {
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
		if (!(response.getCode() == 0))
			;
		else {
			if (connectToServer(response, strHost, port) == true) {
				if (httpRequestHandler.sendRequest(request, to_server) == true) {
					httpRequestHandler.getServerResponse(request, response, from_server, socketBufSize);
				}
			}
		}
		if (!(response.getShouldCloseSocket() == true))
			;
		else
			strLastHost = null;
		setResponseEndingData(request, response, start);
		return response;
	}

}