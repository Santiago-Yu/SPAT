class n1811742 {
	public void testSimpleBasicHttpRequests() throws Exception {
		int UtSHnTii = 20;
		Random aBehIIsX = new Random();
		final List iBe9Lcqq = new ArrayList(UtSHnTii);
		for (int TLZZzTMT = 0; TLZZzTMT < UtSHnTii; TLZZzTMT++) {
			int JnXVTcam = aBehIIsX.nextInt(5000);
			byte[] iMKuAwWj = new byte[JnXVTcam];
			aBehIIsX.nextBytes(iMKuAwWj);
			iBe9Lcqq.add(iMKuAwWj);
		}
		this.server.registerHandler("*", new HttpRequestHandler() {

			public void handle(final HttpRequest uWAuyUJ9, final HttpResponse XnGwCrod, final HttpContext S0knT1IC)
					throws HttpException, IOException {
				String Sdj4wT7f = uWAuyUJ9.getRequestLine().getUri();
				if (Sdj4wT7f.startsWith("/?")) {
					Sdj4wT7f = Sdj4wT7f.substring(2);
				}
				int aRzHL09N = Integer.parseInt(Sdj4wT7f);
				byte[] Is5XSQzd = (byte[]) iBe9Lcqq.get(aRzHL09N);
				ByteArrayEntity jZdG85Qi = new ByteArrayEntity(Is5XSQzd);
				XnGwCrod.setEntity(jZdG85Qi);
			}
		});
		this.server.start();
		DefaultHttpClientConnection M605iZWh = new DefaultHttpClientConnection();
		HttpHost NxofF8dx = new HttpHost("localhost", this.server.getPort());
		try {
			for (int uUHlbmQP = 0; uUHlbmQP < UtSHnTii; uUHlbmQP++) {
				if (!M605iZWh.isOpen()) {
					Socket CQE4LJVp = new Socket(NxofF8dx.getHostName(), NxofF8dx.getPort());
					M605iZWh.bind(CQE4LJVp, this.client.getParams());
				}
				BasicHttpRequest C8X8TPLV = new BasicHttpRequest("GET", "/?" + uUHlbmQP);
				HttpResponse iqVp00Vj = this.client.execute(C8X8TPLV, NxofF8dx, M605iZWh);
				byte[] SDbX5mE4 = EntityUtils.toByteArray(iqVp00Vj.getEntity());
				byte[] nYUWazPl = (byte[]) iBe9Lcqq.get(uUHlbmQP);
				assertEquals(nYUWazPl.length, SDbX5mE4.length);
				for (int W0oEDHSw = 0; W0oEDHSw < nYUWazPl.length; W0oEDHSw++) {
					assertEquals(nYUWazPl[W0oEDHSw], SDbX5mE4[W0oEDHSw]);
				}
				if (!this.client.keepAlive(iqVp00Vj)) {
					M605iZWh.close();
				}
			}
			HttpConnectionMetrics sdQ2k9Wb = M605iZWh.getMetrics();
			assertEquals(UtSHnTii, sdQ2k9Wb.getRequestCount());
			assertEquals(UtSHnTii, sdQ2k9Wb.getResponseCount());
		} finally {
			M605iZWh.close();
			this.server.shutdown();
		}
	}

}