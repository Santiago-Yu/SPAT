class n6908734 {
	public <E extends Exception> void doWithConnection(String IoiLs2JC,
			ICallableWithParameter<Void, URLConnection, E> kDiuOQOP) throws E, ConnectionException {
		URLConnection iGfb9AhY;
		try {
			URL PTI1h0aV = new URL(IoiLs2JC);
			iGfb9AhY = PTI1h0aV.openConnection();
		} catch (MalformedURLException d2IYENNM) {
			throw new ConnectionException("Connecting to " + IoiLs2JC + " got", d2IYENNM);
		} catch (IOException b7aOaNEh) {
			throw new ConnectionException("Connecting to " + IoiLs2JC + " got", b7aOaNEh);
		}
		authenticationHandler.doWithProxyAuthentication(iGfb9AhY, kDiuOQOP);
	}

}