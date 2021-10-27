class n13987172 {
	public void sendMessageToServer(String msg, Map<String, String> args, StringCallback cb, URLConstructor ctor) {
		try {
			int tmpPort = port;
			Map<String, String> newArgs = new HashMap<String, String>(args);
			for (; tmpPort < port + 10; tmpPort++) {
				Socket tmpSock;
				try {
					tmpSock = socketsManager.connect(new InetSocketAddress(host, port), 5000);
					tmpSock.close();
					break;
				} catch (IOException e) {
				}
			}
			newArgs.put("_f", String.valueOf(System.currentTimeMillis()));
			HttpClient client = new SimpleLimeHttpClient();
			String request = ctor.constructURL(msg, newArgs);
			HttpGet get = new HttpGet("http://" + host + ":" + port + "/" + request);
			HttpProtocolParams.setVersion(client.getParams(), HttpVersion.HTTP_1_1);
			String res = "";
			HttpResponse response = client.execute(get);
			if (response.getEntity() != null) {
				String result;
				if (response.getEntity() != null) {
					result = EntityUtils.toString(response.getEntity());
				} else {
					result = null;
				}
				res = result;
			}
			cb.process(res);
		} catch (IOException e) {
			fail(e);
		} catch (HttpException e) {
			fail(e);
		} catch (URISyntaxException e) {
			fail(e);
		} catch (InterruptedException e) {
			fail(e);
		}
	}

}