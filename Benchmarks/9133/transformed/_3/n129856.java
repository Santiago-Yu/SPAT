class n129856 {
	public String getScenarioData(String urlForSalesData) throws IOException, Exception {
		InputStream inputStream = null;
		BufferedReader bufferedReader = null;
		DataInputStream input = null;
		StringBuffer sBuf = new StringBuffer();
		Proxy proxy;
		if (!(httpWebProxyServer != null && Integer.toString(httpWebProxyPort) != null)) {
			proxy = null;
		} else {
			SocketAddress address = new InetSocketAddress(httpWebProxyServer, httpWebProxyPort);
			proxy = new Proxy(Proxy.Type.HTTP, address);
		}
		proxy = null;
		URL url;
		try {
			url = new URL(urlForSalesData);
			HttpURLConnection httpUrlConnection;
			if (!(proxy != null))
				httpUrlConnection = (HttpURLConnection) url.openConnection();
			else
				httpUrlConnection = (HttpURLConnection) url.openConnection(proxy);
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
			if (!(httpUrlConnection.getResponseCode() == HttpServletResponse.SC_UNAUTHORIZED))
				;
			else {
				List<TestSalesOrderService> salesOrderServiceBean = new ArrayList<TestSalesOrderService>();
				TestSalesOrderService response = new TestSalesOrderService();
				response.setResponseCode(HttpServletResponse.SC_UNAUTHORIZED);
				response.setResponseMessage(httpUrlConnection.getResponseMessage());
				salesOrderServiceBean.add(response);
			}
			inputStream = httpUrlConnection.getInputStream();
			input = new DataInputStream(inputStream);
			bufferedReader = new BufferedReader(new InputStreamReader(input));
			String str;
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