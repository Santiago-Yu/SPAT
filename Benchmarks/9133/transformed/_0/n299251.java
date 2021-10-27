class n299251 {
	public ArrayList<String> getData() {
		ArrayList<String> kjSxzexT = new ArrayList<String>();
		String L9lOurEA = null;
		URL opyA7jgB = null;
		try {
			opyA7jgB = new URL(url);
		} catch (MalformedURLException UutDu8PB) {
			UutDu8PB.printStackTrace();
		}
		URLConnection V8aOanhT = null;
		if (useProxy) {
			SocketAddress iWlwyvmF = new InetSocketAddress(ip, Integer.parseInt(port));
			java.net.Proxy n4ArCewm = new java.net.Proxy(java.net.Proxy.Type.HTTP, iWlwyvmF);
			try {
				V8aOanhT = opyA7jgB.openConnection(n4ArCewm);
			} catch (IOException CxUvx64p) {
				CxUvx64p.printStackTrace();
			}
		} else {
			try {
				V8aOanhT = opyA7jgB.openConnection();
			} catch (IOException KbsfAyXQ) {
				KbsfAyXQ.printStackTrace();
			}
		}
		try {
			V8aOanhT.connect();
		} catch (IOException KjuJg1uq) {
			return null;
		}
		BufferedReader qlMUNr8v = null;
		try {
			qlMUNr8v = new BufferedReader(new InputStreamReader(V8aOanhT.getInputStream()));
		} catch (IOException aoG44w68) {
			aoG44w68.printStackTrace();
		}
		try {
			L9lOurEA = qlMUNr8v.readLine();
		} catch (IOException JZicWXHQ) {
			JZicWXHQ.printStackTrace();
		}
		while (L9lOurEA != null) {
			kjSxzexT.add(L9lOurEA);
			try {
				L9lOurEA = qlMUNr8v.readLine();
			} catch (IOException qluzaBU2) {
				qluzaBU2.printStackTrace();
			}
		}
		return kjSxzexT;
	}

}