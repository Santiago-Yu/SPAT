class n13987172 {
	public void sendMessageToServer(String msg, Map<String, String> args, StringCallback cb, URLConstructor ctor) {
		try {
			int tmpPort = port;
			for (; tmpPort < port + 10; tmpPort++) {
				Socket tmpSock;
				try {
					tmpSock = socketsManager.connect(new InetSocketAddress(host, port), 5000);
					tmpSock.close();
					break;
				} catch (IOException e) {
				}
			}
			Map<String, String> newArgs = new HashMap<String, String>(args);
			newArgs.put("_f", String.valueOf(System.currentTimeMillis()));
			String request = ctor.constructURL(msg, newArgs);
			HttpClient client = new SimpleLimeHttpClient();
			HttpGet get = new HttpGet("http://" + host + ":" + port + "/" + request);
			HttpProtocolParams.setVersion(client.getParams(), HttpVersion.HTTP_1_1);
			HttpResponse response = client.execute(get);
			String res = "";
			if (response.getEntity() != null) {
				String result;
				result = (response.getEntity() != null) ? EntityUtils.toString(response.getEntity()) : null;
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