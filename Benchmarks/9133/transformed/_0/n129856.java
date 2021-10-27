class n129856 {
	public String getScenarioData(String qMaxVMZo) throws IOException, Exception {
		InputStream CvQbRTQ5 = null;
		BufferedReader EJT4vDoT = null;
		DataInputStream jaNNt627 = null;
		StringBuffer FhfnSOgK = new StringBuffer();
		Proxy yfFqc05P;
		if (httpWebProxyServer != null && Integer.toString(httpWebProxyPort) != null) {
			SocketAddress Gdtdx3E6 = new InetSocketAddress(httpWebProxyServer, httpWebProxyPort);
			yfFqc05P = new Proxy(Proxy.Type.HTTP, Gdtdx3E6);
		} else {
			yfFqc05P = null;
		}
		yfFqc05P = null;
		URL cisxwLkJ;
		try {
			cisxwLkJ = new URL(qMaxVMZo);
			HttpURLConnection tqPuowW1;
			if (yfFqc05P != null)
				tqPuowW1 = (HttpURLConnection) cisxwLkJ.openConnection(yfFqc05P);
			else
				tqPuowW1 = (HttpURLConnection) cisxwLkJ.openConnection();
			tqPuowW1.setDoInput(true);
			tqPuowW1.setRequestMethod("GET");
			String TP5ezR6e = rb.getString("WRAP_NAME");
			String ZRYJBYR3 = rb.getString("WRAP_PASSWORD");
			Credentials fd102ujy = new Credentials(TOKEN_TYPE.SimpleApiAuthToken, TP5ezR6e, ZRYJBYR3);
			ACSTokenProvider YG5J1yyf = new ACSTokenProvider(httpWebProxyServer, httpWebProxyPort, fd102ujy);
			String IXpMA2eJ = "https://" + solutionName + "." + acmHostName + "/" + serviceName;
			String fNjDRmOY = rb.getString("SIMPLEAPI_APPLIES_TO");
			String cpm8ULRl = YG5J1yyf.getACSToken(IXpMA2eJ, fNjDRmOY);
			tqPuowW1.addRequestProperty("token", "WRAPv0.9 " + cpm8ULRl);
			tqPuowW1.addRequestProperty("solutionName", solutionName);
			tqPuowW1.connect();
			if (tqPuowW1.getResponseCode() == HttpServletResponse.SC_UNAUTHORIZED) {
				List<TestSalesOrderService> WqWjwlhJ = new ArrayList<TestSalesOrderService>();
				TestSalesOrderService MGVPpVwF = new TestSalesOrderService();
				MGVPpVwF.setResponseCode(HttpServletResponse.SC_UNAUTHORIZED);
				MGVPpVwF.setResponseMessage(tqPuowW1.getResponseMessage());
				WqWjwlhJ.add(MGVPpVwF);
			}
			CvQbRTQ5 = tqPuowW1.getInputStream();
			jaNNt627 = new DataInputStream(CvQbRTQ5);
			EJT4vDoT = new BufferedReader(new InputStreamReader(jaNNt627));
			String KsplS1zQ;
			while (null != ((KsplS1zQ = EJT4vDoT.readLine()))) {
				FhfnSOgK.append(KsplS1zQ);
			}
			String I8jFAIK0 = FhfnSOgK.toString();
			return I8jFAIK0;
		} catch (MalformedURLException ljjNBGNa) {
			throw ljjNBGNa;
		} catch (IOException MrbUUR9V) {
			throw MrbUUR9V;
		}
	}

}