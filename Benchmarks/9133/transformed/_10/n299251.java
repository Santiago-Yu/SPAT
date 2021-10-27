class n299251 {
	public ArrayList<String> getData() {
		ArrayList<String> data = new ArrayList<String>();
		URL address = null;
		String line = null;
		URLConnection urlconn = null;
		try {
			address = new URL(url);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		if (useProxy) {
			SocketAddress addr = new InetSocketAddress(ip, Integer.parseInt(port));
			java.net.Proxy httpProxy = new java.net.Proxy(java.net.Proxy.Type.HTTP, addr);
			try {
				urlconn = address.openConnection(httpProxy);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				urlconn = address.openConnection();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		BufferedReader buffreader = null;
		try {
			urlconn.connect();
		} catch (IOException e) {
			return null;
		}
		try {
			buffreader = new BufferedReader(new InputStreamReader(urlconn.getInputStream()));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			line = buffreader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		while (line != null) {
			data.add(line);
			try {
				line = buffreader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return data;
	}

}