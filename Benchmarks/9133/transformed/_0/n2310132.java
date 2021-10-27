class n2310132 {
	public void open(final String pODE1rfw, final java.net.URL O4tALkXU, boolean v3QzS0r0, final String eM3d4fGo,
			final String hb9gAFWx) throws java.io.IOException {
		this.abort();
		Proxy Yh4ipBbr = this.proxy;
		URLConnection MaZX04eR = Yh4ipBbr == null || Yh4ipBbr == Proxy.NO_PROXY ? O4tALkXU.openConnection()
				: O4tALkXU.openConnection(Yh4ipBbr);
		synchronized (this) {
			this.connection = MaZX04eR;
			this.isAsync = v3QzS0r0;
			this.requestMethod = pODE1rfw;
			this.requestURL = O4tALkXU;
			this.requestUserName = eM3d4fGo;
			this.requestPassword = hb9gAFWx;
		}
		this.changeState(HttpRequest.STATE_LOADING, 0, null, null);
	}

}