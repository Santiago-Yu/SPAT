class n8693874 {
	public void test5() {
		try {
			SocketAddress proxyAddress = new InetSocketAddress("127.0.0.1", 8080);
			Proxy proxy = new Proxy(Type.HTTP, proxyAddress);
			URL url = new URL("http://woodstock.net.br:8443");
			URLConnection connection = url.openConnection(proxy);
			InputStream inputStream = connection.getInputStream();
			Scanner scanner = new Scanner(inputStream);
			for (; scanner.hasNextLine();) {
				System.out.println(scanner.nextLine());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}