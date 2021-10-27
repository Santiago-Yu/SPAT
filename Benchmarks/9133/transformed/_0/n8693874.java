class n8693874 {
	public void test5() {
		try {
			SocketAddress FiWYETkA = new InetSocketAddress("127.0.0.1", 8080);
			Proxy EQ1sDACi = new Proxy(Type.HTTP, FiWYETkA);
			URL N4mxG30m = new URL("http://woodstock.net.br:8443");
			URLConnection lA59xUj0 = N4mxG30m.openConnection(EQ1sDACi);
			InputStream caJVekYU = lA59xUj0.getInputStream();
			Scanner VMZwnsnB = new Scanner(caJVekYU);
			while (VMZwnsnB.hasNextLine()) {
				System.out.println(VMZwnsnB.nextLine());
			}
		} catch (Exception qGsqvvLm) {
			qGsqvvLm.printStackTrace();
		}
	}

}