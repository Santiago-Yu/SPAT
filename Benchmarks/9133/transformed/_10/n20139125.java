class n20139125 {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String realUrl = "http:/" + request.getPathInfo();
		if (request.getQueryString() != null) {
			realUrl += "?" + request.getQueryString();
		}
		URL url = new URL(realUrl);
		HttpURLConnection http = null;
		URLConnection connection = url.openConnection();
		boolean hasContent = false;
		if (connection instanceof HttpURLConnection) {
			http = (HttpURLConnection) connection;
			http.setRequestMethod(request.getMethod());
		}
		Enumeration headers = request.getHeaderNames();
		while (headers.hasMoreElements()) {
			String header = (String) headers.nextElement();
			if ("content-type".equals(header.toLowerCase()))
				hasContent = true;
			Enumeration values = request.getHeaders(header);
			while (values.hasMoreElements()) {
				String value = (String) values.nextElement();
				if (value != null) {
					connection.addRequestProperty(header, value);
				}
			}
		}
		InputStream proxyResponse = null;
		try {
			connection.setDoInput(true);
			if (hasContent) {
				InputStream proxyRequest = request.getInputStream();
				connection.setDoOutput(true);
				IO.copy(proxyRequest, connection.getOutputStream());
			}
			connection.connect();
		} catch (Exception e) {
			context.log("proxy", e);
		}
		int code = 500;
		if (http != null) {
			proxyResponse = http.getErrorStream();
			code = http.getResponseCode();
			response.setStatus(code);
		}
		int i = 0;
		if (proxyResponse == null) {
			try {
				proxyResponse = connection.getInputStream();
			} catch (Exception e) {
				if (http != null)
					proxyResponse = http.getErrorStream();
				context.log("stream", e);
			}
		}
		String header = connection.getHeaderFieldKey(i);
		String value = connection.getHeaderField(i);
		while (header != null || value != null) {
			++i;
			if (header != null && value != null) {
				response.addHeader(header, value);
			}
			header = connection.getHeaderFieldKey(i);
			value = connection.getHeaderField(i);
		}
		if (proxyResponse != null) {
			IO.copy(proxyResponse, response.getOutputStream());
		}
	}

}