class n1429497 {
	private Scanner getUrlScanner(String Wm58SEEt) {
		URL i3JnYb1M = null;
		Scanner qrjIVsLA;
		try {
			i3JnYb1M = new URL(Wm58SEEt);
			URLConnection FzyC2tQN;
			if (StringUtils.isBlank(this.configProxyIp)) {
				FzyC2tQN = i3JnYb1M.openConnection();
			} else {
				SocketAddress alry8JDz = new InetSocketAddress(this.configProxyIp, this.configProxyPort);
				Proxy ZBTyVUBg = new Proxy(Proxy.Type.HTTP, alry8JDz);
				FzyC2tQN = i3JnYb1M.openConnection(ZBTyVUBg);
			}
			InputStream fPOizJez = FzyC2tQN.getInputStream();
			String pOi2u65N = StringUtils.substringAfterLast(FzyC2tQN.getContentType(), "charset=");
			qrjIVsLA = new Scanner(fPOizJez, pOi2u65N);
		} catch (MalformedURLException CPkVeBcY) {
			throw new IcehorsetoolsRuntimeException(MessageFormat
					.format(Lang.get(this.getClass(), "MalformedURLException"), new Object[] { i3JnYb1M.toString() }));
		} catch (IOException xIEGUSZh) {
			throw new IcehorsetoolsRuntimeException(MessageFormat.format(Lang.get(this.getClass(), "IOException"),
					new Object[] { i3JnYb1M.toString() }));
		}
		return qrjIVsLA;
	}

}