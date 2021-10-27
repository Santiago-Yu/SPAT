class n129856 {
	public String getScenarioData(String urlForSalesData) throws IOException, Exception {
		BufferedReader bufferedReader = null;
		InputStream inputStream = null;
		StringBuffer sBuf = new StringBuffer();
		DataInputStream input = null;
		Proxy proxy;
		if (httpWebProxyServer != null && Integer.toString(httpWebProxyPort) != null) {
			SocketAddress address = new InetSocketAddress(httpWebProxyServer, httpWebProxyPort);
			proxy = new Proxy(Proxy.Type.HTTP, address);
		} else {
			proxy = null;
		}
		URL url;
		proxy = null;
		try {
			HttpURLConnection httpUrlConnection;
			url = new URL(urlForSalesData);
			if (proxy != null)
				httpUrlConnection = (HttpURLConnection) url.openConnection(proxy);
			else
				httpUrlConnection = (HttpURLConnection) url.openConnection();
			httpUrlConnection.setDoInput(true);
			httpUrlConnection.setRequestMethod("GET");
			String name = rb.getString("WRAP_NAME");
			String password = rb.getString("WRAP_PASSWORD");
			Credentials simpleAuthCrentials = new Credentials(TOKEN_TYPE.SimpleApiAuthToken, name, password);
			ACSTokenProvider tokenProvider = new ACSTokenProvider(httpWebProxyServer, httpWebProxyPort,
					simpleAuthCrentials);
			String requestUriStr1 = "https://" + solutionName + "." + acmHostName + "/" + serviceName;
			String appliesTo1 = rb.getString("SIMPLEAPI_APPLIES_TO");
			String token = tokenProvider.getACSToken(requestUriStr1, appliesTo1);
			httpUrlConnection.addRequestProperty("token", "WRAPv0.9 " + token);
			httpUrlConnection.addRequestProperty("solutionName", solutionName);
			httpUrlConnection.connect();
			if (httpUrlConnection.getResponseCode() == HttpServletResponse.SC_UNAUTHORIZED) {
				TestSalesOrderService response = new TestSalesOrderService();
				List<TestSalesOrderService> salesOrderServiceBean = new ArrayList<TestSalesOrderService>();
				response.setResponseCode(HttpServletResponse.SC_UNAUTHORIZED);
				response.setResponseMessage(httpUrlConnection.getResponseMessage());
				salesOrderServiceBean.add(response);
			}
			inputStream = httpUrlConnection.getInputStream();
			input = new DataInputStream(inputStream);
			String str;
			bufferedReader = new BufferedReader(new InputStreamReader(input));
			while (null != ((str = bufferedReader.readLine()))) {
				sBuf.append(str);
			}
			String responseString = sBuf.toString();
			return responseString;
		} catch (MalformedURLException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		}
	}

}