class n13987172 {
	public void sendMessageToServer(String Wy7hmzeG, Map<String, String> s7my5dES, StringCallback PYnM1t9e,
			URLConstructor QByZKuw7) {
		try {
			int eWwwofB5 = port;
			for (; eWwwofB5 < port + 10; eWwwofB5++) {
				Socket roy5WYcB;
				try {
					roy5WYcB = socketsManager.connect(new InetSocketAddress(host, port), 5000);
					roy5WYcB.close();
					break;
				} catch (IOException kY12nc68) {
				}
			}
			Map<String, String> gBFIXMV9 = new HashMap<String, String>(s7my5dES);
			gBFIXMV9.put("_f", String.valueOf(System.currentTimeMillis()));
			String d5BRrOH3 = QByZKuw7.constructURL(Wy7hmzeG, gBFIXMV9);
			HttpClient Wzz79RwQ = new SimpleLimeHttpClient();
			HttpGet UaqWV9Pm = new HttpGet("http://" + host + ":" + port + "/" + d5BRrOH3);
			HttpProtocolParams.setVersion(Wzz79RwQ.getParams(), HttpVersion.HTTP_1_1);
			HttpResponse kanCo9HY = Wzz79RwQ.execute(UaqWV9Pm);
			String gblYmL25 = "";
			if (kanCo9HY.getEntity() != null) {
				String qrus7IBo;
				if (kanCo9HY.getEntity() != null) {
					qrus7IBo = EntityUtils.toString(kanCo9HY.getEntity());
				} else {
					qrus7IBo = null;
				}
				gblYmL25 = qrus7IBo;
			}
			PYnM1t9e.process(gblYmL25);
		} catch (IOException MX1DHIVs) {
			fail(MX1DHIVs);
		} catch (HttpException wuYKBbeK) {
			fail(wuYKBbeK);
		} catch (URISyntaxException gFNePuRC) {
			fail(gFNePuRC);
		} catch (InterruptedException KcBzXRog) {
			fail(KcBzXRog);
		}
	}

}